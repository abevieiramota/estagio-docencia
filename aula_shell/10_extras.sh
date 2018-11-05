#!/bin/bash

# brace expansion
#   {ini..fim}
for i in {1..10}
do
    echo $i
done

#   prefixo{lista}sufixo
for file in arquivo_{a,b,c}.txt
do
    echo $file
done