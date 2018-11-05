#!/bin/bash

# <nome>()
# {
#   <corpo>
# }
print()
{
    # o acesso aos parâmetros ocorre da mesma forma que 
    #   o acesso aos parâmetros do script
    echo $1
}

print "Meu nome"

# returning
do_something()
{
    if [ $1 = 1 ]
    then
        return 1
    else
        return 0
    fi
}

do_something 1

if [ $? -eq 1 ]
then 
    echo "Ooooia, foi chamado com 1"
else
    echo "aaaah, com 0 :\\"
fi