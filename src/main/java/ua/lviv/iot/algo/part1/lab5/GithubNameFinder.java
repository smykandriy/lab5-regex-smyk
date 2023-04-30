package ua.lviv.iot.algo.part1.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GithubNameFinder {

    public List<String> findGithubUsers(String text) {
        List<String> users = new ArrayList<>();

        Pattern pattern = Pattern.compile("(https://)?github\\.com/([^/]+)/");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            users.add(matcher.group(2));
        }

        return users;
    }
}
