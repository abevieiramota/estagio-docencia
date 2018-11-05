#!/bin/bash
#   chamada ao procedimento echo, com 2 parâmetros
echo Hello World
#   TODO: olhar a documentação do echo -> man echo (crtl+d para descer, crtl+u para subir, q para sair)
#   -e -> interpretar caracteres especiais
#   \a -> alerta
echo -e "\a"
#   e Hello World com vários espaços?
echo Hello                        World
#   são ignorados os espaços entre os parâmetros
echo "Hello                        World"