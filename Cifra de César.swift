//ALUNA: AMANDA DETOFOL CONSTANTE
//LINGUAGEM: SWIFT
//LINK DO INTERPRETADOR ONLINE DE SWIFT: http://online.swiftplayground.run/

/*
Como utilizar o programa:
Copie e cole o conteudo do arquivo no link do interpretador online.
--> Utilize a funcao cifrar, passando o texto como parametro, para criptografar a palavra ou texto
--> Utilize a funcao decifrar, passando o texto cifrado como parametro, para descriptografar a palavra ou texto
*/

struct CifraDeCesar {

    let alfabeto: [String] = ["a", "b","c","d","e", "f", "g", "h", "i", "j",
                              "k", "l", "m","n", "o", "p", "q", "r", "s",
                               "t", "u", "v", "w", "x", "y", "z"]


    func cifrar(texto: String) {
        let textoSemEspacos = texto.lowercased().trimmingCharacters(in: .whitespaces)
        var textoCifrado: String = ""

        textoSemEspacos.forEach {  caracter in 
                let posicaoCorrente = alfabeto.index(of: String(caracter)) ?? 0
                var inidiceDaPermutacao = posicaoCorrente + 3
               
                if inidiceDaPermutacao >= alfabeto.count {
                    inidiceDaPermutacao = inidiceDaPermutacao - alfabeto.count 
                }

                textoCifrado += alfabeto[inidiceDaPermutacao]
        }

        print("Texto cifrado: \(textoCifrado)")
    }


    func decifrar(texto: String) {
        let textoSemEspacos = texto.lowercased().trimmingCharacters(in: .whitespaces)
        var textoCifrado: String = ""

        textoSemEspacos.forEach {  caracter in 
                let posicaoCorrente = alfabeto.index(of: String(caracter)) ?? 0
                var inidiceDaPermutacao = posicaoCorrente - 3
               
                if inidiceDaPermutacao < 0 {
                    inidiceDaPermutacao = inidiceDaPermutacao + alfabeto.count 
                }

                textoCifrado += alfabeto[inidiceDaPermutacao]
        }
        print("Texto decifrado: \(textoCifrado)")
    }

}

//EXEMPLO DE USO
let cifra = CifraDeCesar()
cifra.cifrar(texto: "Vamos invadir no domingo")
cifra.decifrar(texto: "ydprvdlqydgludqrdgrplqjr")

