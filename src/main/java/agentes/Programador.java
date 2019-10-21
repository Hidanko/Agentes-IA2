package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import modelos.Nivel;
import modelos.Tarefa;
import modelos.TarefaStatus;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Programador extends Agent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Nivel nivelProgramador;
	
	public Programador() {
		super();
		Random r = new Random();
		nivelProgramador = Nivel.getByValor(r.nextInt(3)+1);

	}
	
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				
				// ESCUTA SE H� NOVAS TAREFAS PARA ELE (GERENTE
				// E TESTADORES)
				// ESCUTA SE H� NOVOS TESTADORES
				
				if (tarefas.get(0).getDuracao() == tarefas.get(0).getTempoGasto()) {
					tarefas.get(0).setStatus(TarefaStatus.EM_TESTE);
					tarefas.get(0).setDuracao(tarefas.get(0).getDuracao() /2);
					Tarefa tarefaParaEnvio = tarefas.get(0);
					// ENVIAR PARA TESTADORES
					tarefas.remove(0);
				}

				if (tarefas.size() > 0) {

					if (tarefas.get(0).getStatus() == TarefaStatus.PENDENTE) {
						tarefas.get(0).setStatus(TarefaStatus.EM_DESENVOLVIMENTO);
					}
					tarefas.get(0).setTempoGasto(tarefas.get(0).getTempoGasto() + 1);

				}
}
		});
	}
	private int indexTarefaMaiorPrioridade(){
		int index = -1, valor = -1;
		for(int i = 0; i < tarefas.size(); i++){
			if (i == 0 || tarefas.get(i).getPrioridade() > valor){
				valor = tarefas.get(i).getPrioridade();
				index = i;
			}
		}
		return index;
	}
	
	
	protected int getTempoTotalTarefas() {
		AtomicInteger duracao = new AtomicInteger();
		for (Tarefa tarefa : tarefas) {
			duracao.addAndGet(tarefa.getDuracao() - tarefa.getTempoGasto());
		}
		return duracao.get();
	}
	
}
