package org.jmeld.ui.text;

import javax.swing.text.Element;
import javax.swing.text.GapContent;

import org.jmeld.util.StringUtil;

public class Line implements Comparable {
    private MyGapContent content;
    private Element element;

    public Line(MyGapContent content, Element element) {
        this.content = content;
        this.element = element;
    }

    public GapContent getContent() {
        return this.content;
    }

    public int getOffset() {
        return element.getEndOffset();
    }

    public void print() {
        System.out.printf("[%08d]: %s\n", getOffset(), StringUtil
                .replaceNewLines(toString()));
    }

    @Override
    public boolean equals(Object o) {
        Element element2;
        Line line2;
        int start1;
        int start2;
        int end1;
        int end2;

        if (!(o instanceof Line)) {
            return false;
        }

        line2 = ((Line) o);
        element2 = line2.element;

        start1 = element.getStartOffset();
        end1 = element.getEndOffset();
        start2 = element2.getStartOffset();
        end2 = element2.getEndOffset();

        // If the length is different the element is not equal!
        if ((end1 - start1) != (end2 - start2)) {
            return false;
        }

        return this.content.equals((MyGapContent)line2.getContent(), start1, end1, start2);
    }

    @Override
    public int hashCode() {
        return this.content.hashCode(element.getStartOffset(), element.getEndOffset());
    }

    @Override
    public String toString() {
        try {
            return this.content.getString(element.getStartOffset(),
                    element.getEndOffset() - element.getStartOffset());
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public int compareTo(Object line) {
        return toString().compareTo(((Line) line).toString());
    }
}