public class Exercises_Cap04 {
    public static void main(){
        fractionSum(5);
    }
    /*Write a method called fractionSum that accepts an integer parameter n and
    returns as a double the sum of the first n terms of the sequence*/
    public static void fractionSum(int n){
        double sum = 0.0;
        for (int i = 1; i<=n; n++) {
            sum += 1/n ;
        }
        System.out.println(sum + " é a soma das " + n +" primeiras frações");
    }
}
