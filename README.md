#Aplicação:

DELAY regulável em Main.delay (Atual 5000 milissegundos)

Empresa possui um GERENTE que recebe tarefas.
O gerente atribui a tarefa para o melhor PROGRAMADOR para a tarefa.
PROGRAMADOR realiza a tarefa, escolhe o TESTADOR mais disponivel e envia para ele.
TESTADOR valida a tarefa, a tarefa pode ser definida como realizada ou enviada de volta para o PROGRAMADOR para correção


#TAREFA:

	private int id;
	private int duracao;
	private int prioridade;
	private Nivel nivel;
	private Programador programador;
	private Testador testador;
	private TarefaStatus status;
	private int tempoGasto;
	private int tempoTeste;


#TAREFA STATUS:

	PENDENTE, EM_DESENVOLVIMENTO, INDO_PARA_TESTE, EM_TESTE, CONCLUIDO


#GERENTE:

Um por sistema

2 Behaviour

1- Tick de 1 delay -> A cada ciclo ele busca se há novos programadores
2- Tick de 3 delay -> A cada ciclo ele cria uma nova tarefa com NIVEL, DURACAO e COMPLEXIDADE definidos aleatóriamente
 e envia para o PROGRAMADOR mais disponível



 
