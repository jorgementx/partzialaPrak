package partzialaPrak.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propietateak {
    public static Properties lortuEzarpenak()  {
        Properties properties = null;

        try (InputStream in = Propietateak.class.getResourceAsStream("/setup.properties")) {
            properties = new Properties();
            properties.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
