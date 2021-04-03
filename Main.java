package application;


import java.io.FileInputStream;

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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main (String[] args){
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception{
		
		FileInputStream input = new FileInputStream("default"); // Insert the image path.
		Image image = new Image(input);
		BackgroundImage background = new BackgroundImage(image,
				 BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				 BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);		 
		String path = Register.createFile();
		stage.setTitle("Tela de cadastro");
		stage.show();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setBackground(new Background(background));
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		Scene scene = new Scene(grid, 400, 275);
		stage.setScene(scene);
		Text scenetitle = new Text("Tela de Login");
		Font font = Font.loadFont("default", 45); // Insert the font path.
		scenetitle.setFont(font);
		scenetitle.setTextAlignment(TextAlignment.CENTER);
		grid.add(scenetitle, 0, 0, 2, 1);
		Label userName = new Label("Usuario:");
		userName.setTextFill(Color.SNOW);
		grid.add(userName, 0, 1);
		Label pwd = new Label("Senha:");
		pwd.setTextFill(Color.SNOW);
		grid.add(pwd, 0, 2);
		PasswordField pwdBox = new PasswordField();
		grid.add(pwdBox, 1, 2);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		Button btn = new Button("     Entrar    ");
		Button btnC = new Button(" Cadastrar ");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BASELINE_CENTER);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(btnC);
		grid.add(hbBtn, 1, 4);
		
		btnC.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				if( userTextField.getText() != null && !userTextField.getText().isEmpty() ){
					String transferData = userTextField.getText() + " " + pwdBox.getText();
					Boolean addNewUser = Bridge.checkIfUserExists(path, transferData);
					System.out.println(Bridge.registerResponseOptions(addNewUser));
					if(addNewUser == true){
						Bridge.registerUser(path, transferData);
						actiontarget.setFill(Color.SNOW);
						actiontarget.setText("Cadastro realizado com sucesso!");
					}
					else if(addNewUser == false){
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Esse nome de usuário já está cadastrado!");
					}
					else actiontarget.setText("Não foi possível realizar o cadastro, tente outra hora, obrigado!");
				}
			}
		});
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e){
				/**  Deverá ser implementado junto com um modelo de sessão ativa.
				Boolean userLogged = false; // Armazena informação que indica se o usuário já está logado. */
				String transferData = userTextField.getText() + " " + pwdBox.getText();
				Boolean userNotExist = Bridge.checkIfUserExists(path, transferData);
				
				if(userNotExist == false){
					actiontarget.setFill(Color.SNOW);
					actiontarget.setText("Login realizado com sucesso!");	
				}

				else{
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Você não está cadastrado no sistema!");
				}
			}
	 	});
	}
}
