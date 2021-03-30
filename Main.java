package application;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Persistence needData = new Persistence();
		ArrayList<Persistence> persistence = new ArrayList<Persistence>();
		persistence.add(new Persistence());
		stage.setTitle("Tela de cadastro");
		stage.show();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		
		Scene scene = new Scene(grid, 400, 275);
		stage.setScene(scene);
		
		Text scenetitle = new Text("Bem vindo!");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 1, 0, 2, 1);
		
		Label userName = new Label("Usuario:");
		grid.add(userName, 0, 1);
		Label pwd = new Label("Senha:");
		grid.add(pwd, 0, 2);
		
		PasswordField pwdBox = new PasswordField();
		grid.add(pwdBox, 1, 2);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		Button btn = new Button("Entrar");
		Button btnC = new Button("Cadastrar");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(btnC);
		grid.add(hbBtn, 1, 4);
		
		
		/*
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e) {
				Boolean result = null;
				if( userTextField.getText() != null && !userTextField.getText().isEmpty() ){
					needData.setName(userTextField.getText());
					needData.setPassword(pwdBox.getText());
					//result = Persistence.check(persistence, needData);
					//needData.setName(null);
					//needData.setPassword(null);
					if(result == true) {
						actiontarget.setFill(Color.ALICEBLUE);
						actiontarget.setText("Login realizado com sucesso!");
					}
					else {
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Você não está cadastrado no sistema!");
					}
				}
				
				
			}
		});*/
		
		btnC.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				
				//Boolean validator = null;
				String user;
				String pwd;
				int position = 0;
				
				if( userTextField.getText() != null && !userTextField.getText().isEmpty() ) {
					needData.setName(userTextField.getText());
					needData.setPassword(pwdBox.getText());
					
					for(int i = 0; i < persistence.size(); i++) {
						user = persistence.get(i).getName();
						pwd = persistence.get(i).getPassword();
						if( (needData.getName() == user) && (needData.getPassword() == pwd)) {
							actiontarget.setText("Cadastro já existente!");
							position = i;
							break;
						}
						
					}
					if(position == 0) {
						persistence.add(needData);
						actiontarget.setText("Cadastro realizado!");
					}
					
					/*
					for(int i = 0; i <= persistence.size(); i++) {
						
						if(persistence.get(i) == needData) {
							validator = true;
						}
					}
					if(validator == true) {
						actiontarget.setText("Já existe um cadastro com essas credenciais!");
					}
					else {
						persistence.add(needData);
						actiontarget.setText("Cadastro realizado");
					}
					//checker(validator, persistence, needData);
					//result = Persistence.register(persistence, needData);
					//result = Persistence.check(persistence, needData);
					//needData.setName(null);
					//needData.setPassword(null);
					//if(validator == false)//result == false) {
						//Persistence.register(persistence, needData);
					//	actiontarget.setText("Cadastro realizado com sucesso!");
					
					
					//	else if(validator == true)//(result == true) 
						//	System.out.println("Você já está cadastrado no sistema!");
					*/
				}
			}
		});
		
    btn.setOnAction(new EventHandler<ActionEvent>(){
			String user;
			String pwd;
			Boolean validator = null;
			
			@Override
			public void handle(ActionEvent e) {
				
				if( userTextField.getText() != null && !userTextField.getText().isEmpty() ) {
					needData.setName(userTextField.getText());
					needData.setPassword(pwdBox.getText());
					for(int i = 0; i < persistence.size(); i++) {
						user = persistence.get(i).getName();
						pwd = persistence.get(i).getPassword();
						if( (needData.getName() == user) && (needData.getPassword() == pwd) ) {
							validator = true;
							break;
						}
						else
							validator = false;
					}
					
					if(validator == true) {
						actiontarget.setFill(Color.ALICEBLUE);
						actiontarget.setText("Login realizado com sucesso!");
					}
					else {
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Você não está cadastrado no sistema!");
					}
				}
				
				
			}
			/*
			public Boolean checker(ArrayList<Persistence> persistence, String user, String pwd) {
				int position = 0;
				for(int i = 0; i < persistence.size(); i++) {
					user = persistence.get(i).getName();
					pwd = persistence.get(i).getPassword();
					if(needData.getName() == user && needData.getPassword() == pwd) {
						System.out.println("Login realizado!");
						position = i;
						return true;
					}
					else {
						position = -1;
					}
				}
				if(position == -1) {
					System.out.println("Login não existe!");
				}
				return null;
				
			}*/
		});
	}

}
