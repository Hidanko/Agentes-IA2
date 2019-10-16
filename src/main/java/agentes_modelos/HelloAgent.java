package agentes_modelos;

import java.util.Iterator;
import jade.core.Agent;
import jade.core.AID ;

public class HelloAgent extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void setup() {
		System.out.println("Hello World. Eu sou um agente!");
		System.out.println("Todas as minhas informa¸c~oes : \n" + getAID());
		System.out.println("Meu nome local ´e " + getAID().getLocalName());
		System.out.println("Meu nome global (GUID) ´e" + getAID().getName());
		System.out.println("Meus endere¸cos s~ao:");
		@SuppressWarnings("rawtypes")
		Iterator it = getAID().getAllAddresses();
		while (it.hasNext()) {
			System.out.println("- " + it.next());
		}

	}

}
