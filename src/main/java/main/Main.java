package main;


import jade.Boot;
import modelos.ListaFuncionarios;

public class Main {

	public static int delay = 5000;
	public static ListaFuncionarios funcionarios = new ListaFuncionarios();
	public static void main(String[] args) {



		String[] param = new String[4];
		param[0] = "-gui";
		param[1] = "Gerente:agentes.Gerente";
		param[2] = "Programador:agentes.Programador";
		param[3] = "Programador2:agentes.Programador";
		System.out.println(".");
		Boot.main(param);
		

	}

}
