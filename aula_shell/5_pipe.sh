#!/bin/bash

# executa ls .(current directory)
#    resultado é passado, via pipe, para o grep 4
# TODO: consultar a documentação do grep
echo "Os arquivos .sh :"
ls . | grep  .*\.sh

# cat
#   conCAT files > usado para ler arquivos
# tr
#   TRanslate > troca caracteres por caracteres, usando um esquema de table
#   no exemplo, troca caracteres da classe upper(uppercase) por caracteres da classe lower(lowercase)
# grep
#   filtra linhas que satisfazem um padrão
#   -o > cada match dentro da linha é retornado, e não a linha toda
#   -E > versão extendida de regex
# sort
#   ordena as linhas
# uniq
#   remove linhas que, em sequência, estão repetidas
#   -c > adiciona às linhas únicas a frequência com que ocorreram
# sort
#   -n > ordenação feita de acordo com a ordem numérica (ex: )
#   -r > ordem reversa > descendente
# head
#   retorna o começo do input
#   -n > define 'começo' como quantidade de linhas > -n 10 > primeiras 10 linhas
cat livro.txt | tr [:upper:] [:lower:] | grep -oE "\w+" | sort | uniq -c | sort -nr | head -n 10