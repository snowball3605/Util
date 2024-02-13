package org.example.util;

import org.example.api_controller.login.Encoder_Enitiy;
import org.springframework.web.bind.annotation.RequestBody;

public class Cryptography {
    public static String unencoder(String Text, String Key) {
        int i_ = 0;
        char[] char_text = Text.toCharArray();
        char[] char_key = Key.toCharArray();
        char[] result = new char[Text.length()];
        for (int i = 0; i < Text.length(); i++) {
            i_ = (i_ + 1) % Key.length();
            result[i] = (char) (char_text[i] - char_key[i_]);
        }
        return new String(result);
    }

    public String encoder(String Text, String Key) {
        int i_ = 0;
        char[] char_text = Text.toCharArray();
        char[] char_key = Key.toCharArray();
        char[] result = new char[Text.length()];
        for (int i = 0; i < Text.length(); i++) {
            i_ = (i_ + 1) % Key.length();
            result[i] = (char) (char_key[i_] + char_text[i]);
        }
        return new String(result);
    }

}
