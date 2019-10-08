/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import jade.core.Agent;

/**
 *
 * @author ballottin
 */
public class MeuAgente extends Agent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @param args the command line arguments
     */
    protected void setup (){
        System.out.println("Olá, Eu sou um agente");
        System.out.println( "Estou disparando meu comportamento...") ;
        addBehaviour(new MeuComportamento(this));
    }
    
}
