package one.digitalinnovation;
/*
Crie um conjunto contendo as cores do arco-íris e:
- Exiba todas as cores uma abaixo da outra
- A quantidade de cores que o arco-íris tem
- Exiba as cores em ordem alfabética
- Exiba as cores na ordem inversa da que foi informada
- Exiba todas as cores que começam com a letra ”v”
- Remova todas as cores que não começam com a letra “v”
- Limpe o conjunto
- Confira se o conjunto está vazio
*/

import java.util.*;

public class ArcoIris {
    public static void main(String[] args) {
        Set<String> arcoIris = new HashSet<>(){{
            add("Vermelho");
            add("Laranja");
            add("Amarelo");
            add("Verde");
            add("Azul");
            add("Azul-escuro");
            add("Violeta");
        }};

        System.out.println("Exiba as cores uma abaixo da outra:");
        for (String cores: arcoIris) {
            System.out.println(cores);
        }

        System.out.print("\nA quantidade de cores que o arco-íris tem: ");
        System.out.println(arcoIris.size());

        System.out.println("\nExiba as cores em ordem alfabética: ");
        Set<String> arcoIrisTree = new TreeSet<>(arcoIris);
        for (String cores: arcoIrisTree) {
            System.out.println(cores);
        }

        System.out.println("\nExiba as cores na ordem INVERSA da que foram informadas:");
        Set<String> arcoIrisLinked = new LinkedHashSet<>(Arrays.asList("Vermelho", "Laranja", "Amarelo", "Verde", "Azul", "Azul-escuro", "Violeta"));
        List<String> listaCores = new ArrayList<>(arcoIrisLinked);
        Collections.reverse(listaCores);
        System.out.println(listaCores);

        System.out.println("\nExiba todas as cores que começam com a letra 'V':");
        for (String cores: arcoIris) {
            if (cores.startsWith("V")) System.out.println(cores);
        }

        System.out.println("\nRemova todas as cores que NÃO COMEÇAM com 'V':");
        Iterator<String> iteratorCores = arcoIris.iterator();
        while (iteratorCores.hasNext()){
            if (!iteratorCores.next().startsWith("V")) iteratorCores.remove();
        }
        System.out.println(arcoIris);

        System.out.println("\nLimpe o conjunto e confira se está vazio: ");
        arcoIris.clear();
        System.out.println(arcoIris);
    }
}
