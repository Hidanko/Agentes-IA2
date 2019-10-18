package agentes;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import modelos.Nivel;
import modelos.Tarefa;
import modelos.TarefaStatus;

public class Programador extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	int id_programador;
	Nivel nivel_programador;
	
	public Programador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				
				// ESCUTA SE H� NOVAS TAREFAS PARA ELE
				// ESCUTA SE H� NOVOS TESTADORES
				
				if (tarefas.get(0).getDuracao() == tarefas.get(0).getTempoGasto()) {
					tarefas.get(0).setStatus(TarefaStatus.EM_TESTE);
					tarefas.get(0).setDuracao(tarefas.get(0).getDuracao() /2);
					Tarefa tarefaParaEnvio = tarefas.get(0);
					// ENVIAR PARA TESTADORES
					tarefas.remove(0);
				}
				
//				2. A cada turno -> Verificar se ultima tarefa o tempo de duracao = tempo gasto -> CASO SIM -> Enviar para testador && tarefa.status = EM_TESTE && tarefa.teste = RAND(1,3)
//						3. A cada turno -> CASO n찾o tenha tarefa ativa -> Verificar fila de retorno testadores -> CASO possuir tarefa -> priorizar a tarefa com maior prioridade
//						4. A cada turno -> CASO n찾o tenha tarefa ativa -> Verificar fila de tarefas atribuidas -> CASO possuir tarefa -> mover primeira da fila para ativa
//						5. A cada turno -> CASO tenha tarefa ativa -> Adicionar 1 em tempo gasto
}
		});
	}
	
	
	public int getTempoTotalTarefas() {
		int duracao = 0;
		for (Tarefa tarefa : tarefas) {
			duracao += tarefa.getDuracao() - tarefa.getTempoGasto();
		}
		return duracao;
	}
	
}
