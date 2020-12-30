package trial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TrialMain {

    public static void main(String s[]){
        checkFilePath(null);
    }
    private static void checkFilePath(String value){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("algo\\common.properties"));
            String path = properties.getProperty("stealth.jdbc.location");
            System.out.println("PATH ==> " + path);
            StringBuilder modifiedValue = new StringBuilder();
            String[] fileNameParts = path.split(File.separatorChar + "" + File.separatorChar);
            boolean addSeparator = false;
            for (String dirName : fileNameParts) {
                if (addSeparator)
                    modifiedValue.append(File.separator + File.separator);
                modifiedValue.append(dirName);
                addSeparator = true;
            }
            System.out.println("Modified Path " + modifiedValue.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
