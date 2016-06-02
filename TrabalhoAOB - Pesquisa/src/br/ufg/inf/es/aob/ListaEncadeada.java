package br.ufg.inf.es.aob;

/**
 *
 */
public class ListaEncadeada {

    private int tamanho, maximo;
    private ItemLista primeiro,ultimo;

    ListaEncadeada(int max){
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
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public String setMaximo(int max){
        if(max < getTamanho()){
            return ("Novo tamanho menor que a quantidade de itens atual da lista!");
        }else if(max != 10 && max != 100 && max != 1000 && max != 10000 && max != 100000 && max != 1000000){
            return "O tamanho deve ser uma potencia de dez (1-6)";
        }
        this.maximo = max;
        return ("Modificado.");
    }

    public int getMaximo(){
        return this.maximo;
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
            // se n�o existe um primeiro, cria o primeiro
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

    public String pesquisa(int chave){
        ItemLista aux = getItemLista(chave);
        StringBuilder builder = new StringBuilder();
        if(aux != null){
            builder.append("Chave --> "+ aux.getChave() +"\n");
            builder.append("Dado ---> "+ aux.getDado() +"\n");

            return builder.toString();
        }
        return "Elemento inexistente";
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

    public String imprimeIntervalo(int inicio, int fim){
        ItemLista aux = this.primeiro;
        StringBuilder builder = new StringBuilder();
        if(inicio > this.getTamanho() || fim < inicio || inicio < 0 || fim - inicio > 100 ){
            return "�ndices Inválidos!";
        }
        for (int i = 0; i <= fim; i++){
            if(i >= inicio){
                builder.append("chave --> "+ aux.getChave()+"\n");
                builder.append("dado ---> "+ aux.getDado()+"\n");
                builder.append("======================\n");
            }
            aux = aux.getProximo();
        }
        return builder.toString();
    }

    public void ordenaListaCrescente(){
        ItemLista aux1 = this.primeiro;
        while(aux1 != null){
            ItemLista aux2 = this.primeiro;
            while(aux2 != null){
                if(aux2.getChave() > aux1.getChave()){
                    trocaValores(aux1, aux2);
                }

                aux2 = aux2.getProximo();
            }
            aux1 = aux1.getProximo();
        }
    }

    public void ordenaListaDecrescente(){
        ItemLista aux1 = this.primeiro;
        while(aux1 != null){
            ItemLista aux2 = this.primeiro;
            while(aux2 != null){
                if(aux2.getChave() < aux1.getChave()){
                    trocaValores(aux1, aux2);
                }

                aux2 = aux2.getProximo();
            }
            aux1 = aux1.getProximo();
        }
    }

    public void trocaValores(ItemLista item1, ItemLista item2){
        ItemLista aux = new ItemLista(item1.getDado(), item1.getChave());
        item1.setChave(item2.getChave());
        item1.setDado(item2.getDado());
        item2.setChave(aux.getChave());
        item2.setDado(aux.getDado());


    }

}
