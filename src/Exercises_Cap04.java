public class Exercises_Cap04 {
    public static void main(String[] args){
        //fractionSum(10); // soma as n primeiras fraçoes
        //System.out.println(repl("Amanda", 3));//concatena e repete x vezes
        System.out.println(season(10,2)); //imprime a estação do ano
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
