package br.ufg.inf.es.aob;

public class ItemArvore {

    private String dado;
    private int chave;
    private ItemArvore esquerda, direita;

    public ItemArvore(String dado, int chave) {
        this.dado = dado;
        this.chave = chave;
        esquerda = null;
        direita = null;
    }

    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {
        this.dado = dado;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public ItemArvore getEsquerda(){
        return esquerda;
    }

    public void  setEsquerda(ItemArvore esq){
        this.esquerda = esq;
    }

    public ItemArvore getDireita(){
        return direita;
    }

    public void setDireita(ItemArvore dir){
        this.direita = dir;
    }
}
