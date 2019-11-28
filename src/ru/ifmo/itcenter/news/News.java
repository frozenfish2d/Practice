package ru.ifmo.itcenter.news;

import ru.ifmo.itcenter.User;

import java.util.List;


/**
 * Описание новости
 */
public class News {
    /**
     * Заголовок
     */
    private String title;

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    /**
     * Теги
     */
    private List<String> tags;

    public User getAuthor() {
        return author;
    }

    /**
     * Автор
     */
    private User author;

    public News(String title, List<String> tags, User author) {
        this.title = title;
        this.tags = tags;
        this.author = author;
    }

    public News() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (tags != null ? !tags.equals(news.tags) : news.tags != null) return false;
        return author != null ? author.equals(news.author) : news.author == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", tags=" + tags +
                ", author=" + author +
                '}';
    }
}
