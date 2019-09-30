/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import java.util.Iterator;

/**
 *
 * @author ballottin
 */
public class AgenteAlarmado extends Agent {

    /**
     * @param args the command line arguments
     */
    protected void setup (){
        addBehaviour (new OneShotBehaviour (this) {
            
        public void action(){
            ACLMessage msg = new ACLMessage (ACLMessage.INFORM);
            msg.addReceiver (new AID( "Bombeiro" ,AID.ISLOCALNAME));
            msg.setLanguage ("Português");
            msg.setOntology ("Emergência");
            msg.setContent ("Fogo");
            myAgent.send (msg);
            
            }
        });
    }
    
}
