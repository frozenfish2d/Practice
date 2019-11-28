package ru.ifmo.itcenter.news;

import ru.ifmo.itcenter.User;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Вспомогательный класс для работы с новостями
 *
 * @see News
 */

public class PublisherMachine {
    private Collection<News> news;

    /**
     * Конструктор
     *
     * @param news - новости
     */
    public PublisherMachine(Collection<News> news) {
        this.news = news;
    }


    /**
     * @param user
     * @return возвращает коллекцию новостей некого автора
     */
    public Collection<News> findByOwner(User user) {
        return news.stream()
                .filter(news1 -> news1.getAuthor().equals(user))
                .collect(Collectors.toList());
    }

    /**
     * @return возвращает все теги, которые только есть
     */
    public Collection<String> getAllTags() {
        Set<String> test = new Set<>();
        for(News n:news){
            n.getTags();
        }

       //return news.stream().

        //return news.stream().filter(news1 -> )
        throw new UnsupportedOperationException();
    }


    /**
     * @return возвращает все новости, которые содержаи ВСЕ теги из списка
     */
    public Collection<News> getByTags(Collection<String> tags) {
        throw new UnsupportedOperationException();
    }

    /**
     * возвращает похожие новости для targetNews
     * список должен формироваться следующим образом и в следующем порядке
     * 1. Новости соедержащие ВСЕ теги из targetNews
     * 2. Новости, соедержащие хотя бы один из тегов targetNews
     * 3. Новости того же автора
     * @return похожие новости
     */
    public List<News> getRelated(News targetNews) {
        throw new UnsupportedOperationException();
    }
}
