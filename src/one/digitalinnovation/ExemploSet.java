package one.digitalinnovation;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(
                7.0, 8.5, 9.3, 5.0, 7.0, 0.0, 3.6));
        System.out.println(notas.toString());//O valor 7.0 não se repete.

        /*
         * Não é possivel a realização dos seguintes itens:
         * Exiba a posição da nota 5.0 -> Não possui o método indexOf.
         * Adicione na lista a nota 8.0 na posição 4 -> O Set é aleatório, e por sua vez não possui index.
         * Substitua a nota 5.0 pela nota 6.0 -> Não existe o método .set (notas.set)
         * Exiba a terceira nota adicionada -> Não é possivel passar o index (inexistente) para o método get.
         * Remova a nota da posição 0 -> Não é possivel saber qual a posição 0.
         * */

        System.out.println("\nConfira se a nota 5.0 esta no conjunto: " + notas.contains(5d));

        System.out.println("\nExiba a menor nota: " + Collections.min(notas));//Collections.min() aceita somente uma coleção, e o set é uma coleção.

        System.out.println("\nExiba a maior nota: " + Collections.max(notas));//Idem ao anterior.

        System.out.println("\nExiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) soma += iterator.next();
        System.out.println("Soma = " + soma);//Lembrando que o Set não repete elementos, por isso da diferença.

        System.out.println("\nExiba a média das notas: " + (soma / notas.size()));

        System.out.println("\nRemova a nota 0:");
        notas.remove(0d);//Não passamos index pois, de novo, ele não existe.
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7 e exiba o set: ");
        Iterator<Double> iteratorRemove = notas.iterator();
        while (iteratorRemove.hasNext()) if (iteratorRemove.next() < 7) iteratorRemove.remove();
        System.out.println(notas);

        System.out.println("\nExiba todas as notas na ordem em que foram informados: ");
        //Para isso, vamos criar um novo Set, mas dessa vez utilizando o LinkedHashSet para guardar a ordem de inserção.
        Set<Double> notasLinked = new LinkedHashSet<>();
        notasLinked.add(7d);
        notasLinked.add(8.5);
        notasLinked.add(9.3);
        notasLinked.add(5d);
        notasLinked.add(7d);//Este não será inserido pois é igual ao primeiro add.
        notasLinked.add(0d);
        notasLinked.add(3.6);
        System.out.println(notasLinked);

        System.out.println("\nExiba todas as notas na ordem crescente: ");
        //Para isso, precisamos criar uma TreeSet, pois ela ja organiza na ordem natural
        //O Double implementa o Comparable, portanto, será possivel implementar a TreeSet
        Set<Double> notasTree = new TreeSet<>(notasLinked);//Passando os elementos da Linked para a Tree
        System.out.println(notasTree);//Ja esta na ordem natural dos elementos.

        System.out.println("\nApague todo o conjunto: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("\nConfira se o conjunto esta vazio:");
        System.out.println("Notas Set: " + notas.isEmpty());
        System.out.println("Notas LinkedSet: " + notasLinked.isEmpty());
        System.out.println("Notas TreeSet: " + notasTree.isEmpty());

    }
}
