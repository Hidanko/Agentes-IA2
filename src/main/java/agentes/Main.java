package agentes;

import jade.Boot;

public class Main {

	public static void main(String[] args) {
		String[] param = new String[2];
		param[0] = "-gui";
		param[1] = "HelloAgent:teste_j.HelloAgent";
		System.out.println(".");
		Boot.main(param);
	}

}
