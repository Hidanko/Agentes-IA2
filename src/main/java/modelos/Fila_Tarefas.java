package modelos;

import java.util.ArrayList;

public class Fila_Tarefas {
	
	ArrayList<Tarefas> fila = new ArrayList<Tarefas>(); 
	
	public Fila_Tarefas() {
		
	}
	
	public void addFila(Tarefas t) {
		this.fila.add(t) ;
	}
}
