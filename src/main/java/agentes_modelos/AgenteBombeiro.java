/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_modelos;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author ballottin
 */
public class AgenteBombeiro extends Agent {

    /**
     * @param args the command line arguments
     */
    protected void setup (){
        addBehaviour (new CyclicBehaviour(this){
        public void action ( ){
            ACLMessage msg = myAgent.receive();
            if (msg != null ) {
                String content = msg.getContent();
                if (content.equalsIgnoreCase( "Fogo")){
                    System.out.println("O agente " + msg.getSender().getName() + " avisou de um incêndio");
                    System.out.println("Vou ativar os procedimentos de combate ao incêndio!");
                }else{
                    block();
                }
                        
        }  
        } // fim do a c t i on ( )
        }); // fim do addBehaviour ( )
    }
    
}
