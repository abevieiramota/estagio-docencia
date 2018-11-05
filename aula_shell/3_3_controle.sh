#!/bin/bash
# if
#   if <test>
#   then
#       <something>
#   elif <test>
#   then
#       <something>
#   else
#       <something>
#   fi
read X 
if [ $X -eq 10 ]
then 
    echo "Olhaé, escreveu um 10"
elif [ $X -ne 100 ]
then 
    echo "Muito bem, não foi 100"
else 
    echo "Tu imprimiu foi um $X"
fi

# EXERCÍCIO 2:
#   desenvolva um script que leia um número X
#   e faça os seguintes testes
#       se 0 <= x <= 10
#           imprimir "Tá entre 0 e 10"
#       se 10 < x <= 20
#           imprimir "Tá entre 11 e 20"
#       senão
#           imprimir "É maior que 20"
#   dica: pesquisar na doc do comando test([) como compor expressões booleanas