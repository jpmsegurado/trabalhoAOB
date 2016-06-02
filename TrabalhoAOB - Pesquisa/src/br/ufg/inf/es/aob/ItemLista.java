package br.ufg.inf.es.aob;

/**
 * Created by Dhiogo on 31-May-16.
 */
public class ItemLista {

    private String dado;
    private int chave;
    private ItemLista proximo;

    public ItemLista(String dado, int chave) {
        this.dado = dado;
        this.chave = chave;
        proximo = null;
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

    public ItemLista getProximo() {
        return proximo;
    }

    public void setProximo(ItemLista proximo) {
        this.proximo = proximo;
    }

}
