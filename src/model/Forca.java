package model;

import interfaces.Desenhavel;
import interfaces.Jogavel;
import java.util.*;

public class Forca implements Desenhavel, Jogavel {
    private List<String> palavras;
    private List<Character> tentativas;
    private char[] palavraSorteada;
    private char[] palavraDigitada;
    private int erros;
    
    // Construtor
    public Forca() {
        this.palavras = Arrays.asList(
            "abacaxi", "algoritmo", "amizade", "animal", "arvore",
            "banana", "biblioteca", "bicicleta", "borboleta", "brasileiro",
            "cachorro", "cafe", "calendario", "caminho", "carro",
            "celular", "chocolate", "cidade", "cinema", "computador",
            "coracao", "development", "desenvolvimento", "diamante", "dicionario",
            "elefante", "energia", "escola", "espelho", "estrela",
            "familia", "felicidade", "floresta", "forca", "fotografia",
            "futebol", "garagem", "girassol", "historia", "hospital",
            "Implementacao", "interface", "internet", "janela", "jardim",
            "java", "jogo", "lampada", "liberdade", "lua",
            "machine", "medicina", "montanha", "musica", "natureza",
            "notebook", "oceano", "openai", "paisagem", "palavra",
            "passaro", "piano", "planeta", "ponte", "praia",
            "programacao", "quadro", "queijo", "rainha", "relogio",
            "revista", "rio", "sabedoria", "sapato", "servidor",
            "software", "sol", "sonho", "tartaruga", "tecnologia",
            "telefone", "telescopio", "temperatura", "teclado", "tigre",
            "tornado", "trabalho", "trem", "tropical", "universo",
            "ventilador", "verde", "viagem", "videogame", "violino",
            "vulcao", "xadrez", "zebra", "zoologico", "nuvem"
        );
        this.tentativas = new ArrayList<>();
        this.erros = 0;
        
        // Sorteia uma palavra
        String palavra = palavras.get(new Random().nextInt(palavras.size()));
        this.palavraSorteada = palavra.toCharArray();
        
        // Inicializa palavraDigitada com underlines
        this.palavraDigitada = new char[palavraSorteada.length];
        Arrays.fill(palavraDigitada, '-');
    }
    
    // Construtor alternativo que recebe uma lista personalizada de palavras
    public Forca(List<String> palavrasPersonalizadas) {
        this.palavras = palavrasPersonalizadas;
        this.tentativas = new ArrayList<>();
        this.erros = 0;
        
        // Sorteia uma palavra
        String palavra = palavras.get(new Random().nextInt(palavras.size()));
        this.palavraSorteada = palavra.toCharArray();
        
        // Inicializa palavraDigitada com underlines
        this.palavraDigitada = new char[palavraSorteada.length];
        Arrays.fill(palavraDigitada, '-');
    }
    
    // Implementação do método desenha
    @Override
    public void desenha() {
        // Desenha o boneco baseado no número de erros
        System.out.println();
        switch (erros) {
            case 0:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 1:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 2:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 3:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 4:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 5:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |   /");
                System.out.println(" |");
                System.out.println("_|___");
                break;
            case 6:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   /|\\");
                System.out.println(" |   / \\");
                System.out.println(" |");
                System.out.println("_|___");
                System.out.println("ENFORCADO!");
                break;
        }
        
        // Mostra as letras digitadas e a palavra atual
        System.out.println("\nLetras Digitadas: " + tentativas);
        System.out.println("Palavra: " + new String(palavraDigitada));
        System.out.println("Erros: " + erros + "/6");
        System.out.println("---");
    }
    
    // Implementação do método joga
    @Override
    public void joga(char letra) {
        // Converte para minúsculo para padronizar
        letra = Character.toLowerCase(letra);
        
        // Verifica se a letra já foi tentada
        if (tentativas.contains(letra)) {
            System.out.println("Letra '" + letra + "' já foi tentada!");
            return;
        }
        
        // Adiciona a letra às tentativas
        tentativas.add(letra);
        Collections.sort(tentativas); // Mantém as tentativas ordenadas
        
        // Verifica se a letra está na palavra sorteada
        boolean acertou = false;
        for (int i = 0; i < palavraSorteada.length; i++) {
            if (palavraSorteada[i] == letra) {
                palavraDigitada[i] = letra;
                acertou = true;
            }
        }
        
        // Se não acertou, incrementa erros
        if (!acertou) {
            erros++;
            System.out.println("Letra '" + letra + "' não encontrada!");
        } else {
            System.out.println("Boa! Letra '" + letra + "' encontrada!");
        }
    }
    
    // Implementação do método verificaFim
    @Override
    public int verificaFim() {
        // Verifica se a palavra foi acertada
        if (Arrays.equals(palavraDigitada, palavraSorteada)) {
            return 1; // Vitória
        }
        
        // Verifica se o número de erros chegou ao limite (6)
        if (erros >= 6) {
            return 2; // Derrota
        }
        
        // Jogo não terminou
        return 0;
    }
    
    // Métodos getters para acesso controlado (opcional)
    public char[] getPalavraSorteada() {
        return palavraSorteada.clone(); // Retorna cópia para proteger o original
    }
    
    public List<Character> getTentativas() {
        return new ArrayList<>(tentativas); // Retorna cópia
    }
    
    public int getErros() {
        return erros;
    }
}