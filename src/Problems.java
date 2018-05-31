import java.util.Scanner;

public class Problems {
    public static void main(String[] args){
        //Problema01();
        //Problema03();
        //Problema04();
        //Problema05();
        //Problema08();
        //Problema09();
        //Problema09Certo();
        //Problema10();
        //Problema17();
        //Problema19("Heleloe");
        //Problema20("Rafael Lima");
        //Problema21("aetrneaaeqs");
        //Problema22();
        //Problema24(3,5,2);
        //Problema25(2,4,8);
        Problema26(1,2,3);
    }

    //transcrevi a solução do livro por que foi surpreendente para mim
    public static void Problema26(int n1, int n2, int n3) {
        int count = n1 % 2 + n2 % 2 + n3 % 2;
        System.out.println(count +
                " of the 3 numbers are odd.");
    }
    //Exercicio 25 aprendendo a usar Exceptions
    private static void Problema25(int a, int b, int c) {
        double x1 = 0;
        double x2 = 0;
        double delta = (b*b-4*a*c);
        if (a == 0) {
            throw new IllegalArgumentException("Valor invalido a=0 ");
        }
        if (delta < 0) {
            throw new IllegalArgumentException("Valor de Delta invalido (Delta negativo).");
        }

        x1 = (-b + Math.sqrt(delta))/(2.0 * a);
        x2 = (-b - Math.sqrt(delta))/(2.0 * a);
        System.out.println("x1: " + x1 + "x2: " + x2);

    }


    // solução do livro para imprimir o numero do meio
    private static void Problema24(int n1, int n2, int n3) {
        System.out.println(medianOf3(-3,4,2) + " é o número do meio");
    }
    public static int medianOf3(int n1, int n2, int n3) {
        return Math.max(Math.max(Math.min(n1, n2),
            Math.min(n2, n3)),
            Math.min(n1, n3));
    }

    /* COMENTARIOS PARA O EXER22
    **Consider a method printTriangleType that accepts three integer arguments representing the lengths of the sides
    **and prints the type of triangle that these sides form. equilateral, isosceles, and scalene.

    certain int values (or combinations) would be illegal and not represent the sides of an actual triangle.
    What are these values? How would you describe the precondition(s) of the printTriangleType method?
    Só irá existir um triângulo se, somente se, os seus lados obedeceram à seguinte regra:
    um de seus lados deve ser maior que o valor absoluto (módulo) da diferença dos outros dois lados
    e menor que a soma dos outros dois lados. Veja o resumo da regra abaixo:

            | b - c | < a < b + c
            | a - c | < b < a + c
            | a - b | < c < a + b */

    private static void Problema22() {
        boolean triangulo;
        triangulo = ValidaTriangulo(4,2,3);
        if (triangulo) {
            System.out.println(printTriangleType(2,2,2));
        } else {
            System.out.println("Triangulo invalido");
        }
    }

    private static boolean ValidaTriangulo(int cateto01, int cateto02, int hipotenusa) {
        if ((Math.abs(cateto02 - hipotenusa) < (cateto01)) && ((cateto02 + hipotenusa) > (cateto01))){
            if ((Math.abs(cateto01 - hipotenusa) < (cateto02)) && ((cateto01 + hipotenusa) > (cateto02))) {
                if ((Math.abs(cateto01 - cateto02) < (hipotenusa)) && ((cateto01 + cateto02) > (hipotenusa))){
                    return true;
                }
            }
        }
        return false;

    }

    private static String printTriangleType(int cateto01, int cateto02, int hipotenusa) {
        int ladosIguais = 0;
        String msg = "";
        if (cateto01 == cateto02) {
            ladosIguais++;
        }
        if (cateto01 == hipotenusa) {
            ladosIguais++;
        }
        if (cateto02 == hipotenusa) {
            ladosIguais++;
        }
        if (ladosIguais == 0 ){
            msg =("Triangulo escaleno");
        } else if (ladosIguais== 1){
            msg =("Triangulo isosceles");
        } else {
            msg =("Triangulo equilatero");
        }
        return msg;
    }

