package br.ufg.inf.es.aob;

/**
 * Created by Dhiogo on 31-May-16.
 */
public class ArvoreBinaria {

    private int tamanho, maximo;
    private ItemArvore raiz;

    ArvoreBinaria(int max){
        this.raiz = null;
        this.tamanho = 0;
        this.maximo = max;
    }

    public ItemArvore getRaiz(){
        return this.raiz;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getMaximo(){
        return this.maximo;
    }

    public void setMaximo(int max){
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
}
