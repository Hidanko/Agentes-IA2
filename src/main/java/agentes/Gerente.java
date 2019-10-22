package agentes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import main.Main;
import modelos.Tarefa;

public class Gerente extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Programador> filaProgramadores = new ArrayList<Programador>();
//	private List<Testador> filaTestadores = new ArrayList<Testador>();
	private Random random = new Random();

	public Gerente() {
		System.out.println("Novo gerente na empresa "+getAID());
	}

	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			public void action() {
				block(Main.delay);
//				System.out.println("Gerente com "+filaProgramadores.size()+" funcionarios");
				
				// Novo programador 
				ACLMessage msg = myAgent.receive();
				if (msg != null) {
					String content = msg.getContent();
					if (content.contains("Programador")) {
						try {
							Programador p = (Programador)msg.getContentObject();
							filaProgramadores.add(p);
							System.out.println("Novo programador encontrado!");
						} catch (UnreadableException e) {
							System.out.println("Falha ao ler objeto serializado");
							e.printStackTrace();
						}
					}
				}

				// Criando nova tarefa
				if (filaProgramadores.size() >= 2) {
					for (int i = 0; i < random.nextInt(filaProgramadores.size()); i++) {
						Tarefa tarefa = new Tarefa();
//						System.out.println("Nova tarefa encontrada! N�vel " + tarefa.getNivel() + "Dura��o de "
//								+ tarefa.getDuracao() + " horas e prioridade n�vel " + tarefa.getPrioridade());
						Programador menor = null;
						for (int j = 0; j < filaProgramadores.size(); j++) {
							if (j == 0 || menor.getTempoTotalTarefas() > filaProgramadores.get(j).getTempoTotalTarefas()) {
								menor = filaProgramadores.get(j);
							}
						}
						
						// Enviando nova tarefa
						ACLMessage tarefaMsg = new ACLMessage (ACLMessage.INFORM);
						tarefaMsg.addReceiver (menor.getAID());
						tarefaMsg.setLanguage ("Português");
						tarefaMsg.setOntology ("Aviso");
						tarefaMsg.setContent ("Nova Tarefa");
						try {
							tarefaMsg.setContentObject(tarefa);
						} catch (IOException e) {
							System.out.println("Falha ao serializar objeto");
							e.printStackTrace();
						}
						System.out.println("Enviando tarefa para "+menor.getName());
						send (tarefaMsg);

					}
				}
			}
		});


	}}