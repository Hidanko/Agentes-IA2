package modelos;

import java.util.Random;

public class Tarefas {
	
	int duracao;
	int prioridade;
	Nivel nivel;
	int programador;
	int testador;
	int status;
	int tempo_gasto;
	int tempo_teste;	
	
	public Tarefas() {
		Random random = new Random();
		this.nivel = Nivel.getByValor(random.nextInt(3)+1);
		this.duracao = (random.nextInt(4) * nivel.getValor())+1; 
		this.prioridade = random.nextInt(5)+1 ;
		this.programador = 0;
		this.testador = 0;
		this.status = 1;
		this.tempo_gasto = 0;
		this.tempo_teste = 0;
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

	public int getProgramador() {
		return programador;
	}

	public void setProgramador(int programador) {
		this.programador = programador;
	}
	
	public int getTestador() {
		return testador;
	}

	public void setTestador(int testador) {
		this.testador = testador;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTempo_gasto() {
		return tempo_gasto;
	}

	public void setTempo_gasto(int tempo_gasto) {
		this.tempo_gasto = tempo_gasto;
	}

	public int getTempo_teste() {
		return tempo_teste;
	}

	public void setTempo_teste(int tempo_teste) {
		this.tempo_teste = tempo_teste;
	}

	
}
