package ru.ifmo.itcenter;

import junit.framework.TestCase;
import ru.ifmo.itcenter.news.News;
import ru.ifmo.itcenter.news.PublisherMachine;

import java.util.*;

public class PublisherMachineTest extends TestCase {
    private List<News> news;
    private PublisherMachine publisherMachine;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        news = List.of(
                new News("News about Java language", List.of("Java", "IT"), User.newUser(0, "Линус Торвальдс")),
                new News("One more news about Java language", List.of("Java", "IT"), User.newUser(0, "Линус Торвальдс")),
                new News("News about Java island", List.of("Java", "island"), User.newUser(1, "Огюсте́н Луи́ Коши́")),
                new News("Some other news", List.of("other", "island", "tag", "nobody read this tag"), User.newUser(2, "Блез Паскаль")),
                new News("News about linux", List.of("linux"), User.newUser(0, "Линус Торвальдс"))
        );

        publisherMachine = new PublisherMachine(news);
    }

    public void testFindByOwner() {
        Collection<News> news = publisherMachine.findByOwner(User.newUser(0, "Линус Торвальдс"));
        assertEquals(3, news.size());
        assertTrue(news.contains(this.news.get(0)));
        assertTrue(news.contains(this.news.get(1)));
        assertFalse(news.contains(this.news.get(2)));
        assertFalse(news.contains(this.news.get(3)));
        assertTrue(news.contains(this.news.get(4)));
    }

    public void testFindByOwnerIfOwnerDoesNotHaveNews() {
        // это другой Линус Торвальдс
        Collection<News> news = publisherMachine.findByOwner(User.newUser(5, "Линус Торвальдс"));
        assertNotNull(news);
        assertTrue(news.isEmpty());
    }

    public void testGetAllTags(){
        List<String> tags = new ArrayList<>(List.of("Java", "IT", "island", "other", "tag", "nobody read this tag", "linux"));
        List<String> tagsFromMachine = new ArrayList<>(publisherMachine.getAllTags());
        Collections.sort(tags);
        Collections.sort(tagsFromMachine);
        assertEquals(tags, tagsFromMachine);
    }

    public void testGetByTags(){
        Collection<News> news = publisherMachine.getByTags(List.of("Java", "IT"));
        assertEquals(2, news.size());
        assertTrue(news.contains(this.news.get(0)));
        assertTrue(news.contains(this.news.get(1)));
        assertFalse(news.contains(this.news.get(2)));
        assertFalse(news.contains(this.news.get(3)));
        assertFalse(news.contains(this.news.get(4)));

        news = publisherMachine.getByTags(List.of("Java"));
        assertEquals(3, news.size());
        assertTrue(news.contains(this.news.get(0)));
        assertTrue(news.contains(this.news.get(1)));
        assertTrue(news.contains(this.news.get(2)));
        assertFalse(news.contains(this.news.get(3)));
        assertFalse(news.contains(this.news.get(4)));

        news = publisherMachine.getByTags(List.of("TEST!!!"));
        assertTrue(news.isEmpty());
    }

    public void testGetRelated(){
        List<News> news = publisherMachine.getRelated(this.news.get(1));
        assertEquals(3, news.size());
        assertEquals(this.news.get(0), news.get(0));
        assertEquals(this.news.get(2), news.get(1));
        assertEquals(this.news.get(4), news.get(2));
    }
}
