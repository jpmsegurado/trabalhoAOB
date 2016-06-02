/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.aob;

/**
 *
 * @author Level 5
 */
public class ArvoreBinaria {
    private double cont;
    private double tamanho;
    private double maximo;
    private ItemArvore raiz;

    ArvoreBinaria(int max){
        this.cont = 0;
        this.raiz = null;
        this.tamanho = 0;
        if(max != 10 && max != 100 && max != 1000 && max != 10000 && max != 100000 && max != 1000000){
            if (max < 100){
                max = 100;
                System.out.println("Tamanho máximo invalido, modificado para 100...");
            }else{
                max = 1000;
                System.out.println("Tamanho máximo inválido, modificado para 1000...");
            }
        }
        this.maximo = max;
    }

    public void addCont(){
        this.cont ++;
    }

    public void zeraCont(){
        this.cont = 0;
    }

    public double getCont(){
        return this.cont;
    }

    public ItemArvore getRaiz(){
        return this.raiz;
    }

    public double getTamanho(){
        return this.tamanho;
    }

    public double getMaximo(){
        return this.maximo;
    }

    public void setMaximo(int max){
        if(max != 10 && max != 100 && max != 1000 && max != 10000 && max != 100000 && max != 1000000){
            System.out.println("Entrada Inválida, o tamanho deve ser uma potência de dez!");
            return;
        }
        if(max > this.getTamanho()){
            this.maximo = max;
        }
    }

    public void addItem(ItemArvore nodo, int chave, String dado) {
        if (this.getTamanho() == this.getMaximo()){
            System.out.println("Tamanho máximo atingido!");
            return;
        }
        ItemArvore novo = new ItemArvore(dado, chave);
        novo.setDireita(null);
        novo.setEsquerda(null);
        if (nodo == null) {
            this.raiz = novo;
            this.tamanho++;
        } else {
            if (chave < nodo.getChave()) {
                if (nodo.getEsquerda() == null) {
                    nodo.setEsquerda(novo);
                    this.tamanho++;
                } else {
                    addItem(nodo.getEsquerda(), chave, dado);
                }
            } else if (chave > nodo.getChave()) {
                if (nodo.getDireita() == null) {
                    nodo.setDireita(novo);
                    this.tamanho++;
                } else {
                    addItem(nodo.getDireita(), chave, dado);
                }
            }
        }
    }

    public void imprimeArvoreG(ArvoreBinaria tree, ItemArvore nodo, int inicio, int fim){
        if (nodo != null){
            imprimeArvoreG(tree, nodo.getEsquerda(), inicio, fim);
            if(tree.getCont() < inicio){
                tree.addCont();
            }else if (tree.getCont() <= fim){
                System.out.printf("chave--> %5d |\n", nodo.getChave());
                System.out.printf("dado---> %5s |\n", nodo.getDado());
                System.out.println();
                tree.addCont();
            }else{
                return;
            }
            imprimeArvoreG(tree, nodo.getDireita(), inicio, fim);
        }

    }

    public void imprimeArvore(ItemArvore nodo){

        if(nodo != null) {
            imprimeArvore(nodo.getEsquerda());
            System.out.printf("chave--> %5d \n", nodo.getChave());
            System.out.printf("dado---> %5s \n", nodo.getDado());
            System.out.println();
            imprimeArvore(nodo.getDireita());
        }

    }

    public String buscaElemento(ItemArvore nodo, int chave){
        StringBuilder builder = new StringBuilder();
        if (nodo == null){
            return "Elemento inexistente!";
        }
        if(nodo.getChave() < chave){
            return buscaElemento(nodo.getDireita(), chave);
        }else if(nodo.getChave() > chave){
            return buscaElemento(nodo.getEsquerda(), chave);
        }else{
            builder.append("Chave --> "+ nodo.getChave() +"\n");
            builder.append("Dado ---> "+ nodo.getDado() +"\n");
            return builder.toString();
        }
    }

    public ItemArvore maiorMenores(ItemArvore nodo){
        ItemArvore pai = nodo;
        while(nodo.getDireita() != null){
            pai = nodo;
            nodo = nodo.getDireita();
        }
        if(nodo.getEsquerda() != null){
            pai.setDireita(nodo.getEsquerda());
            nodo.setEsquerda(null);
        }
        return nodo;
    }

    public ItemArvore removeElemento (ItemArvore nodo, ItemArvore pai, int valor, char teste){
        if (nodo == null){
            System.out.println("A arvore está vazia ");
        }
        if (valor < nodo.getChave()) {
            removeElemento (nodo.getEsquerda(), nodo, valor, 'e');
        } else if (valor > nodo.getChave()) {
            removeElemento (nodo.getDireita(), nodo, valor, 'd');
        } else if (nodo.getEsquerda() != null && nodo.getDireita() != null)
        {
            if(teste == 'd'){
                pai.setDireita(null);
            }else if (teste == 'e'){
                pai.setEsquerda(null);
            }
            System.out.println("O nó foi removido " + nodo.getChave());
        } else if (nodo.getEsquerda() != null) {
            ItemArvore aux = maiorMenores(nodo.getEsquerda());
            aux.setDireita(nodo.getDireita());
            aux.setEsquerda(nodo.getEsquerda());
            nodo = aux;
        } else {
            if (teste == 'd'){
                pai.setDireita(nodo.getDireita());
            }else if (teste == 'e'){
                pai.setEsquerda(nodo.getEsquerda());
            }
        }
        return nodo;
    }
}
  