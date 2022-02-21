package one.digitalinnovation;

import java.util.*;

/*
Dados as seguintes informações sombre as séries, crie um conjunto
e ordene este conjunto exibindo:
(nome - genero - tempo de episódio)

Serie A = Nome: VoxMochina, Genero: Fantasia TempoEpisodio: 22
Serie B = Nome: Dark, Genero: Drama, TempoEpisodio: 60
Serie C = Nome: Brooklyn 99, Genero: Comédia: TempoEpisodio: 22
*/
public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        Set<Serie> series = new HashSet<>(){{
           add(new Serie("VoxMachina", "Fantasia", 22));
           add(new Serie("Breaking Bad", "Drama", 55));
           add(new Serie("Brooklin 99", "Comedia", 22));
        }};

        System.out.println("ORDEM ALEATÓRIA");
        for (Serie serie: series) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

        System.out.println("\nORDEM DE INSERÇÃO");
        Set<Serie> seriesLinked = new LinkedHashSet<>(){{
            add(new Serie("VoxMachina", "Fantasia", 22));
            add(new Serie("Breaking Bad", "Drama", 55));
            add(new Serie("Brooklin 99", "Comedia", 22));
        }};
        for (Serie serie: seriesLinked) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

        System.out.println("\nORDEM NATURAL (DURAÇÃO)");//Duas das séries possui o mesmo tempo de duração e o Set não aceita valores iguais.
        //Para isso, devemos criar um criterio de desempate no método compareTo.
        Set<Serie> seriesTree = new TreeSet<>(seriesLinked);
        for (Serie serie: seriesTree) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

        System.out.println("\nORDEM NOME>GÊNERO>DURAÇÃO");
        Set<Serie> seriesComparatorAll = new TreeSet<>(new ComparatorNomeGeneroDuracao());
        seriesComparatorAll.addAll(series);//Recebe uma collection e adiciona todos os elementos dela.
        //Nesse caso, ele recebe e ja aplica o ComparatorNomeGeneroSerie, pois foi passado como contrutor na criação da TreeSet
        for (Serie serie: seriesComparatorAll) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

        System.out.println("\nORDEM DE GÊNERO");
        Set<Serie> seriesComparatorGenero = new TreeSet<>(new ComparatorGenero());
        seriesComparatorGenero.addAll(series);
        for (Serie serie: seriesComparatorGenero) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

        System.out.println("\nORDEM DE DURAÇÃO");
        Set<Serie> seriesComparatorDuracao = new TreeSet<>(new ComparatorDuracao());
        seriesComparatorDuracao.addAll(series);
        for (Serie serie: seriesComparatorDuracao) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " +
                    serie.getDuracao());
        }

    }
}

class ComparatorNomeGeneroDuracao implements Comparator<Serie>{

    @Override
    public int compare(Serie o1, Serie o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;
        int genero = o1.getGenero().compareTo(o2.getGenero());
        if (genero != 0) return genero;
        return o1.getDuracao().compareTo(o2.getDuracao());
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie o1, Serie o2) {
        int genero = o1.getGenero().compareTo(o2.getGenero());
        if (genero != 0) return genero;
        return o1.getNome().compareTo(o2.getNome());
    }
}

class ComparatorDuracao implements Comparator<Serie>{


    @Override
    public int compare(Serie o1, Serie o2) {
        int duracao = o1.getDuracao().compareTo(o2.getDuracao());
        if (duracao != 0) return duracao;
        return o1.getNome().compareTo(o2.getNome());
    }
}

