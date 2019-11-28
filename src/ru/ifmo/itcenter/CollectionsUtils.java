package ru.ifmo.itcenter;

import java.util.*;

/**
 * Created by Roman Petrov
 */
public class CollectionsUtils {


    /**
     * метод получает на вход массив элементов типа К.
     * Вернут надо объект Map<K, Integer>, где K - Значение из массива, а Integer количество вхождений в массив
     *
     * @param ks
     * @param <K>
     * @return
     */
    public static <K> Map<K, Integer> arrayToMap(K[] ks) {

        Map<K, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < ks.length; i++) {
            int count = 0;
            for (int j = 0; j < ks.length; j++) {
                if (ks[i] == ks[j])
                    count++;
            }
            resultMap.put(ks[i], count);
        }
        return resultMap;
    } //COMPLETED


    /**
     * метод должен возвращать среднее арифметическое элементов коллекции.
     *
     * @param collection коллекция
     * @return метод должен возвращать среднее арифметическое элементов коллекции.
     */
    public static double getAverage(Collection<? extends Number> collection) {
        return collection.stream().mapToDouble(value -> ((Number) value).doubleValue()).average().getAsDouble();
    }

    /**
     * Метод получает на вход массив Map<K, V>
     * Вернут надо объект Map<V, List<K>>.
     * То есть поменять ключи и значения в HashMap.
     * Так как значения могут совпадать, то в итоговой Map они уже пакуются в List
     */
    public static <K, V> Map<V, List<K>> mapToMap(Map<K, V> map) {
        return null;
    }


    /**
     * Возвращает Итератор по массиву.
     * Remove поддерживать необязательно.
     */
    public
    static <T> Iterator<T> getIteratorForArray(T[] ts) {

        return new Iterator() {
            int count = ts.length;
            int index = 0;

            @Override
            public boolean hasNext() {
                if (count > index)
                    return true;
                return false;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    index++;
                    return ts[index-1];
                }
                return null;
            }
        };
    }//COMPLETED


    /**
     * Возвращает Comparator для сравнения чисел по количеству множителей factor
     * Пример: если factor = 2, то 4 < 6, но 4 > 5, потому что у 4 два множителя (=2), у 6 три, а у 5 - 0.
     *
     * @return Comparator
     */
    public static Comparator<Integer> getComparatorForSortByFactor(int factor) {
        return null;
    }
}
