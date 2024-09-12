package org.example.util;

import java.util.List;
import java.util.Random;

public class RandomElementSelector {

    public static <T> T getRandomElement(List<T> list) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

}
