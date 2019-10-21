package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import modelos.Tarefa;
import modelos.TarefaStatus;

import java.util.ArrayList;
import java.util.Random;

public class Testador extends Agent {
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private int id_testador;

    public Testador(int id) {
        this.id_testador = id;
    }

    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {

            public void action() {

                if (tarefas.size() > 0) {

                    if (tarefas.get(0).getDuracao() == tarefas.get(0).getTempoTeste()) {
                        Random r = new Random();
                        Tarefa t = tarefas.get(0);
                        tarefas.remove(0);
                        if (r.nextBoolean()) {
                            System.out.println("Encontrado falha na tarefa, retornando ao programador "
                                    + t.getProgramador().getAID());
                            // RETORNAR TAREFA PARA PROGRAMADOR
                        }
                        {
                            System.out.println("Tarefa nível "+ t.getNivel() + " realizada por " + t.getProgramador().getAID()
                                    + " concluida");
                        }

                    }

                    if (tarefas.get(0).getStatus() == TarefaStatus.INDO_PARA_TESTE) {
                        tarefas.get(0).setStatus(TarefaStatus.EM_TESTE);
                    }
                    tarefas.get(0).setTempoTeste(tarefas.get(0).getTempoGasto() + 1);
                }
            }
        });
    }

    public void verificaFila(ArrayList<Tarefa> fila_gerente) {

    }

    public void verificaTarefaAtiva() {

    }

}
