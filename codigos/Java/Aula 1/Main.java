import java.util.ArrayList;

class Main {

    public static double calcularRaiz(double numero) {
        double raiz = 1;

        while (raiz * raiz < numero) {
            raiz++;
        }
        if (raiz == numero) {
            return raiz;
        }

        double limiteInferior = raiz - 1;
        double limiteSuperior = raiz;

        raiz = (limiteInferior + limiteSuperior) / 2;

        double erro = raiz * raiz - numero;

        erro = (erro >= 0) ? erro : -erro;

        while (erro > 1E-10) {
            if (raiz * raiz > numero)
                limiteSuperior = raiz;
            if (raiz * raiz < numero)
                limiteInferior = raiz;

            raiz = (limiteInferior + limiteSuperior) / 2;
            erro = raiz * raiz - numero;
            erro = (erro >= 0) ? erro : -erro;
        }

        return raiz;
    }

    public static ArrayList<Integer> dividores(int numero) {

        ArrayList<Integer> divisoresList = new ArrayList<>();

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0)
                divisoresList.add(i);
        }

        return divisoresList;
    }

    public static int mdcComparando(int numero1, int numero2) {
        numero1 = (numero1 > 0) ? numero1 : -numero1;
        numero2 = (numero2 > 0) ? numero2 : -numero2;

        int mdc = 1;

        ArrayList<Integer> divisores1 = dividores(numero1);
        ArrayList<Integer> divisores2 = dividores(numero2);

        for (int i = 0; i < divisores1.size(); i++) {
            for (int j = 0; j < divisores2.size(); j++) {
                if (divisores1.get(i) == divisores2.get(j)) {
                    mdc = divisores1.get(i);
                }
            }
        }

        return mdc;
    }

    public static int mdcDS(int numero1, int numero2) {
        numero1 = (numero1 > 0) ? numero1 : -numero1;
        numero2 = (numero2 > 0) ? numero2 : -numero2;
        int dividendo = (numero1 > numero2) ? numero1 : numero2;
        int divisor = (numero1 > numero2) ? numero2 : numero1;

        int resto;

        while (dividendo % divisor != 0) {
            resto = dividendo % divisor;
            dividendo = divisor;
            divisor = resto;
        }

        return divisor;
    }

    public static int mmc(int numero1, int numero2) {

        numero1 = (numero1 > 0) ? numero1 : -numero1;
        numero2 = (numero2 > 0) ? numero2 : -numero2;

        return (numero1 * numero2) / mdcDS(numero1, numero2);

    }

    public static boolean isPrimo(int numero) {

        int nDivisores = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0)
                nDivisores++;
        }

        return nDivisores == 2;

    }

    public static int primoFromLista(int pos) {
        int posicao = 1;
        int primo = 2;

        while (posicao < pos) {
            primo++;
            if (isPrimo(primo)) {
                posicao++;
            }
        }

        return primo;

    }

    public static int mmcEscola(int numero1, int numero2) {
        numero1 = (numero1 > 0) ? numero1 : -numero1;
        numero2 = (numero2 > 0) ? numero2 : -numero2;

        int mmc = 1;
        int primo;
        int posicao = 1;

        while (numero1 != 1 || numero2 != 1) {

            primo = primoFromLista(posicao);

            while (numero1 % primo == 0 || numero2 % primo == 0) {

                if (numero1 % primo == 0 && numero2 % primo == 0) {
                    numero1 = numero1 / primo;
                    numero2 = numero2 / primo;
                    mmc = mmc * primo;
                } else {
                    if (numero1 % primo == 0) {
                        numero1 = numero1 / primo;
                        mmc = mmc * primo;
                    } else {
                        numero2 = numero2 / primo;
                        mmc = mmc * primo;
                    }

                }
            }
            posicao++;

        }

        return mmc;
    }

    public static void main(String[] args) {

        System.out.println(mmc(45, 685));
        System.out.println(mmcEscola(45, 685));
    }

}