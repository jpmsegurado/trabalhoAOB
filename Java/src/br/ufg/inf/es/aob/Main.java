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
        ArvoreBinaria tree = new ArvoreBinaria(10);
        tree.addItem(tree.getRaiz(), 15, "ok");
        tree.addItem(tree.getRaiz(), 25, "ok");
        tree.addItem(tree.getRaiz(), 11, "ok");
        tree.addItem(tree.getRaiz(), 13, "ok");
        tree.addItem(tree.getRaiz(), 19, "ok");

        tree.imprimeArvore(tree.getRaiz());
    }

}
