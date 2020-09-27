package chap1.ackermann;

public class AckermanMain {
    public static void main(String[] s)
    {
        System.out.println(aWithRecursion(2,3));
    }

    public static int aWithRecursion(int m , int n)
    {
        if( m ==0 )
            return ( n + 1 );

        if( n == 0 )
            return aWithRecursion( m -1 , 1);

        return aWithRecursion(m - 1 , aWithRecursion( m , n -1));

    }

    public static int aWithOutRecursion(int m , int n)
    {
        int value = 0 ;



        return value;
    }
}
