package fr.gwombat.tests.substrings;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by guillaume.
 *
 * @since 11/08/2018
 */
public class TestSubstrings {

    public static void main(String[] args) {
        List<String> availableKeys = Arrays.asList(
                "fr/my-site/my-page/column-1/property1",
                "fr/my-site/my-page/column-1/property2",
                "fr/my-site/my-page/column-2/property1",
                "fr/my-site/my-page/column-2/property2",
                "fr/my-site/my-page/other/property1");

        String prefix = "fr/my-site/my-page";

        System.out.println("Available keys:");
        System.out.println(String.join("\n", availableKeys));
        System.out.println("Pattern prefix: " + prefix);
        System.out.println("Enter the property name pattern (can be empty):");
        Scanner scanner = new Scanner(System.in);
        String propertyName = scanner.nextLine();

        Set<String> result = availableKeys.stream()
                .map(key -> key.replace(prefix + "/", ""))
                .filter(key -> startsWithPattern(key, propertyName))
                .map(key -> key.split("/")[0])
                .collect(Collectors.toSet());

        System.out.println("Mapping items starting with name(s): \n" + result);
    }

    private static boolean startsWithPattern(String key, String keyPattern) {
        if (StringUtils.isBlank(keyPattern))
            return true;

        Pattern pattern = Pattern.compile(keyPattern);
        Matcher matcher = pattern.matcher(key);
        return matcher.lookingAt();
    }

}
