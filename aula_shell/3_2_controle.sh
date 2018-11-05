#!/bin/bash
# while
#   while <test>
#   do
#       <something>
#   done
LIDO="nada"
while [ $LIDO != "fim" ]
do 
    echo "Escreve algo aí(fim pra acabar)"
    read LIDO
    echo "Você escreveu $LIDO"
done
# e esse [ ... ]?
#   [ -> comando de teste
#   executa o teste passado(ARG1 OPR ARG2 ]) e retorna um booleano
#   necessário espaço entre os argumentos
#       ARG1
#       ARG2
#       ]
#   TODO: olhar a documentação do [
NUM=-1
while [ $NUM -ne 0 ]
do
    echo "Diz um número aí(0 para sair)"
    read NUM 
    echo "Você escreveu $NUM"
done

# EXERCÍCIO 1:
#   altere o while acima para testar se NUM é maior que ou igual a 10

# loop infinito?
#   : -> é avaliado como TRUE
#   while :
#   do
#       <something>
#   done