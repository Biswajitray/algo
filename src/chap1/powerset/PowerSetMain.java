package chap1.powerset;

public class PowerSetMain {
    public static void main(String[] s)
    {
        String[] a = { "a" , "b", "c", "d"};
        String powerSet[] = powerSet(a , a.length);

        for (int i = 0; i < powerSet.length; i++) {
            System.out.println(powerSet[i]);
        }
    }
    private static String[] powerSet(String[] a , int combinationSize)
    {
        if(combinationSize == 1 )
            return a;

        String[] value = powerSet(a, --combinationSize);

        String valueString = "";

        for (int i = 0; i < value.length; i++) {
            valueString += value[i];
            valueString += ",";
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if(value[j].indexOf(a[i]) == -1 ) {
                    String tempValue =  a[i] + value[j];
                    tempValue = sort(tempValue);
                    if(valueString.indexOf(tempValue) == -1)
                    {
                        valueString += tempValue;
                        valueString += ",";
                    }
                }
            }
        }
        valueString = valueString.substring(0 , valueString.length() - 1);


        return valueString.split(",");
    }

    private static String sort(String s)
    {
        char[] stringChar = s.toCharArray();
        for (int i = 0; i < stringChar.length; i++) {
            for (int j = i; j < stringChar.length; j++) {
                if(stringChar[i] > stringChar[j])
                {
                    char temp = stringChar[i];
                    stringChar[i] = stringChar[j];
                    stringChar[j] = temp;
                }
            }
        }

        return new String(stringChar);
    }
}
