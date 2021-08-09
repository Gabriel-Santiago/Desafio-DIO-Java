package desafios;

/*

Desafio
Leonardo é um nômade digital e viaja pelo mundo programando em diferentes cafés das cidades por onde passa. Recentemente, resolveu criar um blog, para compartilhar suas experiências e aprendizados com seus amigos.

Para criação do blog, ele optou por utilizar uma ferramenta pronta, que há um limite de caracteres que se pode escrever por dia, e Leonardo está preocupado que essa limitação, afinal, irá impedir de contar suas melhores experiências. Para contornar esse problema, decidiu usar um sistema de abreviação de palavras em seus posts.

O sistema de abreviações é simples e funciona da seguinte forma: para cada letra, é possível escolher uma palavra que inicia com tal letra e que aparece no post. Uma vez escolhida a palavra, sempre que ela aparecer no post, ela será substituída por sua letra inicial e um ponto, diminuindo assim o número de caracteres impressos na tela.

Por exemplo, na frase: “hoje eu programei em Python”, podemos escolher a palavra “programei” para representar a letra ‘p', e a frase ficará assim: “hoje eu p. em Python”, economizando assim sete caracteres. Uma mesma palavra pode aparecer mais de uma vez no texto, e será abreviada todas as vezes. Note que, se após uma abreviação o número de caracteres não diminuir, ela não deve ser usada, tal como no caso da palavra “eu” acima.

Leonardo precisa que seu post tenha o menor número de caracteres possíveis, e por isso pediu a sua ajuda. Para cada letra, escolha uma palavra, de modo que ao serem aplicadas todas as abreviações, o texto contenha o menor número de caracteres possíveis.

Entrada
Haverá diversos casos de teste. Cada caso de teste é composto de uma linha, contendo uma frase de até 10⁴ caracteres. A frase é composta de palavras e espaços em branco, e cada palavra é composta de letras minúsculas ('a'-'z'), e contém entre 1 e 30 caracteres cada.

O último caso de teste é indicado quando a linha dada conter apenas um “.”, o qual não deverá ser processado.

Saída
Para cada caso de teste, imprima uma linha contendo a frase já com as abreviações escolhidas e aplicadas.

Em seguida, imprima um inteiro N, indicando o número de palavras em que foram escolhidas uma letra para a abreviação no texto. Nas próximas N linhas, imprima o seguinte padrão “C. = P”, onde C é a letra inicial e P é a palavra escolhida para tal letra. As linhas devem ser impressas em ordem crescente da letra inicial.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.*;


public class Desafio1_AbreviacaoPalavra {
  public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var line = br.readLine();
        while(!line.equals(".")) {
        StringTokenizer st = new StringTokenizer(line);

    Map<String, String> words = new HashMap<>();
    List<String> listWords = new ArrayList<>();
    Map<String, Integer> wordsLength = new HashMap<>();

    var output = "";
    //insira sua solução aqui
    while (st.hasMoreTokens()) {
        var word = st.nextToken();
        if(word.equals("."))
            continue;

        if(wordsLength.containsKey(word)) {
            var length = wordsLength.get(word);
            wordsLength.put(word, (word.length()-2) + length);
        } else {
            wordsLength.put(word, word.length()-2);
        }

        listWords.add(word);
    }

    for (String word: listWords ) {
        var key = word.charAt(0)+".";

        var lengthWord = wordsLength.get(word);
        var lengthInMap = wordsLength.get(words.get(key));

        if(!words.containsKey(key) && word.length() > 2) {
            words.put(key, word);
        } else if( words.containsKey(key) && lengthInMap < lengthWord ) {
            words.put(key, word);
        }
    }

    for (String word: listWords ) {
        var key = word.charAt(0)+".";

        if(!words.containsValue(word)) {
            output += output.isEmpty() ? word : " "+word;
        } else {
            output += output.isEmpty() ? key : " "+key;
        }
    }

    if(words.size() > 0)
    {
        System.out.println(output);
        System.out.println(words.size());
        words.entrySet()
                .stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
    }
    line = br.readLine();
    }
    }
}
