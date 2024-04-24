package org.transposition;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.transposition.Transpose.*;

public class TransposeTest {

    @Test
    public void testConvertKeyToNumber() {
        assertEquals(convertKeyToNumber(new Key(-3, 10)), 1);
        assertEquals(convertKeyToNumber(new Key(-3, 11)), 2);
        assertEquals(convertKeyToNumber(new Key(-3, 12)), 3);

        assertEquals(convertKeyToNumber(new Key(5, 1)), 88);

        assertEquals(convertKeyToNumber(new Key(-2, 1)), 4);
        assertEquals(convertKeyToNumber(new Key(-1, 1)), 16);
        assertEquals(convertKeyToNumber(new Key(-1, 2)), 17);
        assertEquals(convertKeyToNumber(new Key(-2, 2)), 5);

        assertEquals(convertKeyToNumber(new Key(2, 11)), 62);
    }

    @Test
    public void testConvertNumberToKey() {
        Key key1 = convertNumberToKey(88);
        assertEquals(key1.getOctave(), 5);
        assertEquals(key1.getNote(), 1);

        Key key2 = convertNumberToKey(1);
        assertEquals(key2.getOctave(), -3);
        assertEquals(key2.getNote(), 10);

        Key key3 = convertNumberToKey(2);
        assertEquals(key3.getOctave(), -3);
        assertEquals(key3.getNote(), 11);

        Key key4 = convertNumberToKey(16);
        assertEquals(key4.getOctave(), -1);
        assertEquals(key4.getNote(), 1);

        Key key5 = convertNumberToKey(74);
        assertEquals(key5.getOctave(), 3);
        assertEquals(key5.getNote(), 11);
    }

    @Test
    public void testTranspose() {
        ArrayList<Key> inputKeyboard = new ArrayList<>();
        ArrayList<Key> outputKeyboard = new ArrayList<>();

        inputKeyboard.add(new Key(2, 11));

        transpose(inputKeyboard, -3, outputKeyboard);

        assertFalse(outputKeyboard.isEmpty());
        assertEquals(outputKeyboard.get(0).getOctave(), 2);
        assertEquals(outputKeyboard.get(0).getNote(), 8);
    }
}