package ua.lviv.iot.algo.part1.lab5;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GithubNameFinder {

    public static final Pattern GITHUB_LINK_PATTERN = Pattern.compile("(http(s)?:\\/\\/)?github\\.com\\/(\\w+)(\\S)?");

    public List<String> findGithubUsers(String text) {
        List<String> githubUsers = new LinkedList<>();

        Matcher matcher = GITHUB_LINK_PATTERN.matcher(text);

        while (matcher.find()) {
            githubUsers.add(matcher.group(3));
        }

        return githubUsers;
    }
}
