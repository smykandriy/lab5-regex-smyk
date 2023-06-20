package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GithubNameFinderTest {
    private final GithubNameFinder nameFinder = new GithubNameFinder();
    private List<String> githubLinks;

    @Test
    void testFindGithubUsersIsAbsent() {
        String text = "text to test input from console";
        githubLinks = nameFinder.findGithubUsers(text);
        assertEquals(0, githubLinks.size());
    }

    @Test
    void testFindGithubCom() {
        String text = "https://github.com/";
        githubLinks = nameFinder.findGithubUsers(text);
        assertEquals(0, githubLinks.size());
    }

    @Test
    void testNonGithubLink() {
        String text = "https://dsjbjdsbjdgithub.com/";
        githubLinks = nameFinder.findGithubUsers(text);
        assertEquals(0, githubLinks.size());
    }


    @Test
    void testFindGithubUsersAtTheStart() {



        String text = "https://github.com/OleksiuDatsko/wombat/pull/1/ "
                + "approve this pull request";
        githubLinks = nameFinder.findGithubUsers(text);

        List<String> actualUsers = new LinkedList<>();
        actualUsers.add("OleksiuDatsko");
        assertEquals(1, githubLinks.size());
        assertEquals(actualUsers, githubLinks);
    }

    @Test
    void testFindGithubUsersInTheMiddle() {
        String text = "approve this pull request "
                + "Link: https://github.com/OleksiuDatsko/wombat/pull/1/ "
                + "thanks for your attention";
        githubLinks = nameFinder.findGithubUsers(text);
        List<String> actualUsers = new LinkedList<>();
        actualUsers.add("OleksiuDatsko");
        assertEquals(1, githubLinks.size());
        assertEquals(actualUsers, githubLinks);
    }

    @Test
    void testFindGithubUsersInTheEnd() {
        String text = "can you approve this pull request?"
                + "thanks for your attention "
                + "Link: https://github.com/OleksiuDatsko/wombat/pull/1/ ";
        githubLinks = nameFinder.findGithubUsers(text);
        List<String> actualUsers = new LinkedList<>();
        actualUsers.add("OleksiuDatsko");
        assertEquals(1, githubLinks.size());
        assertEquals(actualUsers, githubLinks);
    }

    @Test
    void testFindMultipleGithubUsers() {

        String text = "https://github.com/smykandriy/wombase/pull/12/ "
                + "https://github.com/MarkoYaminsky/recipe-app/pull/6/ "
                + "https://github.com/OleksiuDatsko/java-labs-2023/pull/4/ "
                + "https://github1.com/user1/wombase/pull/12/" + "thanks for your attention";
        githubLinks = nameFinder.findGithubUsers(text);

        List<String> actualUsers = new LinkedList<>();
        actualUsers.add("smykandriy");
        actualUsers.add("MarkoYaminsky");
        actualUsers.add("OleksiuDatsko");

        assertEquals(3, githubLinks.size());
        assertEquals(actualUsers, githubLinks);
    }


}