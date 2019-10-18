package modelos;

import java.util.ArrayList;

public class Fila_Tarefas {
	
	ArrayList<Tarefa> fila = new ArrayList<Tarefa>(); 
	
	public Fila_Tarefas() {
		
	}
	
	public void addFila(Tarefa t) {
		this.fila.add(t) ;
	}
}
