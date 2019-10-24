package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import main.Main;
import modelos.ListaFuncionarios;
import modelos.Nivel;
import modelos.Tarefa;
import modelos.TarefaStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		addBehaviour(new TickerBehaviour(this, Main.delay) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void onTick() {
				System.out.println(nome);
				// Escuta se há novas tarefas para ele
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					System.out.println(nome +" recebeu nova tarefa");
					String content = msg.getContent();
//					if (msg.getAllReceiver()) {
					try {
						if (Tarefa.class.isInstance(msg.getContentObject())) {
							Tarefa p = (Tarefa) msg.getContentObject();
							tarefas.add(p);
							System.out.println(nome+" recebeu uma nova tarefa!");
						} else{
							System.out.println("Nao era tarefa");
						}
					} catch (UnreadableException e) {
						System.out.println("Falha ao ler objeto serializado");
						e.printStackTrace();
					}
				}

				if (tarefas.size() > 0) {

					if (tarefas.get(0).getStatus() == TarefaStatus.PENDENTE) {
						tarefas.get(0).setStatus(TarefaStatus.EM_DESENVOLVIMENTO);
					}
					tarefas.get(0).setTempoGasto(tarefas.get(0).getTempoGasto() + 1);
					System.out.println(nome + " trabalhou por uma hora na tarefa "+tarefas.get(0).getId() );

					if (tarefas.get(0).getDuracao() == tarefas.get(0).getTempoGasto()) {
						System.out.println(nome + " finalizou a tarefa id "+tarefas.get(0).getId() );
						tarefas.get(0).setStatus(TarefaStatus.EM_TESTE);
						tarefas.get(0).setDuracao(tarefas.get(0).getDuracao() / 2);
						Tarefa tarefaParaEnvio = tarefas.get(0);
						// Enviando tarefa para testador mais livre
						ACLMessage tarefaMsg = new ACLMessage(ACLMessage.INFORM);
						tarefaMsg.addReceiver(getTestadorMaisLivre().getAID());
						tarefaMsg.setLanguage("Português");
						tarefaMsg.setOntology("Aviso");
						tarefaMsg.setContent("Nova Tarefa");
						try {
							tarefaMsg.setContentObject(tarefas.get(0));
						} catch (IOException e) {
							e.printStackTrace();
						}
						send(tarefaMsg);

						tarefas.remove(0);
					}
				}
			}
		});

		ListaFuncionarios.cadastraProgramador(this);
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

	public String getNome(){
		return this.nome;

	}

	private Testador getTestadorMaisLivre(){
		List<Testador> testadores = ListaFuncionarios.getTestadores();
		int index = -1, valor = -1;
		for (int i = 0; i < testadores.size(); i++){
			if (i == 0 || testadores.get(i).getTempoTotalTarefas() < valor){
				valor = testadores.get(i).getTempoTotalTarefas();
				index = i;
			}
		}
		return testadores.get(index);
	}
}
