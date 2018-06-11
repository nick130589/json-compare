package ro.engineering.comparator;

import org.junit.Test;

public class JSONObjectCompareTests {

    @Test
    public void compareSimple() {
        String expected = "{\"b\":\"val1\",\"a\":\"val2\"}";
        String actual = "{\"a\":\"val2\",\"b\":\"val1\"}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void compareByFieldNotFound() {
        String expected = "{\"!b\":\"val1\",\"a\":\"val2\"}";
        String actual = "{\"a\":\"val2\",\"c\":\"val1\"}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void compareByFieldNotFound_Negative() {
        String expected = "{\"!b\":\"val1\",\"a\":\"val2\"}";
        String actual = "{\"a\":\"val2\",\"b\":\"val1\"}";
        JSONCompare.assertNotEquals(expected, actual);
    }

    @Test
    public void compareWithNumbers() {
        String expected = "{\"b\":1,\"a\":2}";
        String actual = "{\"a\":2,\"b\":1}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void compareWithExpectedStringRepresentedNumbers() {
        String expected = "{\"b\":1,\"a\":\"2\"}";
        String actual = "{\"a\":2,\"b\":1}";
        JSONCompare.assertEquals(expected, actual);
    }

    @Test
    public void compareWithActualStringRepresentedNumbers_negative() {
        String expected = "{\"b\":1,\"a\":2}";
        String actual = "{\"a\":\"2\",\"b\":1}";
        JSONCompare.assertNotEquals(expected, actual);
    }


}