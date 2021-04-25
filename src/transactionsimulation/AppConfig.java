package transactionsimulation;

import java.io.*;
import java.util.*;


public class AppConfig {
    private static AppConfig inst = null;
    Set<String> setOfParams = new HashSet<>();
    HashMap<String, String> hm =new HashMap<>();


    public String getConfParamValue(String k) {
        return hm.get(k);
    }

    public int getNumberOfThread() {
        return numberOfThread;
    }

    int numberOfThread;

    private AppConfig() {

        File file = new File("resources/conf.properties");

        FileInputStream fp = null;
        try {
            fp = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setOfParams = prop.stringPropertyNames();
        setOfParams.forEach((a) -> hm.put(a, prop.getProperty(a)) );
    }

    public static AppConfig getInstance() {
        if (inst == null) {
            synchronized (AppConfig.class) {
                if (inst == null) {
                    inst = new AppConfig();
                }
            }
        }
        return inst;
    }
}
