package br.ufg.inf.es.aob;

import java.util.Random;

public class Item {

    private int chave;
    private String dado;

    public Item (int max){
        Random rand = new Random();
        this.chave = rand.nextInt(max * 100);
        this.dado = defineString();
    }

    public int getChave(){
        return this.chave;
    }

    public String getDado(){
        return this.dado;
    }

    public String defineString(){
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        int qtd = rand.nextInt(2) + 3;
        for(int i = 0; i < qtd; i++){
            int letra = rand.nextInt(25) + 1;
            switch (letra){
                case 1:
                    builder.append("a");
                    break;
                case 2:
                    builder.append("b");
                    break;
                case 3:
                    builder.append("c");
                    break;
                case 4:
                    builder.append("d");
                    break;
                case 5:
                    builder.append("e");
                    break;
                case 6:
                    builder.append("f");
                    break;
                case 7:
                    builder.append("g");
                    break;
                case 8:
                    builder.append("h");
                    break;
                case 9:
                    builder.append("i");
                    break;
                case 10:
                    builder.append("j");
                    break;
                case 11:
                    builder.append("k");
                    break;
                case 12:
                    builder.append("l");
                    break;
                case 13:
                    builder.append("m");
                    break;
                case 14:
                    builder.append("n");
                    break;
                case 15:
                    builder.append("o");
                    break;
                case 16:
                    builder.append("p");
                    break;
                case 17:
                    builder.append("q");
                    break;
                case 18:
                    builder.append("r");
                    break;
                case 19:
                    builder.append("s");
                    break;
                case 20:
                    builder.append("t");
                    break;
                case 21:
                    builder.append("u");
                    break;
                case 22:
                    builder.append("v");
                    break;
                case 23:
                    builder.append("w");
                    break;
                case 24:
                    builder.append("x");
                    break;
                case 25:
                    builder.append("y");
                    break;
                case 26:
                    builder.append("z");
                    break;
            }
        }
        return builder.toString();
    }

}