    //solução do livro (Exer22)
    public static void printTriangleType2(int s1, int s2, int s3) {
        if (s1 == s2 && s2 == s3) {
            System.out.println("equilateral");
        } else if (s1 == s2 || s1 == s3 || s2 == s3) {
            System.out.println("isosceles");
        } else {
            System.out.println("scalene");
        }
    }

    private static void Problema21(String texto) {
        texto = texto.toLowerCase();
        int count = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'n') {
                count++;
            }
        }
        System.out.println(count + " Letras são depois do 'n'");


    }

    private static void Problema20(String name) {
        int space = name.indexOf(" ");
        String lastName = name.substring(space + 1);
        String firstInitial = name.substring(0, 1);
        String lastNameFirstInitial = lastName + ", " + firstInitial + ".";
        System.out.println(lastNameFirstInitial);
    }

    private static void Problema19(String s) {
        s = s.toLowerCase();//eu preciso primeiro passar para lowercase
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            //if (s.charAt(i).toLowerCase() == 'e') {//não consigo fazer junto os 2
            if (s.charAt(i) == 'e') {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void Problema17() {
        printRange('e', 'g');
        printRange('n', 's');
        printRange('z', 'a');
        printRange('q', 'r');
    }

    public static void printRange(char startLetter, char endLetter){
        for (char letter = startLetter; letter <= endLetter; letter++) {
            System.out.print(letter);
        }
        System.out.println();
    }




    /* This programa reads a shorthand text description of a playing card and prints the longhand equivalent.
    The carta is (2 through 10, J, Q, K, or A) followed by its naipe (C, D, H, or S).
    After the programa expand the shorthand into the form “<carta> of <naipe>”. */
    private static void Problema10() {
        Scanner console = new Scanner(System.in);
        //translate short to Long Description
        String longDescription = translateDescription(console);
        System.out.println(longDescription);

    }

    private static String translateDescription(Scanner console) {
        System.out.print("Enter a card: ");
        String carta = console.next();
        String naipe = console.next();
        if (carta.equals("2")) {
            carta = "Dois";
        } else if (carta.equals("3")) {
            carta = "Tres";
        } else if (carta.equals("4")) {
            carta = "Quatro";
        } else if (carta.equals("5")) {
            carta = "Cinco";
        } else if (carta.equals("6")) {
            carta = "Seis";
        } else if (carta.equals("7")) {
            carta = "Sete";
        } else if (carta.equals("8")) {
            carta = "oito";
        } else if (carta.equals("9")) {
            carta = "Nove";
        } else if (carta.equals("10")) {
            carta = "Dez";
        } else if (carta.equals("J")) {
            carta = "Valete";
        } else if (carta.equals("Q")) {
            carta = "Dama";
        } else if (carta.equals("K")) {
            carta = "Rei";
        } else { // carta.equals("A")
            carta = "Az";
        }
        if (naipe.equals("C")) {
            naipe = "Paus";
        } else if (naipe.equals("D")) {
            naipe = "Ouros";
        } else if (naipe.equals("H")) {
            naipe = "Copas";
        } else { // naipe.equals("S")
            naipe = "Espadas";
        }
        return (carta + " " + naipe);
    }

    private static void Problema09Certo() {
        Scanner console = new Scanner(System.in);
        int numBills1 = getBills(console, "John");
        int numBills2 = getBills(console, "Jane");
        System.out.println("John needs " + numBills1 + " bills");
        System.out.println("Jane needs " + numBills2 + " bills");
    }

    public static int getBills(Scanner console, String name) {
        System.out.print("How much will " + name + " be spending? ");
        double amount = console.nextDouble();
        System.out.println();
        int numBills = (int) (amount/20.0);
        if (numBills * 20.0 < amount) {
            numBills++;
        }
        return numBills;
    }

    private static void Problema09() {
        Scanner console = new Scanner(System.in);
        //pergunta quanto John gastou
        System.out.print("How much will John be spending? ");
        double amount = console.nextDouble();
        System.out.println();
        int numBills1 = QtdeDeNotas(amount); //calcula quantidade de notas

        //pergunta quanto Jane gastou
        System.out.print("How much will Jane be spending? ");
        amount = console.nextDouble();
        System.out.println();
        int numBills2 = QtdeDeNotas(amount);

        imprimeResult("Jonh", numBills1);
        imprimeResult("Jane", numBills2);
    }

    private static void imprimeResult(String nome, int numBillsX) {
        System.out.println(nome + " needs " + numBillsX + " bills");
    }

    private static int QtdeDeNotas(double amount) {
        int numBillsX = (int) (amount / 20.0);
        if (numBillsX * 20.0 < amount) {
            numBillsX++;
        }
        return numBillsX;
    }


    private static void Problema05() {
        Scanner console = new Scanner(System.in);
        System.out.print("Type a number: ");
        int number = console.nextInt();
        if (number%2==0){
            System.out.println("The number " + number + " is even");
        } else {
            System.out.println("The number " + number + " is odd");
        }
    }


    // ** O exercicio 2 é F ou V não de programação


    public static void Problema04(){
        ifElseMystery2(10,30);
    }

    public static void ifElseMystery2(int a, int b) {
        if (a * 2 < b) {
            a = a * 3;
        } else if (a > b) {
            b = b + 3;
        }
        if (b < a) {
            b++;
        } else {
            a--;
        }
        System.out.println(a + " " + b);
    }

    public static void Problema03() {
        ifElseMystery1(3, 20);
        ifElseMystery1(4, 5);
        ifElseMystery1(5, 5);
        ifElseMystery1(6, 10);
    }
    public static void ifElseMystery1(int x, int y) {
        int z = 4;
        if (z <= x) {
            z = x + 1;
        } else {
            z = z + 9;
        }
        if (z <= y) {
            y++;
        }
        System.out.println(z + " " + y);
    }
    public static void Problema01() {
        int x = 10;
        int y = 40;
        int z = 21;

        if (z % 2 == 1) {//letra a
            System.out.println("Letra a: " + z + " is odd");
        }
        y = 900;
        if (z <= Math.sqrt(y)) {//letra b
            System.out.println("Letra b: " + z + " is not greater than y’s square root.");
        }

        if (y >= 1) {//letra c
            System.out.println("Letra c: " + y + " y is positive.");
        }

        if (((x % 2 == 0) || (y % 2 == 0)) && (z % 2 == 1)) {//letra d
            System.out.println("Letra d: " + y + " Either x or y is even, and the other is odd.");
        }

        z = 20;
        if (y % z == 0) {//letra e
            System.out.println("Letra e: " + y + "  is a multiple of " + z + ".");
        }

        if (z != 0) {//letra f
            System.out.println("Letra f: " + z + "  is not zero.");
        }

        if (y > z) {//letra g
            System.out.println("Letra g: " + y + " is greater in magnitude than " + z + ".");

            x = -10;
        }
        if (((x >= 0) && (y < 0)) || ((x < 0) && (y >= 0))) {//letra h
            System.out.println("Letra h: " + x + " and " + z + " are of opposite signs. ");

            y *= 1.0;
        }
        if (y % z == 0) {//letra i
            System.out.println("Letra i: " + y + " is a nonnegative one-digit number.");
        }

        if (z >= 0) {//letra j
            System.out.println("Letra j: " + z + " is nonnegative.");
        }

        if (x % 2 == 0) {//letra k
            System.out.println("Letra k: " + x + " is even.");
        }
        x = 39;
        y = 40;
        z = 100;
        if ((y - x) < (z - x)) {//letra l
            System.out.println("Letra l: " + x + " is closer in value to " + y + " than " + z + " is.");
        }
    }
}
