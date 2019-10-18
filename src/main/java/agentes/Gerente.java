package agentes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import modelos.Tarefa;

public class Gerente extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Programador> filaProgramadores = new ArrayList<Programador>();
	private List<Testador> filaTestadores = new ArrayList<Testador>();
	private Random random = new Random();

	public Gerente() {
	}

	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				
				// ESCUTA SE HÁ NOVOS PROGRAMADORES
				
				for (int i = 0; i < random.nextInt(filaProgramadores.size()) - 1; i++) {
					Tarefa tarefa = new Tarefa();
					System.out.println("Nova tarefa encontrada! Nível " + tarefa.getNivel() + "Duração de "
							+ tarefa.getDuracao() + " horas e prioridade nível " + tarefa.getPrioridade());
					Programador menor = null;
					for (int j = 0; j < filaProgramadores.size(); j++) {
						if (j == 0 || menor.getTempoTotalTarefas() > filaProgramadores.get(j).getTempoTotalTarefas()) {
							menor = filaProgramadores.get(j);
						}
					}
					// ENVIAR TAREFA PARA "menor"
				}
			}
		});
	}
}
