import java.util.Scanner;

public class Exercises_Cap04 {
    public static void main(String[] args){
        //fractionSum(10); // soma as n primeiras fraçoes
        //System.out.println(repl("Amanda", 3));//concatena e repete x vezes
        //System.out.println(season(10,2)); //imprime a estação do ano
        //System.out.println(pow(3,4)); // 3 * 3 * 3 * 3, 81.0
        //printRange(5,5); //[19, 18, 17, 16, 15, 14, 13, 12, 11]
        // exercicio 06
        Scanner console = new Scanner(System.in);
        //String texto = smallestLargest(console);
        //System.out.println(texto);
        //fim do exercicio 06
        //evenSumMax(console); exercicio 07
        //System.out.println(printGPA(console)); // exercicio 8 entra dados na mesma linha
        Exercicio09();
    }
    //aqui me parece que passar um objeto seria melhor, refazer quando aprender.
    private static void Exercicio09() {
        boolean triangulo;
        triangulo = ValidaTriangulo(3,2,4);
        if (triangulo) {
            System.out.println(printTriangleType(3,2,4));
        } else {
            throw new IllegalArgumentException("Triangulo invalido");   //essa linha é diferente do exercicio 22, aqui eu
                                                                        // trato o erro com exception
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

    //solução do livro (Exer22)
    public static String printTriangleType(int s1, int s2, int s3) {
        if (s1 == s2 && s2 == s3) {
            return ("equilateral");
        } else if (s1 == s2 || s1 == s3 || s2 == s3) {
            return("isosceles");
        } else {
            return("scalene");
        }
    }

    //exercicio 08
    private static double printGPA(Scanner console) {
        System.out.print("Enter a student record: ");
        String nome = console.next();
        int qtdeNotas = console.nextInt();
        int sum = 0;
        int cont = 0;
        for (int i = 1; i<= qtdeNotas; i++){
            sum = sum + console.nextInt();
        }

        return (1.0*sum/qtdeNotas);
    }


    /*The method should ask by prompt how many times its repeat. ok
    * Once the user has entered all the integers, the method should print the sum of all the even numbers,
    * along with the largest even number typed.
    * You may assume that the user will type at least one nonnegative even integer.
     */
    private static void evenSumMax(Scanner console) {
        int maior = -1000;
        int menor = 1000;
        System.out.println("Quantas numeros inteiros?");
        int qtde = console.nextInt();
        int soma = 0;
        for (int i = 1; i <=qtde; i++) {
            System.out.printf("numero %s:", i);
            int numero = console.nextInt();
            if (numero%2==0) {
                if (numero > maior) {
                    maior = numero;
                    soma += numero;
                }
            }
        }
        System.out.printf("Even sum = %s, even max = %s",soma,maior);
    }

    private static String smallestLargest(Scanner console) {
        int maior = -1000;
        int menor = 1000;
        for (int i = 1; i <=4; i++) {
            System.out.printf("numero %s:", i);
            int numero = console.nextInt();
            if (numero > maior) {
                maior = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }
        return ("menor " + menor + "; " + "maior: " + maior);

    }

    /*The method called smallestLargest that accepts a Scanner for the console as a parameter and asks the user
    to enter numbers, then prints the smallest and largest of all the numbers supplied by the user. You may assume that
    the user enters a valid number greater than 0 for the number of numbers to read. Here is a sample execution:
    */

    /*printRange accepts two integers as arguments
    * and prints the sequence of numbers between the two arguments, enclosed in square brackets.
    * Print an increasing sequence if the first argument is smaller than the second;
    * otherwise, print a decreasing sequence. If the two numbers are the same, that number should be printed between square brackets.
    * */
    private static void printRange(int n1, int n2) {
        System.out.print("[");
        if (n1 <= n2){
            for (int i = n1; i<=n2;i++ ){
                System.out.print(i);
                if (i != n2){
                    System.out.print(",");
                }
            }
        } else {
            for (int i = n1; i>=n2;i-- ){
                System.out.print(i);
                if (i != n2){
                    System.out.print(",");
                }
            }
        }
        System.out.println("]");
    }
    /*
    * Write a method called pow that accepts a base and an exponent as parameters
    * and returns the base raised to the given power.
    * */
    private static String pow(int base, int expoente) {
        String expressao = "" + base;
        for (int i=2; i<= expoente; i++){
            expressao += " * " + base;
        }

        return expressao + ", or " + Math.pow(base, expoente);
    }

    /*
    * Write a method called season
    * that takes as parameters two integers representing a month and day
    * and returns a String indicating the season for that month and day.
    * Assume that the month is specified as an integer between 1 and 12
    * (1 for January, 2 for February, and so on)
    * and that the day of the month is a number between 1 and 31.
    * If the date falls between
    * 12/16 and 3/15,  return "winter".
    *  3/16 and 6/15,  return "spring".
    *  6/16 and 9/15,  return "summer".
    *  9/16 and 12/15, return "fall".
    * */

    private static String season(int month, int day) {
        if        ((month>=3) && (month<=6)) {
            if ((month == 3) && (day < 16)){
                return "winter";
            }
            if ((month == 6) && (day > 15)){
                return "summer";
            }
            return "spring";
        } else if ((month>=6) && (month<=9)) {
            if ((month == 6) && (day < 16)){
                return "spring";
            }
            if ((month == 9) && (day > 15)){
                return "fall";
            }
            return "summer";
        } else if ((month>=9) && (month<=12)) {
            if ((month == 9) && (day < 16)){
                return "summer";
            }
            if ((month == 12) && (day > 15)){
                return "winter";
            }
            return "fall";
        } else {  //((month>=12) && (month<=3))
            if ((month == 12) && (day < 16)){
                return "fall";
            }
            if ((month == 3) && (day > 15)){
                return "spring";
            }
            return "winter";
        }
    }


    /*
    * repl accepts a String and a number of repetitions as parameters
    * and returns the String concatenated that many times.
    * For example, the call repl("hello", 3) should return "hellohellohello".
    * If repetitions is 0 or less, the method should return an empty string.
    * */
    private static String repl(String frase, int repet) {
        String newFrase = "";
        for (int i = 1; i <= repet; i++) {
            newFrase = newFrase + frase;
        }
        return newFrase;
    }

    /*Write a method called fractionSum that accepts an integer parameter n and
    returns as a double the sum of the first n terms of the sequence*/
    public static void fractionSum(int n){
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum = sum + (1.0/i);
            System.out.println(sum);
        }
        System.out.printf("%3.2f É a soma das %s primeiras frações",sum, n);
    }
}
