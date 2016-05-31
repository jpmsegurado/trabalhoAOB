#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <locale.h>

typedef struct{
    int chave;
    char dado[5];
}Elemento;

void ExibeDados(Elemento E){
	printf("=====================\n");
	printf("|CHAVE: %5d       |\n", E.chave);
	printf("|DADO: %5s        |\n", E.dado);
	printf("=====================\n");
}

void LeituraIncersao(Elemento *E){
	printf("Entre com a chave primária: ");
	scanf("%d", (E->chave));
	printf("Entre com o dado: ");
	scanf("%s", E->dado);
}

int LeituraPesquisa(int *k){
	printf("Entre com a chave primária do elemento a ser pesquisado: \n\t-");
	scanf("%d", k);
}

//Estruturas relacionadas à Lista Encadeada


typedef struct Cx{
    Elemento elem;
    struct Cx *proximo;
} Caixa;

typedef Caixa *Ponteiro;

typedef struct{
    Ponteiro inicio, fim;
    int tamanho;
}LinkedList;

void setList(LinkedList *L){
    Ponteiro A;
    A = (Ponteiro) malloc (sizeof(Caixa));
    L->inicio = A;
    L->fim = A;
    L->tamanho = 0;
    L->inicio->proximo = NULL;
}

void addList(LinkedList *L, Elemento E){
    Ponteiro A, P;
    A = (Caixa *)malloc(sizeof(Caixa));
    A->elem = E;
    P = L->inicio;
    while((P->proximo != L->fim) && (E.chave < P->proximo->elem.chave)){
        P = P->proximo;
    }
    A->proximo = P->proximo;
    P->proximo = A;
    if (P == L->fim){
        L->fim = A;
    }
    L->tamanho++;
}

void pesquisaLista(LinkedList L, int chave){
	Elemento elem;
	Ponteiro P = L.inicio;
	while (P->proximo != L.fim && P->elem.chave != chave){
		P = P->proximo;
	}
	if(P->elem.chave == chave){
		ExibeDado(P->elem);
	}else{
		printf("Elemento inexistente...\n");
		return;
	}
}

void removeElemLista(LinkedList *L, int chave){
	int i;
	Ponteiro P = L->inicio, A;
	while (P->proximo != L->fim && P->elem.chave != chave){
		A = P;
		P = P->proximo;
	}
	if(P->elem.chave == chave){
		exibeDados(P->elem);
		printf("Confirmar Remoção?\n\t1. Sim;\n\t2. Não.\n\t-");
		scanf("%d", &i);
		if(i == 1){
			A->proximo = P->proximo;
			free(P);
		}else{
			printf("Operação Cancelada...\n");
			return;
		}
	}else{
		printf("Elemento inexistente\n");
		return;
	}
}
//Estruturas relacionadas à Arvore Binária

typedef struct nd{
    Elemento elem;
    struct nd *esquerda, *direita;
}Node;

typedef Node *BinaryTree;

Elemento maiorMenores(BinaryTree Q, Elemento *R){
	while (Q->direita != NULL){
		Q = Q->direita;
	}
	*R = Q->elem;
	return (Q->elem);
}

void InsereElemArvore(BinaryTree *T, Elemento X){
	if ((*T)==NULL){
		(*T) = (BinaryTree) malloc(sizeof (Node));
		(*T)->direita = NULL;
		(*T)->esquerda = NULL;
		(*T)->elem = X;
	}else if ((*T)->elem.chave > X.chave)
		InsereElemArvore(&((*T)->esquerda), X); // Insere no lado direito da sub-arvore
	else if ((*T)->elem.chave < X.chave) 
		InsereElemArvore(&((*T)->direita), X); // Insere no lado esquerdo da sub-arvore
	else (*T)->elem = X;                       // substitui o valor
}

void PesquisaElemArvore(BinaryTree T, int chave, Elemento *X){
	if(T == NULL)
		printf("\nElemento não encontrado.\n");
	else if(chave < T->elem.chave)
		PesquisaElemArvore(T->esquerda, chave, (X));
	else if(chave > T->elem.chave)
		PesquisaElemArvore(T->direita, chave, (X));
	else{
		ExibeDados(T->elem);
		*X = (T)->elem;
	}

}

void removeElemArvore(BinaryTree *T, Elemento *X){
	BinaryTree A;
	
	if ((*T) == NULL){
		printf("\nElemento não existe\n");
	} else if (X->chave < (*T)->elem.chave){
		removeElemArvore(&((*T)->esquerda), &(*X));
	} else if (X->chave > (*T)-> elem.chave) {
		removeElemArvore(&((*T)->direita), &(*X));
	} else if ((*T)->direita == NULL){
		*X = (*T)->elem;
		A = (*T);
		(*T) = (*T)->esquerda;
		free(A);
	} else if ((*T)->esquerda == NULL){
		*X = (*T)->elem;
		A = (*T);
		(*T) = (*T)->direita;
		free(A);
	} else {
		(*T)->elem = maiorMenores((*T)->esquerda, &(*X));
		removeElemArvore(&((*T)->esquerda), X);
		printf("Elemento Removido");
	}
}

//Outros

//Main

int main(int argc, char **argv){
	setlocale(LC_ALL, "Portuguese");
	int r;
	printf("\tBem vindo ao Sistema de Pesquisa em Memória Primária.\n");
	do{
		
		printf("\tSelecione o tipo de tabela a ser implementada:\n\t1. Lista Linear Encadeada;\n\t2. Árvore Binaria de Pesquisa.\n\t-");
		scanf("%d", &r);
		if(r == 1){
			//Implementação do Menu Lista;
		}else if (r == 2){
			//Implementação do Menu Árvore;
		}
	}while(r != 1 && r != 2);
	
	
    BinaryTree T = NULL;
    printf("ok, por enquanto...\n");
    return 0;
}
