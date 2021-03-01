package dev.titanlabs.mpt.mc.common.enums;

import java.util.regex.Pattern;

public enum Flag {

    VERBOSE;

    private final String flag;

    private final static Pattern PATTERN = Pattern.compile("^--(.+)$");

    Flag() {
        this.flag = "--".concat(this.toString());
    }

    public static boolean isFlag(String string) {
        return PATTERN.matcher(string).find();
    }

    public String getFlag() {
        return this.flag;
    }
}
