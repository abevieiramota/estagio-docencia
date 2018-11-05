#!/bin/bash

# $1, $2, ... > parâmetros em ordem
# $@ > todos os parâmetros
# $# > quantidade de parâmetros

echo "A quantidade de parâmetros é" $#

count=1
for i in $@
do
    echo "O parâmetro" $count "é" $i
    # $((<aritmética>)) > execute a conta e retorne o valor
    # ((<aritmética>)) > execute a conta e não retorne nada
    # $(<comando>) > execute o comando e retorne o stdout dele
    # (<comando>) > execute o comando
    count=$((count + 1))
    #((count=count + 1))
done

# executa comando
#   [ -e <filename> ] > testa se o arquivo existe, 0 se sim, 1 se não
[ -e 'livro.txt' ]
# $? > retorno do último comando executado
echo $?

echo "O PID desse processo é" $$