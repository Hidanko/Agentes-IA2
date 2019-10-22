package modelos;

import agentes.Programador;
import agentes.Testador;

import java .util.List;
import java.util.ArrayList;

public class ListaFuncionarios {

    private static List<Programador> programadores = new ArrayList<Programador>();
    private static List<Testador> testadores = new ArrayList<Testador>();


    public void cadastraProgramador(Programador programador){
        if (programadores == null){
            programadores = new ArrayList<Programador>();
        }
        programadores.add(programador);
    }

    public void cadastraTestador(Testador testador){
        if (testadores == null){
            testadores = new ArrayList<Testador>();
        }
        testadores.add(testador);
    }

    public Programador getProgramadorByLocalName(String localName){
        for (Programador p: programadores) {
            if (p.getLocalName() == localName){
                return p;
            }
        }
        return null;
    }

    public Testador getTestadorByLocalName(String localName){
        for (Testador t : testadores) {
            if (t.getLocalName() == localName){
                return t;
            }
        }
        return null;
    }
}
