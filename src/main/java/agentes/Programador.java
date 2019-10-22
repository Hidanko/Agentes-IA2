package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import main.Main;
import modelos.Nivel;
import modelos.Tarefa;
import modelos.TarefaStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Programador extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
	private Nivel nivelProgramador;
	private String nome;

	public Programador() {
		super();
		Random r = new Random();
		nivelProgramador = Nivel.getByValor(r.nextInt(3) + 1);

		System.out.println("enviado");
	}

	protected void setup() {
		
		nome = (String)getArguments()[0];
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("Gerente", AID.ISLOCALNAME));
		msg.setLanguage("Português");
		msg.setOntology("Aviso");
		msg.setContent("Novo programador");
		try {
			msg.setContentObject(this);
		} catch (IOException e) {
			System.out.println("Falha ao serializar objeto");
			e.printStackTrace();
		}
		send(msg);
		System.out.println(
				"Novo programador " + nivelProgramador + " chamado " + getLocalName() + " entrou para a empresa!");
		addBehaviour(new CyclicBehaviour(this) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void action() {
				block(Main.delay);
				System.out.println(getName());
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					System.out.println(nome +" recebeu nova tarefa");
					String content = msg.getContent();
//					if (msg.getAllReceiver()) {
					try {
						Tarefa p = (Tarefa) msg.getContentObject();
						tarefas.add(p);
						System.out.println("Novo programador encontrado!");
					} catch (UnreadableException e) {
						System.out.println("Falha ao ler objeto serializado");
						e.printStackTrace();
					}
//					}
				}

				// ESCUTA SE H� NOVAS TAREFAS PARA ELE (GERENTE
				// E TESTADORES)
				// ESCUTA SE H� NOVOS TESTADORES
				if (tarefas.size() > 0) {

					if (tarefas.get(0).getDuracao() == tarefas.get(0).getTempoGasto()) {
						tarefas.get(0).setStatus(TarefaStatus.EM_TESTE);
						tarefas.get(0).setDuracao(tarefas.get(0).getDuracao() / 2);
						Tarefa tarefaParaEnvio = tarefas.get(0);
						// ENVIAR PARA TESTADORES
						tarefas.remove(0);
					}

					if (tarefas.get(0).getStatus() == TarefaStatus.PENDENTE) {
						tarefas.get(0).setStatus(TarefaStatus.EM_DESENVOLVIMENTO);
					}
					tarefas.get(0).setTempoGasto(tarefas.get(0).getTempoGasto() + 1);
					System.out.println(myAgent.getName() + " trabalhou por uma hora");

				}
			}
		});
	}

	private int indexTarefaMaiorPrioridade() {
		int index = -1, valor = -1;
		for (int i = 0; i < tarefas.size(); i++) {
			if (i == 0 || tarefas.get(i).getPrioridade() > valor) {
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
