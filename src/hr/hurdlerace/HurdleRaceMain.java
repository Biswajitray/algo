package hr.hurdlerace;

public class HurdleRaceMain {
    public static void main(String[] s) {
        int k =4;
        //int[] h = { 1 , 6, 3,5,2};

        k = 7;
        int[] h = { 1 , 6, 3,5,2};
        System.out.println(hurdleRace(k,h));
    }
    static int hurdleRace(int k, int[] height) {
        int dose = 0;

        int prev = height[0];
        int maxHeight = prev;
        for (int i = 1; i < height.length; i++) {
            int curr = height[i];
            if( curr > maxHeight)
                maxHeight = curr;

        }
        if(maxHeight > k)
            dose = maxHeight - k ;
        return dose;
    }

}
