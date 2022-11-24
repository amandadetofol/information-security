# -*- coding: utf-8 -*-
"""Cifra de Vigenere.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1PRFLeRKbj1k1wvoJ6PmuKptTirRso3lk
"""

# coding: utf-8
import string
import math

#voce pode executar o programa no google coolaboratory 

class CifraDeVigenere(object):

    #cria o grid de Vegenere
    @property
    def grid(self):
        grid = {}
        alfabeto = string.ascii_lowercase
        for pos in range(26):
            letra_atual = alfabeto[pos]
            try:
                letra_anterior = alfabeto[pos-1]
                grid[letra_atual] = grid[letra_anterior][1:] + letra_anterior
            except:
                grid[letra_atual] = alfabeto
        return grid

    # funcao que valida o tamanho 
    def validaTamanho(self, texto, chave):
        tamanhoDoTexto = len(texto)
        tamanhoDaChave = len(chave)
        posicaoAtual = 0
        novaChave = ""
        iniciar = True

        while iniciar:
            for pos in range(tamanhoDaChave):
                novaChave += chave[pos]
                posicaoAtual += 1
                if posicaoAtual == tamanhoDoTexto:
                    iniciar = False
                    break
        return novaChave

    #funcao que criptografa
    def criptografar(self, texto, chave, descriptografar=False):
        if len(texto) < len(chave):
            raise ValueError(
                "O tamanho da chave deve ser menor do que o do texto.")

        chave = self.validaTamanho(texto, chave)
        stringCriptografada = ""
        for l in range(len(texto)):
            stringCriptografada += self.cifraDeVigenere(texto[l], chave[l], descriptografar)
        return stringCriptografada

    # funcao que decriptografa
    def descriptografar(self, texto, chave):
        return self.criptografar(texto, chave, True)

    #funcao que realiza a criptografia/decriptografia em si  
    def cifraDeVigenere(self, letra, alfabeto, descriptografar=False):
        try:
            for pos in range(26):
                if descriptografar:
                    index = 'a'
                    alpha = alfabeto.lower()
                else:
                    index = alfabeto.lower()
                    alpha = 'a'

                if self.grid[alpha][pos] == letra.lower():
                    cifraDeVigenere = self.grid[index][pos]
                    break
            return cifraDeVigenere
        except:
            return ""




if __name__ == "__main__":
    c = CifraDeVigenere()
    print(c.criptografar("Amanda", "UFD")) #para criptografar
    print(c.descriptografar("urdhid", "UFD")) #para descriptografar