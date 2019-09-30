/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author ballottin
 */
public class MeuAgente extends Agent {

    /**
     * @param args the command line arguments
     */
    protected void setup (){
        System.out.println("Olá, Eu sou um agente");
        System.out.println( "Estou disparando meu comportamento...") ;
        addBehaviour(new MeuComportamento(this));
    }
    
}
