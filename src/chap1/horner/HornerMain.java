package chap1.horner;

public class HornerMain {
    public static void main(String[] s)
    {
        int[] a = { 9,7,5,3,1};
        int valueOfX = 2;
        int value = getPolynomialResult(0 , a, 2);
        System.out.println("Value ==> " + value);
    }

    private static int getPolynomialResult(int polynomialDegree , int[] a , int valueOfX)
    {
        if(polynomialDegree == (a.length - 1) )
            return a[polynomialDegree];
        else
            return a[polynomialDegree] + getPolynomialResult( ++polynomialDegree , a , valueOfX)  * valueOfX;
    }
}
