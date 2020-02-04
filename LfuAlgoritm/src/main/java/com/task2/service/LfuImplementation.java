package main.java.com.task2.service;

import main.java.com.task2.dao.Database;
import main.java.com.task2.model.Element;
import main.java.com.task2.model.Menu;
import main.java.com.task2.model.News;

import java.util.*;

public class LfuImplementation {
    private Database database = new Database();
    private final LinkedHashMap<Integer, Element> cache = new LinkedHashMap<>();
    private LinkedList<Integer> frequencyList = new LinkedList<>();

    public void runLFU() {
        frequencyList.addAll(Menu.listOfSelectedNews);
        int sizeFrequencyList = frequencyList.size();
        for (int i = 0; i < sizeFrequencyList; i++) {
            if (cache.containsKey(frequencyList.peekFirst())) {
                incrementFrequencyElementIntoCache();
            } else if (cache.size() < 3) {
                addElementIntoCache();
            } else {
                Integer min = findMinFrequency();
                Integer key = findKeyElementWithMinFrequency(min);
                cache.remove(key);
                addElementIntoCache();
            }
            frequencyList.removeFirst();
        }
    }

    private void addElementIntoCache() {
        Element elem = new Element(frequencyList.peekFirst(), 1);
        cache.put(frequencyList.peekFirst(), elem);
    }

    private void incrementFrequencyElementIntoCache() {
        cache.get(frequencyList.peekFirst()).incrementFrequency();
    }

    private Integer findMinFrequency() {
        LinkedList<Element> values = new LinkedList<>(cache.values());
        Optional<Integer> minOptional = values.stream()
                .map(Element::getFrequency)
                .min(Integer::compareTo);
        return minOptional.get();
    }

    private Integer findKeyElementWithMinFrequency(Integer min) {
        Optional<Integer> keyMinElement = cache.entrySet().stream()
                .filter(value -> value.getValue().getFrequency() == min)
                .findFirst()
                .map(Map.Entry::getKey);
        return keyMinElement.get();
    }

    public void printCacheAfterLFU() {
        LinkedHashMap<Integer, News> newsMap = database.getNewsMap();
        System.out.println("\nProgram cache ");
        for (Map.Entry<Integer, Element> entry : cache.entrySet()) {
            System.out.println(newsMap.get(entry.getKey()) + " --- Freq :5" +
                    " " + entry.getValue().getFrequency());
        }
    }
}
