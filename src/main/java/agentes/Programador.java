package agentes;

import java.util.ArrayList;

import jade.core.Agent;
import modelos.Nivel;
import modelos.Tarefas;

public class Programador extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Tarefas> fila_programador = new ArrayList<Tarefas>();
	int id_programador;
	Nivel nivel_programador;
	
	public Programador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
