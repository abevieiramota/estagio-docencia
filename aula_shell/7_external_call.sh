#!/bin/bash

# $(<comando>)
ARQUIVOS=$(ls .)

for ARQ in $ARQUIVOS
do
    echo "Há o arquivo" $ARQ 
done