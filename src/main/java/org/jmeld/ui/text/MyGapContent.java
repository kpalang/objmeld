package org.jmeld.ui.text;

import javax.swing.text.GapContent;

public class MyGapContent extends GapContent {
    public MyGapContent(int length) {
        super(length);
    }

    public char[] getCharArray() {
        return (char[]) getArray();
    }

    public char getChar(int offset) {
        int g0;
        int g1;

        g0 = getGapStart();
        g1 = getGapEnd();

        if (offset >= g0) {
            // Take into account the gap!
            // This offset is above the gap.
            offset = g1 + offset - g0;
        }

        return getCharArray()[offset];
    }

    public boolean equals(MyGapContent c2, int start1, int end1, int start2) {
        char[] array1;
        char[] array2;
        int g1_0;
        int g1_1;
        int g2_0;
        int g2_1;
        int size;
        int o1;
        int o2;

        array1 = getCharArray();
        array2 = c2.getCharArray();

        g1_0 = getGapStart();
        g1_1 = getGapEnd();
        g2_0 = c2.getGapStart();
        g2_1 = c2.getGapEnd();

        if (start1 >= g1_0) {
            o1 = start1 + g1_1 - g1_0;
        } else {
            o1 = start1;
        }

        if (start2 >= g2_0) {
            o2 = start2 + g2_1 - g2_0;
        } else {
            o2 = start2;
        }

        size = end1 - start1;
        for (int i = 0; i < size; i++, o1++, o2++) {
            if (o1 == g1_0) {
                o1 += g1_1 - g1_0;
            }

            if (o2 == g2_0) {
                o2 += g2_1 - g2_0;
            }

            if (array1[o1] != array2[o2]) {
                return false;
            }
        }

        return true;
    }

    public int hashCode(int start, int end) {
        char[] array;
        int g0;
        int g1;
        int size;
        int h;
        int o;

        h = 0;

        array = getCharArray();

        g0 = getGapStart();
        g1 = getGapEnd();

        // Mind the gap!
        if (start >= g0) {
            o = start + g1 - g0;
        } else {
            o = start;
        }

        size = end - start;
        for (int i = 0; i < size; i++, o++) {
            // Mind the gap!
            if (o == g0) {
                o += g1 - g0;
            }

            h = 31 * h + array[o];
        }

        if (h == 0) {
            h = 1;
        }

        return h;
    }

    public int getDigest(int docLen) {
        return hashCode(0, docLen);
    }
}