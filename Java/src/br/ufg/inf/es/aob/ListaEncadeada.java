package br.ufg.inf.es.aob;

/**
 *
 */
public class ListaEncadeada {

    private int tamanho, maximo;
    private ItemLista primeiro,ultimo;

    ListaEncadeada(int max){
        this.maximo = max;
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public String setMaximo(int maximo){
        if(maximo < getTamanho()){
            return ("Novo tamanho menor que a quantidade de itens atual da lista!");
        }

        this.maximo = maximo;
        return ("Modificado.");
    }

    public void addItemInicio(String dado,int chave){
        ItemLista novo = new ItemLista(dado, chave);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
    }
    public void addItemFinal(String dado,int chave){
        ItemLista novo = new ItemLista(dado, chave);
        ItemLista aux = this.primeiro;
        if(this.primeiro == null){
            // se não existe um primeiro, cria o primeiro
            this.primeiro = novo;
            this.ultimo = this.primeiro;
        }else{
            // caso contrarario pega cria um novo item
            // faz o ultimo como o seu proximo
            // e faz com que seja o ultimo da lista
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }

        this.tamanho++;
    }

    public void removeItem(int chave){
        ItemLista aux = this.primeiro;
        while(aux != null && aux.getProximo().getChave() != chave){
            aux = aux.getProximo();
        }

        aux.setProximo(aux.getProximo().getProximo());


    }

    public int getTamanho() {
        return tamanho;
    }

    public ItemLista getPrimeiro() {
        return primeiro;
    }

    public ItemLista getItemLista(int chave){
        ItemLista aux = this.primeiro;
        while(aux != null && aux.getChave() != chave){
            aux = aux.getProximo();
        }

        return aux;
    }

    public String imprimeLista(){
        ItemLista aux = this.primeiro;
        StringBuilder builder = new StringBuilder();
        while(aux != null){
            builder.append("\n");
            builder.append("chave-->").append(aux.getChave());
            builder.append("\n");
            builder.append("dado---> ").append(aux.getDado());
            builder.append("\n");

            aux = aux.getProximo();
        }
        builder.append("\n");
        builder.append("----fim lista----");

        return builder.toString();
    }

}
