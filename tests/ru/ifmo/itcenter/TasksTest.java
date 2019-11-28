package ru.ifmo.itcenter;

import com.google.common.testing.EqualsTester;
import junit.framework.Assert;
import junit.framework.TestCase;
import ru.ifmo.itcenter.CollectionsUtils;
import ru.ifmo.itcenter.StringUtils;
import ru.ifmo.itcenter.geometry.Point;
import ru.ifmo.itcenter.geometry.Square;

import java.util.*;

/**
 * Created by Roman Petrov
 */
public class TasksTest extends TestCase {


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }


    public void testAverageForCollection() {
        List<Double> list = new ArrayList<Double>();
        list.add(1d);
        list.add(2d);
        list.add(18d);
        assertEquals(7d, CollectionsUtils.getAverage(list));
    }


    public void testSetLongestString() {
        List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("Првиет");
        strings.add("А это и есть та строка");
        assertEquals("А это и есть та строка", StringUtils.getLongestString(strings));
        assertEquals(null, StringUtils.getLongestString(Collections.<String>emptyList()));
    }


    public void testConcatAndReverse() {
        assertEquals("321", StringUtils.concatAndReverse("1", "2", "3"));
        assertEquals("1", StringUtils.concatAndReverse("1"));
        assertEquals("654321", StringUtils.concatAndReverse("1", "2", "3", "4", "5", "6"));
    }

    public void testSquare() {

        Assert.assertNotNull(Square.getSquare(new Point(0,0), 0));

        Square square = Square.getSquare(new Point(0, 0), 10);
        assertEquals(100d, square.getArea());
        assertEquals(10d, square.getWidth());
        assertFalse(square.isDegenerate());
        assertFalse(square.isInSquare(new Point(20, 20)));
        assertTrue(square.isInSquare(new Point(5, 5)));

        assertTrue(Square.getSquare(new Point(0, 0), 0).isDegenerate());

    }


    public void testSquareEquals() {
        Square square1 = Square.getSquare(new Point(0, 0), 10);
        Square square2 = Square.getSquare(new Point(0, 0), 10);
        new EqualsTester().addEqualityGroup(square1, square2).testEquals();

        square1 = Square.getSquare(new Point(1, 4), 10);
        square2 = Square.getSquare(new Point(1, 4), 10);
        new EqualsTester().addEqualityGroup(square1, square2).testEquals();
    }

    public void testArrayToMap() {
        String[] strings = new String[]{"1", "2", "2"};
        Map<String, Integer> hashMap = CollectionsUtils.arrayToMap(strings);
        assertTrue(hashMap.size() == 2);
        assertEquals(Integer.valueOf(1), hashMap.get("1"));
        assertEquals(Integer.valueOf(2), hashMap.get("2"));
        assertEquals(null, hashMap.get("ddd2"));
    }

    public void testMapTpMap() {
        String[] strings = new String[]{"1", "2", "2", "3", "3"};
        Map<String, Integer> hashMap = CollectionsUtils.arrayToMap(strings);
        Map<Integer, List<String>> hashMapReversed = CollectionsUtils.mapToMap(hashMap);

        assertTrue(hashMapReversed.size() == 2);
        assertTrue(hashMapReversed.get(2).size() == 2);
        assertTrue(hashMapReversed.get(2).get(0).equals("2") || hashMapReversed.get(2).get(0).equals("3"));
        assertTrue(hashMapReversed.get(1).get(0).equals("1"));


    }

    public void testGetIteratorForArray() {
        String[] strings = new String[]{"1", "2", "2", "3", "3"};
        Iterator<String> stringIterator = CollectionsUtils.getIteratorForArray(strings);

        if (stringIterator.getClass().getPackage().getName().contains("java.util"))
            fail();

        for (String str : strings) {
            if (!stringIterator.hasNext())
                fail();

            String fromIterator = stringIterator.next();
            assertEquals(fromIterator, str);
        }
    }

    public void testFactor() {
        Comparator<Integer> comparator = CollectionsUtils.getComparatorForSortByFactor(10);
        assertTrue(comparator.compare(1, 10) < 0);
        assertTrue(comparator.compare(10, 100) < 0);
        assertTrue(comparator.compare(100, 10000) < 0);
        assertEquals(0, comparator.compare(100, 100));
        assertEquals(0, comparator.compare(1, 1));
        assertTrue(comparator.compare(1000, 100) > 0);

        comparator = CollectionsUtils.getComparatorForSortByFactor(2);
        assertTrue(comparator.compare(1, 2) < 0);
        assertTrue(comparator.compare(2, 4) < 0);
        assertTrue(comparator.compare(2, 2024) < 0);
        assertEquals(0, comparator.compare(1, 1));
        assertEquals(0, comparator.compare(256, 256));
        assertTrue(comparator.compare(1024, 512) > 0);
    }
}
