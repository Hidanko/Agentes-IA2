package agentes;

import java.util.ArrayList;

import jade.core.Agent;
import modelos.Fila_Tarefas;
import modelos.Tarefa;

public class Testador extends Agent{
	ArrayList<Tarefa> fila_testador = new ArrayList<Tarefa>();
	int id_testador;

	public Testador(int id) {
		this.id_testador = id;
	}
	
	public void verificaFila(ArrayList<Tarefa> fila_gerente) {

	}
	
	public void verificaTarefaAtiva() {

	}

}
