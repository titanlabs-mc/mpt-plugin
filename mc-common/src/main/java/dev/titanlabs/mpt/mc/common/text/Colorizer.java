package dev.titanlabs.mpt.mc.common.text;

public class Colorizer {
    private static final char SECTION_CHAR = '\u00A7';
    private static final char AMPERSAND_CHAR = '&';
    private static final String COLOR_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";

    public static String color(String string) {
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == AMPERSAND_CHAR && COLOR_CODES.indexOf(charArray[i + 1]) > -1) {
                charArray[i] = SECTION_CHAR;
                charArray[i + 1] = Character.toLowerCase(charArray[i + 1]);
            }
        }
        return new String(charArray);
    }
}
