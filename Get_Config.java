package org.example.Util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class Get_Config {
    public static String Yaml(String Path, String KeyWord, boolean Separation, String... KeyWorld2) {
        Yaml yaml = new Yaml();

        InputStream inputStream = Get_Config.class.getClassLoader().getResourceAsStream(Path);
        Map<String, Object> yamlmap = yaml.load(inputStream);

        if (yamlmap != null) {
            if (Separation && KeyWorld2.length >= 1) {
                Map<String, Object> databaseConfig = (Map<String, Object>) yamlmap.get(KeyWord);
                String message = databaseConfig.get(KeyWorld2[0]).toString();
                return message;
            } else {
                return yamlmap.get(KeyWord).toString();
            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(Yaml("Lang/zh_TW.yml", "help_help", false));
    }
}
