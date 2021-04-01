package application;

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
		
		String path = "/tmp/file.txt";

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

		
		btnC.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if( userTextField.getText() != null && !userTextField.getText().isEmpty() ) {
					String transferData = userTextField.getText() + " " + pwdBox.getText();
					Boolean addNewUser = Bridge.checkIfUserExists(path, transferData);
					System.out.println(Bridge.registerResponseOptions(addNewUser));
					if(addNewUser == true) {
						Bridge.registerUser(path, transferData);
						actiontarget.setFill(Color.BLACK);
						actiontarget.setText("Cadastro realizado com sucesso!");
					}
					else if(addNewUser == false) actiontarget.setText("Esse nome de usuário já está cadastrado!");
					else actiontarget.setText("Não foi possível realizar o cadastro, tente outra hora, obrigado!");
				}
			}
		});
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e) {
				String transferData = userTextField.getText() + " " + pwdBox.getText();
				Boolean userNotExist = Bridge.checkIfUserExists(path, transferData);
				System.out.println(userNotExist);
				if(userNotExist == false) {
					//System.out.println("What's happened?");
					actiontarget.setFill(Color.BLACK);
					actiontarget.setText("Login realizado com sucesso!");	
				}
				else {
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Você não está cadastrado no sistema!");
				}
			}

	 	});
	}

}