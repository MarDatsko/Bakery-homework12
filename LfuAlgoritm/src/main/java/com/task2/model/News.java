package main.java.com.task2.model;

public class News {
    private Integer id;
    private String news;

    @Override
    public String toString() {
        return news;
    }

    public News(Integer id, String news) {
        this.id = id;
        this.news = news;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
