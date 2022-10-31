package org.example.travelagency.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static final RandomDataGenerator generator = new RandomDataGenerator();
    private static final String[] roles = new String[]{"DRIVER", "LIFEGUARD", "GUIDE", "GUARDIAN", "TRANSLATOR", "ANIMATOR", "RESIDENT", "MANAGER"};
    private static final String[] languages = new String[]{"POLISH", "ENGLISH", "FRENCH", "SPANISH", "GERMAN", "RUSSIAN", "CHINESE", "ITALIAN", "GREEK", "PORTUGUESE"};
    private static final String[] levels = new String[]{"A1", "A2", "B1", "B2", "C1", "C2"};
    private static final String[] transportTypes = new String[]{"PLANE", "BUS", "SHIP", "BIKE", "ON FOOT", "ROCKET", "TRAIN", "SKATEBOARD", "SUBMARINE"};

    public static String randomString(int min, int max) {
        return RandomStringUtils.randomAlphabetic(generator.nextInt(min, max));
    }

    public static String randomEmail() {
        return randomString(5, 20) + "@gmail.com";
    }

    public static String randomTel() {
        return "+" + randomInt(10, 99) + " " + randomInt(100, 999) + " " + randomInt(100, 999) + " " + randomInt(100, 999);
    }

    public static String randomLang() {
        return languages[randomInt(0, languages.length-1)];
    }

    public static String randomLevel() {
        return levels[randomInt(0, levels.length-1)];
    }

    public static String randomTransportType() {
        return transportTypes[randomInt(0, transportTypes.length-1)];
    }

    public static String randomRole() {
        return roles[randomInt(0, roles.length-1)];
    }

    public static Integer randomInt(int min, int max) {
        return generator.nextInt(min, max);
    }

    public static Short randomShort(int min, int max) {
        return (short) generator.nextInt(min, max);
    }

    public static Float randomFloat(int min, int max) {
        var f = generator.getRandomGenerator().nextFloat();
        return min + f * (max - min);
    }

    public static Date randomDate(Instant min, Instant max) {
        long minMillis = Date.from(min).getTime();
        long maxMillis = Date.from(max).getTime();
        long randomMillis = ThreadLocalRandom.current().nextLong(minMillis, maxMillis);
        return new Date(randomMillis);
    }
}
