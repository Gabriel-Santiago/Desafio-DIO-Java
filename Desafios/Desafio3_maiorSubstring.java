package Desafios;

/*

Desafio
Encontre a maior substring comum entre as duas strings informadas. A substring pode ser qualquer parte da string, inclusive ela toda. Se não houver subseqüência comum, a saída deve ser “0”. A comparação é case sensitive ('x' != 'X').

Entrada
A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas, cada uma contendo uma string. Ambas strings de entrada contém entre 1 e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma letra ('A'-'Z','a'-'z').

Saída
O tamanho da maior subsequência comum entre as duas Strings.

*/

import java.util.Scanner;

public class Desafio3_maiorSubstring {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
    
        String word1;
        String word2;
        
        while(scr.hasNextLine()) {
    
            word1 = scr.nextLine();
            word2 = scr.nextLine();
    
            int tamMax = 0;
    
            if (word2.length() > word1.length()) {
                String maiorPalavra = word2;
                word2 = word1;
                word1 = maiorPalavra;
            }
    
            for (int i = 0; i < word2.length(); i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (word1.contains(word2.substring(j, word2.length() - i + j))) {
                        tamMax = Math.max(tamMax, word2.length() - i);
                    }
                }
            }
            System.out.println(tamMax);
        }
    }
}