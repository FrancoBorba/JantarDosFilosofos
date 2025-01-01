/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 24/05/2024
* Ultima alteracao.: 25/05/2024
* Nome.............: Principal.java
* Funcao...........: Classe principal do projeto de Produto-Consumidor/Jantar dos Filosofos
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.controllerJantar;

public class Principal extends Application {
  public static void main(String[] args) {
    launch(args);
  }

   /*
     * ***************************************************************
     * Metodo: start
     * Funcao: A chamada para start é uma parte do ciclo de vida da aplicação
     * JavaFX, que começa com o método launch da classe Application. O launch
     * inicializa o sistema JavaFX, o que eventualmente leva à chamada do método
     * start. Após start ser executado, a UI se torna visível para o usuário quando
     * você chama primaryStage.show().
     * escolhido junto com a velocidade inicial
     * Parametros: Stage
     * Retorno: void
     */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root =  FXMLLoader.load(getClass().getResource("/view/sceneJantar.fxml")); // carrega o fxml
    Scene scene = new Scene(root); // adiciona uma root na scene
    Image icon = new Image("image/icon.png"); // adiciona a imagem ao object image na variavel icon
    primaryStage.setResizable(false); // nao permite aumentar o stage
    primaryStage.getIcons().add(icon); // adiciona um favicon ao stage
    primaryStage.setTitle("Jantar dos filosofos"); // adiciona um titulo
    primaryStage.setScene(scene); // adiciona a cena no stage
    primaryStage.show(); // inicia
    primaryStage.setOnCloseRequest(e -> System.exit(0)); // encerra as thread quando o usario fecha a tela

  }
}
