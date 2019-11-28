package ru.ifmo.itcenter;

import java.util.List;

/**
 * Created by Roman Petrov
 */
public class StringUtils {

    /**
     *
     *
     * @param strings лист строк
     * @return самая длинная строка из списка переданных строк. Возвращает null, если лист был пустой или равен null
     */
    public static String getLongestString(List<String> strings) {
        if(strings.isEmpty())
            return null;

        String longest="";
        for (String string : strings) {
            if (string.length() > longest.length()) {
                longest = string;
            }
        }
        return longest;

    } //COMPLETED


    /**
     *
     * Метод склеивает переданные строки, а затем из результата делает "обратную", то есть перевернутую слева направою строку
     * @param strings
     */
    public static String concatAndReverse(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<strings.length;i++) {
            stringBuilder.append(strings[i]);
        }

        return stringBuilder.reverse().toString();
    } //COMPLETED

}
