package br.ufg.inf.es.aob;

import java.math.*;

/**
 * Created by Dhiogo on 31-May-16.
 */
public class ArvoreBinaria {

    private double tamanho;
    private double maximo;
    private ItemArvore raiz;

    ArvoreBinaria(int max){
        this.raiz = null;
        this.tamanho = 0;
        this.maximo = max;
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
        double newMax = Math.pow(10, max);
        if(newMax > this.getTamanho()){
            this.maximo = newMax;
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

    public void imprimeArvoreG(ItemArvore nodo, int cont, int inicio, int fim){
        if (nodo != null){
            imprimeArvoreG(nodo.getEsquerda(), cont, inicio, fim);
            if(cont < inicio){
                cont ++;
            }else if (cont <= fim){
                System.out.printf("chave--> %5d |\n", nodo.getChave());
                System.out.printf("dado---> %5s |\n", nodo.getDado());
                System.out.println();
                cont ++;
            }else{
                return;
            }
            imprimeArvoreG(nodo.getDireita(), cont, inicio, fim);
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
}
