import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String menu = "n";
        String numero;
        String baseAtual;
        String baseDesejada;
        String resposta;

        Scanner sc = new Scanner(System.in);

        do {
            Console.limpar();
            System.out.println("##########    Conversor de Base   ##########\n\n");
            System.out.println("Digite o número a ser convertido:");
            numero = sc.nextLine();
            numero = numero.toLowerCase();

            System.out.println("Digite a base atual do número:");
            baseAtual = sc.nextLine();
            baseAtual = baseAtual.toLowerCase();

            if (!Core.validarBases(baseAtual)) {

                System.out.println("\nBase digitada não é válida:");
                System.out.println("Bases aceitas (2,3,4,5,6,7,8,9,10 ou hex)\n\n");
                Console.pause();
                continue;
            }

            if (!Core.validarNumeroBase(numero, baseAtual)) {
                System.out.println("\nO número " + numero + " não está na base " + baseAtual + "\n");
                Console.pause();
                continue;
            }

            System.out.println("\nDigite a base para qual deseja converter");
            baseDesejada = sc.nextLine();
            baseDesejada = baseDesejada.toLowerCase();

            if (!Core.validarBases(baseDesejada)) {

                System.out.println("\nBase digitada não é válida:");
                System.out.println("Bases aceitas (2,3,4,5,6,7,8,9,10 ou hex)\n\n");
                Console.pause();
                continue;
            }

            resposta = Core.converterBase(numero, baseAtual, baseDesejada);
            System.out.println("\nResposta: " + resposta + "\n\n");

            System.out.println("\nDeseja fechar: (s/n)");
            menu = sc.nextLine();

        } while (!menu.equals("s"));

        sc.close();
    }
}