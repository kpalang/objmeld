package org.jmeld.ui;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jmeld.ui.text.BufferDocumentIF;

/**
 * @author Kiran Ayyagari (kayyagari@apache.org)
 */
public interface ScrollableIF {
    public JScrollPane getScrollPane();
    public JTextArea getEditor();
    public BufferDocumentIF getBufferDocument();
}
