import model.Forca;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Forca forca = new Forca();
        
        System.out.println("=== JOGO DA FORCA ===");
        System.out.println("Tente adivinhar a palavra!");
        
        // Loop principal do jogo
        while (true) {
            // Desenha o estado atual do jogo
            forca.desenha();
            
            // Lê uma letra do usuário
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine().trim();
            
            // Valida a entrada
            if (input.isEmpty()) {
                System.out.println("Por favor, digite uma letra!");
                continue;
            }
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Por favor, digite apenas uma letra válida!");
                continue;
            }
            
            char letra = input.charAt(0);
            
            // Efetua a jogada
            forca.joga(letra);
            
            // Verifica se o jogo terminou
            int resultado = forca.verificaFim();
            
            if (resultado == 1) {
                System.out.println("\n" + "=".repeat(40));
                forca.desenha();
                System.out.println("🎉 PARABÉNS! VOCÊ VENCEU! 🎉");
                System.out.println("=".repeat(40));
                break;
            } else if (resultado == 2) {
                System.out.println("\n" + "=".repeat(40));
                forca.desenha();
                System.out.println("💀 ENFORCADO! VOCÊ PERDEU! 💀");
                System.out.println("A palavra era: " + new String(forca.getPalavraSorteada()));
                System.out.println("=".repeat(40));
                break;
            }
            
            System.out.println(); // Linha em branco para separar as jogadas
        }
        
        scanner.close();
        System.out.println("\nObrigado por jogar!");
    }
}