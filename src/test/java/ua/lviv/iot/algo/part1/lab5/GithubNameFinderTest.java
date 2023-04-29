package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.lab5.readers.Reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GithubNameFinderTest {
    private String githubInfo;
    private GithubNameFinder nameFinder = new GithubNameFinder();
    private List<String> users;

    public void generateUsersList(String text) {
        InputStream in = new ByteArrayInputStream(text.getBytes());
        System.setIn(in);

        githubInfo = Reader.readFromConsole();

        users = nameFinder.findGithubUsers(githubInfo);
    }

    @Test
    void testFindGithubUsersIsAbsent() {
        String text = "text to test input from console";
        generateUsersList(text);
        assertEquals(0, users.size());
    }

    @Test
    void testFindGithubUsersAtTheStart() {
        String text = "https://github.com/OleksiuDatsko/wombat/pull/1/ "
                + "approve this pull request";
        generateUsersList(text);
        assertEquals(1, users.size());
    }

    @Test
    void testFindGithubUsersInTheMiddle() {
        String text = "approve this pull request "
                + "Link: https://github.com/OleksiuDatsko/wombat/pull/1/ "
                + "thanks for your attention";
        generateUsersList(text);
        assertEquals(1, users.size());
    }

    @Test
    void testFindGithubUsersInTheEnd() {
        String text = "can you approve this pull request?"
                + "thanks for your attention "
                + "Link: https://github.com/OleksiuDatsko/wombat/pull/1/ ";
        generateUsersList(text);
        assertEquals(1, users.size());
    }

    @Test
    void testFindMultipleGithubUsers() {
        String text = "https://github.com/smykandriy/wombase/pull/12/ "
                + "https://github.com/MarkoYaminsky/recipe-app/pull/6/ "
                + "https://github.com/OleksiuDatsko/java-labs-2023/pull/4/ "
                + "https://github.com/Sashko-Sobran/smart-sashko/pull/1/ "
                + "thanks for your attention";
        generateUsersList(text);
        assertEquals(4, users.size());
    }
}