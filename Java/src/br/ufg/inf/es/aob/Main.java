package br.ufg.inf.es.aob;

import java.util.Scanner;

import br.ufg.inf.es.aob.ListaEncadeada;

/**
 *
 */
public class Main {
    public static Scanner input = new Scanner(System.in);

    public static int menuArvore(){
        System.out.println("==============================");
        System.out.println("  1 - Lista Elementos;");
        System.out.println("  2 - Pesquisa Elemento;");
        System.out.println("  3 - Remove Elemento;");
        System.out.println("  4 - Modificar Tamanho;");
        System.out.println("  0 - Sair.");
        System.out.print("  - ");
        return Integer.parseInt(input.nextLine());
    }

    public static int menuLista(){
        System.out.println("==============================");
        System.out.println("  1 - Lista Elementos;");
        System.out.println("  2 - Pesquisa Elemento;");
        System.out.println("  3 - Remove Elemento;");
        System.out.println("  4 - Modificar Tamanho;");
        System.out.println("  5 - Ordena Crescente;");
        System.out.println("  6 - Ordena Decrescente;");
        System.out.println("  0 - Sair.");
        System.out.print("  - ");
        return Integer.parseInt(input.nextLine());
    }

    public static void carregaArvore(ArvoreBinaria tree){
        int resposta;
        int qtd;
        int chave;
        String dado;
        if(tree.getMaximo() > 100){
            //carrega automaticamente
        }else{
            do{
                System.out.println("Deseja entrar com os elementos manualmente?");
                System.out.println("\t1. Sim;\n\t2. Não.");
                System.out.print("-");
                resposta = Integer.parseInt(input.nextLine());
                if(resposta == 1){
                    System.out.println("Quantos elementos deseja inserir??");
                    qtd = Integer.parseInt(input.nextLine());
                    if(qtd <= tree.getMaximo() - tree.getTamanho()){
                        for(int i = 0; i < qtd; i++){
                            System.out.print("Chave = ");
                            chave = Integer.parseInt(input.nextLine());
                            System.out.print("Dado = ");
                            dado = input.nextLine();
                            tree.addItem(tree.getRaiz(), chave, dado);
                        }
                    }else{
                        System.out.println("Quantidade de elementos maior que o máximo permitido");
                        resposta = 3;
                    }
                }else if (resposta == 2){
                    //inicialização automática;
                }
            }while(resposta != 1 && resposta != 2);

        }
    }

    public static void carregaLista(ListaEncadeada lista){
        int resposta, qtd;
        int chave;
        String dado;
        if(lista.getMaximo() > 100){
            //carrega automaticamente
        }else{
            do{
                System.out.println("Deseja entrar com os elementos manualmente?");
                System.out.println("\t1. Sim;\n\t2. Não.");
                System.out.print("-");
                resposta = Integer.parseInt(input.nextLine());
                if(resposta == 1){
                    System.out.println("Quantos elementos deseja inserir??");
                    qtd = Integer.parseInt(input.nextLine());
                    if(qtd <= lista.getMaximo() - lista.getTamanho()){
                        for(int i = 0; i < qtd; i++){
                            System.out.print("Chave = ");
                            chave = Integer.parseInt(input.nextLine());
                            System.out.print("Dado = ");
                            dado = input.nextLine();
                            lista.addItemFinal(dado, chave);
                        }
                    }else{
                        System.out.println("Quantidade de elementos maior que o máximo permitido");
                        resposta = 3;
                    }

                }else if (resposta == 2){
                    //inicialização automática;
                }
            }while(resposta != 1 && resposta != 2);

        }
    }

    public static void arvore(int max){
        int op;
        int in, fim, key;
        ArvoreBinaria tree = new ArvoreBinaria(max);
        carregaArvore(tree);
        do{
            switch (op = menuArvore()) {
                case 1:
                    if(tree.getTamanho() < 100){
                        tree.imprimeArvore(tree.getRaiz());
                    }else{
                        System.out.println("Entre com o intervalo de listagem:");
                        System.out.print("Inicia: ");
                        in = Integer.parseInt(input.nextLine());
                        System.out.print("Termina: ");
                        fim = Integer.parseInt(input.nextLine());
                        tree.imprimeArvoreG(tree.getRaiz(), 0, in, fim);
                    }
                    break;
                case 2:
                    System.out.println("Entre com a chave primária da pesquisa:");
                    System.out.print("  - ");
                    key = Integer.parseInt(input.nextLine());
                    tree.buscaElemento(tree.getRaiz(), key);
                    break;
                case 3:
                    // remoção?
                    break;
                case 4:
                    System.out.println("Entre com o novo tamanho da tabela:");
                    System.out.print("  - ");
                    key = Integer.parseInt(input.nextLine());
                    tree.setMaximo(key);
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema!");
                    break;
                default:
                    System.out.println("Entrada inválida!!");
            }
        }while (op != 0);
    }

    public static void lista(int max){
        int op;
        int in, fim, key;
        ListaEncadeada lista = new ListaEncadeada(max);
        carregaLista(lista);
        do{
            switch (op = menuLista()) {
                case 1:
                    if(lista.getTamanho() < 100){
                        System.out.println(lista.imprimeLista());
                    }else{
                        System.out.println("Entre com o intervalo de listagem:");
                        System.out.print("Inicia: ");
                        in = Integer.parseInt(input.nextLine());
                        System.out.print("Termina: ");
                        fim = Integer.parseInt(input.nextLine());
                        System.out.println(lista.imprimeIntervalo(in, fim));
                    }
                    break;
                case 2:
                    System.out.println("Entre com a chave primária da pesquisa:");
                    System.out.print("  - ");
                    key = Integer.parseInt(input.nextLine());
                    lista.getItemLista(key);
                    break;
                case 3:
                    System.out.println("Entre com a chave primária da remoção:");
                    System.out.print("  - ");
                    key = Integer.parseInt(input.nextLine());
                    lista.removeItem(key);
                    break;
                case 4:
                    System.out.println("Entre com o novo tamanho da tabela:");
                    System.out.print("  - ");
                    key = Integer.parseInt(input.nextLine());
                    lista.setMaximo(key);
                    break;
                case 5:
                    lista.ordenaListaCrescente();
                    System.out.println("Tabela Ordenada...");
                    break;
                case 6:
                    lista.ordenaListaDecrescente();
                    System.out.println("Tabela Ordenada...");
                    break;
                case 0:
                    System.out.println("Obrigado por usar nosso sistema!");
                    break;
                default:
                    System.out.println("Entrada Inválida!");
            }
        }while (op != 0);
    }

    public static void main(String[] args) {
        int op;
        int max;
        System.out.println("Bem vindo!");
        System.out.println("Que tipo de estrutura deseja utilizar?\n\t1. Lista Encadeada;\n\t2. Arvore Binária de Busca.");
        System.out.print("\t - ");
        op = Integer.parseInt(input.nextLine());
        System.out.println("Entre com o tamanho da tabela:");
        System.out.println("(potencias de 10 com expoentes entre 1 e 6)");
        System.out.print("\t - ");
        max = Integer.parseInt(input.nextLine());
        if(op == 1){
            lista(max);
        }else if(op == 2){
            arvore(max);
        }
    }

}
