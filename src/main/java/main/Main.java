package main;


import agentes.Programador;
import jade.Boot;
import modelos.ListaFuncionarios;

public class Main {

	public static int delay = 5000;
	public static ListaFuncionarios funcionarios = new ListaFuncionarios();
	public static void main(String[] args) {


		
		String[] param = new String[2];
		param[0] = "-gui";
		param[1] = "  Gerente:agentes.Gerente;programador:agentes.Programador(programador);programador2:agentes.Programador(programador2)";
//		param[2] = "";
		Boot.main(param);
		
	}

}
