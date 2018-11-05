#!/bin/bash
# for
#   for <variable> in <list>
#   do
#       <something>
#   done
for i in 1 2 3
do
    echo "No valor $i"
done
# outras formas de formatar
#   o do deve ficar na próxima linha
#   o ; informa que o que vem a seguir é a 'próxima linha'
for i in 4 5 6; do 
    echo "No valor $i"
done
#   assim não dá...
#   for i in 4 5 6 do 
#       echo "No valor $i"
#   done
# de onde vem listas?
#   lista de arquivos
#       * é substituído pela lista de filenames do diretório atual
for filename in *
do
    echo $filename 
done
#   ou com ls
#       $(<comando>) -> executa o comando e substitui o seu resultado na expressão
#       no exemplo, substitui $(ls .) pela lista de arquivos do diretório corrente .
for filename in $(ls)
do 
    echo "Lido com ls:" $filename
done
#   TODO: olhar a documentação do ls -> man ls (crtl+d para descer, crtl+u para subir, q para sair)