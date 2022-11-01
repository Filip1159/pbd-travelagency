package org.example.travelagency;

import org.example.travelagency.model.*;
import org.example.travelagency.util.RandomUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.travelagency.util.RandomUtils.randomShort;

public class RandomGenerator {
    private final MySQLConnection mySql;

    private final Map<Class<?>, Integer> itemsPerTable = new HashMap<>();

    public RandomGenerator(MySQLConnection mysql) {
        this.mySql = mysql;
        itemsPerTable.put(Attraction.class, 0);
        itemsPerTable.put(Booking.class, 0);
        itemsPerTable.put(Customer.class, 0);
        itemsPerTable.put(Delegation.class, 0);
        itemsPerTable.put(Employee.class, 0);
        itemsPerTable.put(Enrollment.class, 0);
        itemsPerTable.put(Institution.class, 0);
        itemsPerTable.put(KnowledgeOfLanguages.class, 0);
        itemsPerTable.put(Language.class, 0);
        itemsPerTable.put(Participant.class, 0);
        itemsPerTable.put(Payment.class, 0);
        itemsPerTable.put(Photo.class, 0);
        itemsPerTable.put(Program.class, 0);
        itemsPerTable.put(Review.class, 0);
        itemsPerTable.put(Tour.class, 0);
    }

    private ArrayList<Long> prepareForeignKeysFor(Class<?> clazz) {
        var dependencies = clazz.getDeclaredAnnotation(DependsOn.class);
        var keys = new ArrayList<Long>();
        if (dependencies != null) {
            for (var d : dependencies.value()) {
                var upperBound = itemsPerTable.get(d);
                var randomKey = (long) RandomUtils.randomInt(1, upperBound);
                keys.add(randomKey);
            }
        }
        return keys;
    }

    private void removeRandomOptionalForeignKeys(Annotation[][] annotations, List<Long> keys) {
        for (int i = 0; i < annotations.length; i++) {
            var annotationsForArgument = annotations[i];
            for (var annotation : annotationsForArgument)
                if (annotation instanceof Optional) {
                    var shouldRemove = randomShort(0, 1);
                    if (shouldRemove == 0) keys.set(i, null);
                }
        }
    }

    private Method findRandomGeneratorMethod(Class<?> clazz, int keysSize) throws NoSuchMethodException {
        var argTypes = switch (keysSize) {
            case 0 -> null;
            case 1 -> new Class<?>[]{Long.class};
            case 2 -> new Class<?>[]{Long.class, Long.class};
            case 3 -> new Class<?>[]{Long.class, Long.class, Long.class};
            default -> throw new IllegalArgumentException("Ło panie ile tego");
        };
        return clazz.getMethod("random", argTypes);
    }

    public void insertRandom(Class<?> clazz, int rows) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("start random");
        var insertBatch = new Object[rows];
        for (int r = 0; r < rows; r++) {
            var keys = prepareForeignKeysFor(clazz);
            var method = findRandomGeneratorMethod(clazz, keys.size());
            removeRandomOptionalForeignKeys(method.getParameterAnnotations(), keys);
            var randomInstance = method.invoke(null, keys.toArray());
            insertBatch[r] = randomInstance;
        }
        mySql.insert(insertBatch);
        increment(clazz, rows);
        System.out.println("end random");
    }

    private void increment(Class<?> clazz, int by) {
        itemsPerTable.put(clazz, itemsPerTable.get(clazz) + by);
    }
}
