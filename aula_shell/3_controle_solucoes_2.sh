#!/bin/bash
read X
if [ $X -ge 0 -a $X -le 10 ]
then
    echo "Tá entre 0 e 10"
elif [ $X -gt 10 -a $X -le 20 ]
then
    echo "Tá entre 11 e 20"
else 
    echo "É maior que 20"
fi