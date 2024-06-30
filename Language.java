package org.example;


public class Language {

    private static String language(long GuildID) {
        String Lang = Get_Config.path_Yaml("Backup/config.yml", "Lang");
        return Lang;
    }

    public static String Main_(long GuildID, String KeyWord) {
        String Language = language(GuildID) + ".yml";
        return Get_Config.path_Yaml("Backup/Lang/" + Language, KeyWord);
    }
}
