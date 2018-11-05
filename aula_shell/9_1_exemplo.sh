#!/bin/bash

# make a copy of all *.txt files in a folder renaming them to .txt.bkp

folder=$1
if [ -z $1 ]
then
    echo "Passa um folder aí!"
    exit 1
fi

# outra forma
#   A && B
#   executa A, se retornar sucesso, executa B
#   A || B
#   executa A, se retornar falha, executa B
[ -z $1 ] && exit 1

txt_files=($(ls $1 | grep -E \.txt$))

echo "${#txt_files[@]} arquivos encontrados"

for file in $txt_files 
do
    filepath="$folder/$file"
    bkpfilepath="${filepath}.bkp"
    cp $filepath $bkpfilepath
    echo "Backup de $filepath feito em $bkpfilepath"
done