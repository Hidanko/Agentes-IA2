package agentes;

import java.util.ArrayList;

import jade.core.Agent;
import modelos.Fila_Tarefas;
import modelos.Tarefas;

public class Testador extends Agent{
	ArrayList<Tarefas> fila_testador = new ArrayList<Tarefas>();
	int id_testador;

	public Testador(int id) {
		this.id_testador = id;
	}
	
	public void verificaFila(ArrayList<Tarefas> fila_gerente) {

	}
	
	public void verificaTarefaAtiva() {

	}

}
