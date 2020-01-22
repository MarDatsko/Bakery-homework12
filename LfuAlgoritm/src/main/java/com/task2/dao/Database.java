package main.java.com.task2.dao;

import main.java.com.task2.model.News;

import java.util.*;

public class Database {
    private Map<Integer, News> allNews;

    public Database() {
        allNews = new LinkedHashMap<>();
        News newsFirst = new News(1, "1. First news");
        News newsSecond = new News(2, "2. Second news");
        News newsThird = new News(3, "3. Third news");
        News newsFourth = new News(4, "4. Fourth news");
        News newsFifth = new News(5, "5. Fifth news");
        News newsSixth = new News(6, "6. Sixth news");
        News newsSeventh = new News(7, "7. Seventh news");
        News newsEighth = new News(8, "8. Eighth news");
        News newsNinth = new News(9, "9. Ninth news");

        allNews.put(newsFirst.getId(), newsFirst);
        allNews.put(newsSecond.getId(), newsSecond);
        allNews.put(newsThird.getId(), newsThird);
        allNews.put(newsFourth.getId(), newsFourth);
        allNews.put(newsFifth.getId(), newsFifth);
        allNews.put(newsSixth.getId(), newsSixth);
        allNews.put(newsSeventh.getId(), newsSeventh);
        allNews.put(newsEighth.getId(), newsEighth);
        allNews.put(newsNinth.getId(), newsNinth);
    }

    public ArrayList<News> getNewsList() {
        return new ArrayList<>(allNews.values());
    }

    public LinkedHashMap<Integer, News> getNewsMap() {
        return new LinkedHashMap<>(allNews);
    }
}
