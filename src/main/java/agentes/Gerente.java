package agentes;

import java.util.ArrayList;

import jade.core.Agent;
import modelos.Fila_Tarefas;
import modelos.Tarefas;

public class Gerente extends Agent{

	ArrayList<Tarefas> fila_gerente = new ArrayList<Tarefas>();
	ArrayList<Programador> fila_programadores = new ArrayList<Programador>();
	ArrayList<Testador> fila_testadores = new ArrayList<Testador>();
	
	public Gerente() {
	}

	
	public void criaTarefa() {
		Tarefas f = new Tarefas();
		this.fila_gerente.add(f);
	}
	
	public void alocaTarefa() {
		for (Tarefas tarefas : fila_gerente) {
			
		}
	}

}
