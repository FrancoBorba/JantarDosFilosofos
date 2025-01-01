/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 05/06/2024
* Ultima alteracao.: 05/06/2024
* Nome.............: Filosofo.java
* Funcao...........: Classe que funcionara como uma Thread representando o filosofo
*************************************************************** */
package model;




import controller.controllerJantar;
import javafx.scene.control.Slider;



public class Filosofo  extends Thread{

  private final int i; // numero do filosofo  

 private Slider velocidadePensando , velocidadeComendo; 
 private boolean paused = false;

  /*
   * ***************************************************************
   * Metodo: Construtor do filosofo
   * Funcao: instancia a thread com seu identificado(i) , velocidades do slider e sua bolha de pensamento
   * Parametros: id , Slider que retorna a velocidade de comer e pensar , imagem do pensamento
   */
  public  Filosofo(int i , Slider velocidadePensando , Slider velocidadeComendo ){
    this.i = i;
    this.velocidadeComendo = velocidadeComendo;
    this.velocidadePensando = velocidadePensando;
  
    
  }
 


   /*
   * ***************************************************************
   * Metodo: run
   * Funcao: Funciona como o metodo main da Thread , executa todo o codigo da Thread
   * Parametros: void
   * Retorno: void
   */
  public void run(){
    while (true) {
      //System.out.println("Filosofo " + i + " - Paused: " + paused);
      try {
        while (paused) { // verifica se o filosofo esta pausado
          Thread.sleep(100); // dorme enquanto estiver
          if(!paused){ // caso não esteja sai do while
            break;
          }
        }
        
           pensar();
            while (paused) { // verifica se o filosofo esta pausado
          Thread.sleep(100); // dorme enquanto estiver
          if(!paused){ // caso não esteja sai do while
            break;
          }
        }
        controle.pegaGarfos(i);
        
        comer();
          while (paused) {
          Thread.sleep(100);
          if(!paused){
            break;
          }
        }
        controle.devolverGarfos(i);
      while (paused) { // verifica se o filosofo esta pausado
          Thread.sleep(100); // dorme enquanto estiver
          if(!paused){ // caso não esteja sai do while
            break;
          }
        }
   
        
     
        
       
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
     
    
    }
  }

  controllerJantar controle = new controllerJantar();
  public void setControlador(controllerJantar controle){
    this.controle = controle;
  }

    /*
   * ***************************************************************
   * Metodo: pensar
   * Funcao: mostra a animação de pensar
   * Parametros: void
   * ***************************************************************
   */
   public void pensar() throws InterruptedException {

    controle.pensar(i);
   Filosofo.sleep((long) (50/velocidadePensando.getValue() * 1000));
      
   
    }

       /*
   * ***************************************************************
   * Metodo: comer
   * Funcao: mostra a animação de comer
   * Parametros: void
   * ***************************************************************
   */

    public void comer() throws InterruptedException{
   
      controle.comer(i);
      Filosofo.sleep((long) (50/velocidadeComendo.getValue() * 1000));
    }

   
        /*
   * ***************************************************************
   * Metodo: pausarFilosofo
   * Funcao: controlar a variavel boolean que define se o fiosofo esta ou nao pausado
   * Parametros: void
   * ***************************************************************
   */
  public  void pausarFiloso() throws InterruptedException {
        paused = true;
       
    }

        /*
   * ***************************************************************
   * Metodo: despausarFilosofo
   * Funcao: controlar a variavel boolean que define se o fiosofo esta ou nao pausado
   * Parametros: void
   * ***************************************************************
   */

    public  void despausarFiloso() throws InterruptedException {
        paused = false;
       
    }
  

}


   



  
