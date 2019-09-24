package dad.javafx.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private TextField nombreSentencia;
	private Button checkButton;
	private Label textoLabel;
	private int numeroAleatorio;
	int contador = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		numeroAleatorio();

		nombreSentencia = new TextField();
		nombreSentencia.setPromptText("0");
		nombreSentencia.setMaxWidth(100);

		textoLabel = new Label("Introduce un numero del 1 al 100");

		checkButton = new Button("Comprobar");
		checkButton.setDefaultButton(true);
		checkButton.setOnAction(e -> onComprobarButtonAction(e));

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(textoLabel, nombreSentencia, checkButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("Check Palindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {
		String numeroCadena = nombreSentencia.getText();
		try {
			int numero = Integer.parseInt(numeroCadena);

			if (numero == numeroAleatorio) {
				contador++;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado " + contador + " intentos \n\nVuelve a jugar y hazlo mejor");

				alert.showAndWait();
				contador = 0;
				numeroAleatorio();
			} else if (numero > numeroAleatorio) {
				contador++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("EL número a adivinar es menor a " + numero);

				alert.showAndWait();
			} else if (numero < numeroAleatorio){
				contador++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("EL número a adivinar es mayor a " + numero);

				alert.showAndWait();
			}
		} catch (Exception e2) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido");

			alert.showAndWait();
		}
		

	}

	private void numeroAleatorio() {
		numeroAleatorio = (int) (Math.random() * 100 + 1);
	}

	public static void main(String[] args) {
		launch(args);

	}

}
