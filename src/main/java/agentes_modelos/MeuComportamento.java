package agentes_modelos;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MeuComportamento extends Behaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int i = 0;
	
	public MeuComportamento(Agent a) {
		super(a);
	}
	
	@Override
	public void action() {
		System.out.println("Ol� Mundo! ... Meu nomne � " + myAgent.getLocalName());
		i++;
	}

	@Override
	public boolean done() {
		return i >3;
	}
	
}
