package chap1.binomial;

public class BinomialMain {

    public static void main(String[] s)
    {
        binomialWithFactorial(1 , 0);
    }

    private static void binomialWithFactorial( int n , int m)
    {
        int number = factorialWithRecursion(n) / (factorialWithRecursion(m) * factorialWithRecursion( n - m ));
        System.out.println(number);

        number  = factorialWithIteration(n) / (factorialWithIteration(m) * factorialWithIteration( n - m ));
        System.out.println(number);
    }
    public static int factorialWithRecursion(int n)
    {
        if ( n <= 0) return 1;

        return n * factorialWithRecursion(--n ) ;
    }

    public static int factorialWithIteration(int n)
    {
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul *= i;
        }

        return mul;
    }
}
