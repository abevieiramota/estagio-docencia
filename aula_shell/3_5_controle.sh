#!/bin/bash

echo "Digite algo"

while :
do
    read ENTRADA
    case $ENTRADA in
        oi)
            echo "Olha, você digitou oi hein?"
            # ;; indica que o que deve ser executado para esse caso vai até aqui
            ;;
        tchau)
            echo "Ah, agora foi um tchau!"
            break
            ;;
        # * -> catch all -> default do java
        *)
            echo "Você digitou $ENTRADA"
    esac
done
echo "Fim"