#!/bin/bash
#   atribuição
#       VARIAVEL=VALOR
MENSAGEM="Escreve aí teu nome"
#   acesso -> $
echo $MENSAGEM
#   sem tipo estático
MENSAGEM=2
echo $MENSAGEM
#   não pode haver espaços ao redor do =
#       interpretado como chamada de comando, com parâmetros = e 123
MENSAGEM = 123
#   again
MENSAGEM="Escreve aí teu nome"
echo $MENSAGEM
#   leitura
read VALOR
#   print
echo "O valor passado foi" $VALOR 
#   ou -> parecido com f-string do python
#       o valor da expressão é avaliado e substituído na string
echo "O valor passado foi $VALOR"