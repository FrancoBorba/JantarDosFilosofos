/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 05/05/2024
* Ultima alteracao.: 05/06/2024
* Nome.............: controllerJantar
* Funcao...........: controle da cena do jantar dos filosofos
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Filosofo;

 

public class controllerJantar implements Initializable {

  @FXML
 private ImageView bolhaLeclerc , bolhaMax , bolhaNoris , bolhaHamilton , bolhaAlonso; // imagens das bolhas de pensamento

 @FXML
 private ImageView garfo1 , garfo2, garfo3, garfo4, garfo5; // imagens dos garfos 

  // Slider da velocidade para pensar
 @FXML
 private Slider pensarAlonso, pensarHamilton , pensarLeclerc , pensarMax , pensarNoris;

  // slider da velocidade para comer
 @FXML 
 private Slider comerAlonso , comerHamilton , comerLeclerc , comerMax , comerNoris;

 @FXML 
 private Button pausarLeclerc, pausarMax, pausarNoris , pausarAlonso , pausarHamilton;

  // estados dos filosofos
   private int pensando = 0; 
  private int fome = 1;
  private int comendo =2;

  




  // semaforos
  private Semaphore mutex = new Semaphore(1); // quer dizer que só uma thread tem permissao de acessar o semaforo
  private Semaphore filosofosSemaforos [] = {new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0), new Semaphore(0)};

  private int estadosFilosfos [] = { pensando , pensando , pensando , pensando , pensando}; // todos os filosofos comecam pensando

 // instancia dos filosofos
 Filosofo max , leclerc , alonso , norris , hamilton;



  @Override
  public void initialize(URL location, ResourceBundle resources) {

    
  
  // inicializando os filosofos
      max = new Filosofo(0 , pensarMax , comerMax);
       leclerc = new Filosofo(1 , pensarLeclerc , comerLeclerc);
       norris = new Filosofo(2 , pensarNoris , comerNoris);
      alonso = new Filosofo(3 , pensarAlonso,comerAlonso);
       hamilton = new Filosofo(4 , pensarHamilton , comerHamilton);
       
     

  // inicializando os controladores

    max.setControlador(this);
    leclerc.setControlador(this);
    norris.setControlador(this);
    alonso.setControlador(this);
    hamilton.setControlador(this);
      

  // inicializando as threads
    max.start();
    leclerc.start();
    norris.start();
    alonso.start();
    hamilton.start();


  
    
  } // fim do initialize






   /*
   * ***************************************************************
   * Metodo: pensar
   * Funcao: mostra a animação de pensar
   * Parametros: void
   * ***************************************************************
   */
   public void pensar(int i) throws InterruptedException {
    Image bolhaPensando = new Image(getClass().getResourceAsStream("/image/pensandoBolha.png"));
    Platform.runLater(() -> {
        switch (i) {
            case 0: // max verstappen
                bolhaMax.setImage(bolhaPensando);
                bolhaMax.setVisible(true);
              // System.out.println("Max está pensando");
                break;
            case 1: 
                bolhaLeclerc.setImage(bolhaPensando);
                bolhaLeclerc.setVisible(true);
              //  System.out.println("Leclerc está pensando");
                break;
            case 2:
                bolhaNoris.setImage(bolhaPensando);
                bolhaNoris.setVisible(true);
              //  System.out.println("Noris está pensando");
                break;
            case 3:
                bolhaAlonso.setImage(bolhaPensando);
                bolhaAlonso.setVisible(true);
             //   System.out.println("Alonso está pensando");
                break;
            case 4:
                bolhaHamilton.setImage(bolhaPensando);
                bolhaHamilton.setVisible(true);
              //  System.out.println("Hamilton está pensando");
                break;
            default:
                break;
        }
    });
}

 /*
   * ***************************************************************
   * Metodo: pararDePensar
   * Funcao: mostra a animação de pensar
   * Parametros: void
   * ***************************************************************
   */
  public void pararDePensar(int i) throws InterruptedException {
    Platform.runLater(() -> {
        Image bolhaFome = new Image(getClass().getResourceAsStream("/image/fomeBolha.png"));
        switch (i) {
            case 0:
                bolhaMax.setImage(bolhaFome);
              //  System.out.println("Max está com fome");
                break;
            case 1:
                bolhaLeclerc.setImage(bolhaFome);
              //  System.out.println("Leclerc está com fome");
                break;
            case 2:
                bolhaNoris.setImage(bolhaFome);
             //   System.out.println("Noris está com fome");
                break;
            case 3:
                bolhaAlonso.setImage(bolhaFome);
              //  System.out.println("Alonso está com fome");
                break;
            case 4:
                bolhaHamilton.setImage(bolhaFome);
              //  System.out.println("Hamilton está com fome");
                break;
            default:
                break;
        }
    });
}
public void comer(int i) {
    Platform.runLater(() -> {
        Image bolhaComendo = new Image(getClass().getResourceAsStream("/image/comendoBolha.png"));
        switch (i) {
            case 0: // max verstappen
                bolhaMax.setImage(bolhaComendo);
              //  System.out.println("Max está comendo");
                break;
            case 1:
                bolhaLeclerc.setImage(bolhaComendo);
              //  System.out.println("Leclerc está comendo");
                break;
            case 2:
                bolhaNoris.setImage(bolhaComendo);
               // System.out.println("Noris está comendo");
                break;
            case 3:
                bolhaAlonso.setImage(bolhaComendo);
               // System.out.println("Alonso está comendo");
                break;
            case 4:
                bolhaHamilton.setImage(bolhaComendo);
               // System.out.println("Hamilton está comendo");
                break;
            default:
                break;
        }
    });
}

   /*
   * ***************************************************************
   * Metodo: pegarGarfos
   * Funcao: Pegar os garfos para o filosofo comer
   * Parametros: Identificado do filosofo
   * ***************************************************************
   */
  public void pegaGarfos(int i) throws InterruptedException{
    mutex.acquire(); // bloqueia a zona critica

    estadosFilosfos[i] = fome; // muda do estado de comendo para estado de fome
   
    testarGarfos(i); // testa se os filosofos a direita e esquerda estao comendo
    

    mutex.release(); // libera a zona critica

    pararDePensar(i); // como o filosofo entrou no estado de fome para de pensar


    filosofosSemaforos[i].acquire(); // bloqueia o semaforo do filosofo 
  }

  public void devolverGarfos(int i) throws InterruptedException{
    mutex.acquire(); // bloqueia a zona critia
    estadosFilosfos[i] = pensando; // filosofo volta para o estado de pensando
    testarGarfos((i+5-1)%5); // testar filosofo da esquerda
    testarGarfos((i+1)%5); // testar filosofo da direita
    mutex.release();
    pensar(i); // o filosofo volta a pensar
  }

  
      /*
   * ***************************************************************
   * Metodo: testarGarfos
   * Funcao: verificar se os filosofos da esquerda e direita estao comendo
   * Parametros: Identificacao do filosofo
   * ***************************************************************
   */
  public void testarGarfos(int i){
    if( (estadosFilosfos[i] == fome) && (estadosFilosfos[(i-1+5)%5] != comendo) && (estadosFilosfos[(i+1)%5] != comendo)){
      // se o filosofo estiver com fome e os filosofos da direita e esquerda nao estiverem comendo ele pode comer
      estadosFilosfos[i] = comendo;
      filosofosSemaforos[i].release();   // libera o semaforo do filosofo
    }
  }

     @FXML
    void resetarAnimacao(MouseEvent event) throws InterruptedException {


      Image bolhaInicial = new Image(getClass().getResourceAsStream("/image/pensandoBolha.png"));

     


        Platform.runLater(() -> {
            bolhaMax.setImage(bolhaInicial);
            bolhaLeclerc.setImage(bolhaInicial);
            bolhaNoris.setImage(bolhaInicial);
            bolhaAlonso.setImage(bolhaInicial);
            bolhaHamilton.setImage(bolhaInicial);

           // System.out.println("Todas as animações foram resetadas para o estado inicial.");
        });

        // Resetando os estados dos filósofos
        for (int i = 0; i < 5; i++) {
            estadosFilosfos[i] = pensando;
        }
        // Resetando os semaforos
        mutex = new Semaphore(1); 
        filosofosSemaforos = new Semaphore[5];

        for(int i=0 ; i < 5 ; i++){
          filosofosSemaforos[i] = new Semaphore(0);
        }

        pensarAlonso.setValue(10);
        pensarHamilton.setValue(10);
        pensarLeclerc.setValue(10);
        pensarMax.setValue(10);
        pensarNoris.setValue(10);
        comerAlonso.setValue(10);
        comerHamilton.setValue(10);
        comerNoris.setValue(10);
        comerLeclerc.setValue(10);
        comerMax.setValue(10);

        leclerc.despausarFiloso();
        max.despausarFiloso();
        norris.despausarFiloso();
        alonso.despausarFiloso();
        hamilton.despausarFiloso();

        pausarLeclerc.setText("Pausar");
        pausarMax.setText("Pausar");
        pausarHamilton.setText("Pausar");
        pausarNoris.setText("Pausar");
        pausarAlonso.setText("Pausar");



    }


     /*
   * ***************************************************************
   * Metodo: pausarLeclerc
   * Funcao: pausar a thread que reppresenta o filosofo
   * Parametros: action event
   * ***************************************************************
   */
   public void pausarLeclerc(ActionEvent event) throws InterruptedException {
     if(pausarLeclerc.getText().equals("Pausar")){
      pausarLeclerc.setText("Despausar");
      leclerc.pausarFiloso();
     }else{
      pausarLeclerc.setText("Pausar");
      leclerc.despausarFiloso();
     }
       
}

     /*
   * ***************************************************************
   * Metodo: pausarMax
   * Funcao: pausar a thread que reppresenta o filosofo
   * Parametros: action event
   * ***************************************************************
   */
 public void pausarMax(ActionEvent event) throws InterruptedException {
     if(pausarMax.getText().equals("Pausar")){
      pausarMax.setText("Despausar");
      max.pausarFiloso();
     }else{
      pausarMax.setText("Pausar");
      max.despausarFiloso();
     }
       
}

     /*
   * ***************************************************************
   * Metodo: pausarHamilton
   * Funcao: pausar a thread que reppresenta o filosofo
   * Parametros: action event
   * ***************************************************************
   */
 public void pausarHamilton(ActionEvent event) throws InterruptedException {
     if(pausarHamilton.getText().equals("Pausar")){
      pausarHamilton.setText("Despausar");
      hamilton.pausarFiloso();
     }else{
      pausarHamilton.setText("Pausar");
      hamilton.despausarFiloso();
     }
       
}

     /*
   * ***************************************************************
   * Metodo: pausarNoris
   * Funcao: pausar a thread que reppresenta o filosofo
   * Parametros: action event
   * ***************************************************************
   */
 public void pausarNoris(ActionEvent event) throws InterruptedException {
     if(pausarNoris.getText().equals("Pausar")){
      pausarNoris.setText("Despausar");
      norris.pausarFiloso();
     }else{
      pausarNoris.setText("Pausar");
      norris.despausarFiloso();
     }
       
}

   /*
   * ***************************************************************
   * Metodo: pausarAlonso
   * Funcao: pausar a thread que reppresenta o filosofo
   * Parametros: action event
   * ***************************************************************
   */
 public void pausarAlonso(ActionEvent event) throws InterruptedException {
     if(pausarAlonso.getText().equals("Pausar")){
      pausarAlonso.setText("Despausar");
      alonso.pausarFiloso();
     }else{
      pausarAlonso.setText("Pausar");
      alonso.despausarFiloso();
     }
       
}
}
