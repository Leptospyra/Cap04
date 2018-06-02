import java.util.Scanner;
import java.util.*;
import java.text.*;

public class ProjectsCap04 {
    public static void main(String[] args) throws ParseException {
        Scanner console = new Scanner(System.in);
        //ToRamanNumerals(console); //Exercicio 01
        //ComparaTestes(console); //Exercicio 03
        //Exercicio05(console);
        Exercicio04(console);
    }
    /*Write a program that prompts for two people’s birthdays (month and day),
     along with today’s month and day.
     The program should figure out how many days remain until each user’s birthday and which birthday is sooner.
     Hint: It is much easier to solve this problem if you convert each date into an “absolute day” of year, from 1 through 365.*/
    private static void Exercicio04(Scanner console) throws ParseException {
        System.out.println("Informe a data de hoje (dd/MM)");
        String dataHoje = console.next();
        dataHoje = dataHoje + "/2018";
        System.out.println("Informe a data do aniversario 1 (dd/MM)");
        String aniversario1 = console.next();
        aniversario1 = aniversario1 + "/2018";
        double diasAniver1 = getDiasTranscorridos(aniversario1, dataHoje);

        System.out.println("Informe a data do aniversario 2 (dd/MM)");
        String aniversario2 = console.next();
        aniversario2 = aniversario2 + "/2018";
        double diasAniver2 = getDiasTranscorridos(aniversario2, dataHoje);

        System.out.printf("Dias corridos que faltam para o aniversario 1 %s\n", diasAniver1);
        System.out.printf("Dias corridos que faltam para o aniversario 2 %s\n", diasAniver2);

        System.out.println();
        if (diasAniver1 < diasAniver2){
            System.out.println("O dia do aniversario do Aniversariante 1 está mais proximo: " + diasAniver1);
        } else {
            System.out.println("O dia do aniversario do Aniversariante 2 está mais proximo: " + diasAniver2);
        }
    }

    private static double getDiasTranscorridos(String dataFutura, String dataHoje) throws ParseException {

        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        Date d1 = df.parse (dataHoje);
        Date d2 = df.parse (dataFutura); // aqui pega a string que eu recebi no cabeçalho
        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
        return (dt / 86400000L); // passaram-se 67111 dias
    }
    /*This program computes a student’s grade in a course. The course grade has three components:
    homework assignments,
    a midterm exam,
    and a final exam.
    The program should prompt the user for all information necessary to compute the grade,     such as the number of
    homework assignments, the points earned and points possible for each assignment, the midterm and final exam scores,
    and whether each exam was curved (and, if so, by how much).*/

    private static void Exercicio05(Scanner console) {
        double trabalhos = ComputaNota(console, "Trabalho");
        double provaInicial = ComputaNota(console, "prova inicial");
        double provaFinal = ComputaNota(console, "prova final");

        double mediaFinal = (trabalhos + provaInicial + provaFinal);
        System.out.printf("A media final é %s", mediaFinal);
    }

    public static double ComputaNota(Scanner console, String tipoAvaliacao){
        System.out.printf("Informe a quantidade de %s: \n", tipoAvaliacao);
        int qtdeTrabalho = console.nextInt();
        double trabalho = 0;
        for (int i=1; i<=qtdeTrabalho; i++){
            System.out.printf("Informe a nota #%s: (de 1 a 10 pontos)\n", i);
            trabalho += console.nextInt();
        }
        if (qtdeTrabalho > 0) {
            trabalho /= qtdeTrabalho; //aqui pode ter uma div por 0
        }

        System.out.printf("informe o peso que a nota do %s terá na nota final: \n", tipoAvaliacao);
        System.out.println("é um inteiro de 1 a 10, a soma dos pesos do trabalho, prova inicial e prova final deve ser 10:");
        int pesoTrabalho = console.nextInt();

        return trabalho * pesoTrabalho;
    }
    /**Write a program that compares two college applicants. The program should prompt for each student’s GPA, SAT,
     and ACT exam scores and report which candidate is more qualified on the basis of these scores.*/
    private static void ComparaTestes(Scanner console) {
        System.out.print("Digite o Nome e as notas do aluno 1: ");
        String nome1 = console.next();
        int GPA1 = console.nextInt();
        int SAT1 = console.nextInt();
        int ACT1 = console.nextInt();

        System.out.print("Digite o Nome e as notas do aluno 2: ");
        String nome2 = console.next();
        int GPA2 = console.nextInt();
        int SAT2 = console.nextInt();
        int ACT2 = console.nextInt();

        if (GPA1>GPA2){
            System.out.printf("Nota GPA de %s é maior: %s\n", nome1, GPA1);
        } else {
            System.out.printf("Nota GPA de %s é maior: %s\n", nome1, GPA2);
        }

        if (SAT1>SAT2){
            System.out.printf("Nota SAT de %s é maior: %s\n", nome1, SAT1);
        } else {
            System.out.printf("Nota SAT de %s é maior: %s\n", nome2, SAT2);
        }

        if (ACT1>ACT2){
            System.out.printf("Nota ACT de %s é maior: %s\n", nome1, ACT1);
        } else {
            System.out.printf("Nota ACT de %s é maior: %s\n", nome2, ACT2);
        }

    }

    /*Write a program that prompts for a number and displays it in Roman numerals.*/
    private static void ToRamanNumerals(Scanner console) {
        System.out.print("Digite uma numero para testar: ");
        String resultado = "";
        int numero = console.nextInt();
        numero = ConverteParaRomanos(numero, 1000, 'M');
        numero = ConverteParaRomanos(numero, 500, 'D');
        numero = ConverteParaRomanos(numero, 100, 'C');
        numero = ConverteParaRomanos(numero, 50, 'L');
        numero = ConverteParaRomanos(numero, 10, 'X');
        numero = ConverteParaRomanos(numero, 5, 'V');
        numero = ConverteParaRomanos(numero, 1, 'I');
    }

    public static int ConverteParaRomanos(int numero, int valor, char romano){
        if (numero>=valor){
            int milhar = (numero/valor);
            for (int i=1; i<=milhar; i++){
                System.out.print(romano);
                numero -= valor;
            }
        }
        return numero;
    }
}