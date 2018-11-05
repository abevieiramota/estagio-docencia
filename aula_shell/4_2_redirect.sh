#!/bin/bash

while :
do
    read VALOR
    # write > overwrite
    echo $VALOR > meu_arquivo_2.txt
done