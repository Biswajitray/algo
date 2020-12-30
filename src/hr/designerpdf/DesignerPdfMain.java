package hr.designerpdf;

public class DesignerPdfMain {

    public static void main(String []s){
        String word = "zaba";
        //int[] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5   };
        int[] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7   };
        int area = designerPdfViewer(h,word);
        System.out.println(area);
    }
    static int designerPdfViewer(int[] h, String word) {
        int length = word.length();

        int area = 0;

        int height = -1;

        for (int i = 0; i < word.length(); i++) {
            int arrayPos = (word.charAt(i) % 97);

            int value = h[arrayPos];

            if(value > height)
                height = value;
        }

        area = height * length;
        return area;
    }
}
