package pl.benzo.enzo.bet.kafka.logic.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtractor {
    public static String[] extractFighters(String eventName) {
        Pattern pattern = Pattern.compile(":\\s*(.*?)\\s+vs\\.\\s+(.*?)\\s+\\d");
        Matcher matcher = pattern.matcher(eventName);

        if (matcher.find()) {
            return new String[]{matcher.group(1), matcher.group(2)};
        }
        return null;
    }
}
