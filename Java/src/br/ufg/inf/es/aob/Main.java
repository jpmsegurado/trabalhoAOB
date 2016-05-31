package br.ufg.inf.es.aob;

import br.ufg.inf.es.aob.ListaEncadeada;

/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada(10);
        lista.addItemFinal("bla", 1);
        lista.addItemFinal("bla", 2);
        lista.addItemInicio("bla", 3);
        lista.addItemInicio("bla", 4);
        System.out.println(lista.imprimeLista());
        lista.removeItem(1);
        System.out.println(lista.imprimeLista());

    }

}
