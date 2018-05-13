package other;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Stash {

    private static Map<String, Object> stash = new HashMap<>();


    public static final String filmNameString = "filmName";
    public static final String filmNumbersString = "filmNumbers";

    public static Object get (String key){
        return stash.get(key);
    }

    public static void put(String key, Object value){
        stash.put(key, value);
    }

    public static WebDriver getDriver(){
        return (WebDriver) stash.get("driver");
    }
}
