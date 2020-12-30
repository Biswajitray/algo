package hr.factorial;

public class FactorialMain {

    public static void main(String s[]) {
        System.out.println(factorial(3));
        System.out.println(factorial(2));
        System.out.println(factorial(1));
    }
    static int factorial(int n) {

        int value = 1;

        if(n == 1)
            return value;

        value = n * factorial(n -1);

        return value;
    }
}
