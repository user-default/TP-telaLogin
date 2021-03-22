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
		
		stage.setTitle("Tela de cadastro");
		stage.show();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);
		
		Scene scene = new Scene(grid, 300, 275);
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
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Login realizado com sucesso!");
				
			}
		});
		
		
		
	}
	public static void trocaSenha() {
		
	}
}
