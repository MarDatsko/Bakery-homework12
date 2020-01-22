package main.java.com.task2.model;

public class Element {
    private Integer id;
    private Integer frequency;

    @Override
    public String toString() {
        return "  ID- " + id.toString() + "// Frequency- " + frequency.toString() + "//";
    }

    public Element(Integer id, Integer frequency) {
        this.id = id;
        this.frequency = frequency;
    }

    public void incrementFrequency() {
        ++frequency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
