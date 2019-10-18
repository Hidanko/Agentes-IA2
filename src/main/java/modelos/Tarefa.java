package modelos;

import java.util.Random;

import agentes.Programador;
import agentes.Testador;

public class Tarefa {
	
	int duracao;
	int prioridade;
	Nivel nivel;
	Programador programador;
	Testador testador;
	TarefaStatus status;
	int tempoGasto;
	int tempoTeste;	
	
	public Tarefa() {
		Random random = new Random();
		this.nivel = Nivel.getByValor(random.nextInt(3)+1);
		this.duracao = (random.nextInt(4) * nivel.getValor())+1; 
		this.prioridade = random.nextInt(5)+1 ;
		this.programador = null;
		this.testador = null;
		this.status = TarefaStatus.PENDENTE;
		this.tempoGasto = 0;
		this.tempoTeste = 0;
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Programador getProgramador() {
		return programador;
	}

	public void setProgramador(Programador programador) {
		this.programador = programador;
	}
	
	public Testador getTestador() {
		return testador;
	}

	public void setTestador(Testador testador) {
		this.testador = testador;
	}

	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		System.out.println("Tarefa de status "+ this.status + " alterado para "+ status);
		this.status = status;
	}

	public int getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public int getTempoTeste() {
		return tempoTeste;
	}

	public void setTempoTeste(int tempoTeste) {
		this.tempoTeste = tempoTeste;
	}

	
}
