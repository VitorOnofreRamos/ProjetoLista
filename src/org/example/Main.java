package org.example;

import org.example.Deck.Carta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double precomedio = 0;

        // Otimização - Adiciona os itens todos de uma vez, ao invés de um por um.
        List<Carta> cartas = Arrays.asList(
                new Carta("Black Lotus", "Artefato", "Mítica", 10000.0),
                new Carta("Lightning Bolt", "Feitiço Instantâneo", "Comum", 2.0),
                new Carta("Island", "Terra Básica", "Comum", 0.1),
                new Carta("Serra Angel", "Criatura", "Incomum", 1.5)
        );

        // A variável cartascomuns vai receber:
        // 1 - stream -> permite manipular lista
        // 2 - filter -> filtra uma lista por um determindado parâmetro
        // 3 - getRaridade -> pega raridade da carta
        // 4 - equalsIgnoreCase -> Compara indempedente de ser maiusculo ou minusculo
       var cartascomuns = cartas.stream().filter(carta -> carta.getRaridade().equalsIgnoreCase("Comum"));

        // A variável cartaspreco vai receber:
        // 1 - stream -> permite manipular lista
        // 2 - filter -> filtra uma lista por um determindado parâmetro
        // 3 - getPreco -> pega o preco da carta da carta
        // 4 - getPreco > 5.0 -> Compara se o preco da carta é maior que 5.0
       var cartaspreco = cartas.stream().filter(carta -> carta.getPreco() > 5.0);

       cartascomuns.forEach(carta -> System.out.println("As cartas comuns são: " + carta.getNome() + " -> Raridade: " + carta.getRaridade() + "\n - "));

       cartaspreco.forEach(carta -> System.out.println("As cartas com um valor maior que 5 são: " + carta.getNome()+ " -> Valor: " + carta.getPreco() + "\n - "));

        for (var carta:
             cartas) {

            precomedio += carta.getPreco();

            System.out.println("Os nomes das cartas em maiúsculo são: " + carta.getNome().toUpperCase() + "\n - ");
        }

        precomedio = precomedio / cartas.size();
        System.out.println("O preco medio de todas as cartas é: " + precomedio);
    }
}
