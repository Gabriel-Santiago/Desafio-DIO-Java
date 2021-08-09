/*
Desafio
Você receberá dois valores inteiros. Faça a leitura e em seguida calcule o produto entre estes dois valores. Atribua esta operação à variável PROD, mostrando esta de acordo com a mensagem de saída esperada (exemplo abaixo).   

Entrada
A entrada contém 2 valores inteiros.

Saída
Exiba a variável PROD conforme exemplo abaixo, tendo obrigatoriamente um espaço em branco antes e depois da igualdade.


*/

import java.util.Scanner;

public class Multiplicacao {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int num1, num2, total;
        
        System.out.println("");
        num1 = ler.nextInt();
        System.out.println("");
        num2 = ler.nextInt();
        
        total = num1 * num2;
        
        System.out.println("PROD = " + total);  
    }  
}
