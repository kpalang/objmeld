package com.kayyagari.objmeld;

import org.jmeld.util.node.BufferNode;
import org.jmeld.util.node.JMeldNode;

/**
 * @author Kiran Ayyagari (kayyagari@apache.org)
 */
public class OgnlNode extends JMeldNode implements BufferNode {

    private OgnlContent data;
    private OgnlDocument document;
    private boolean exists;

    public OgnlNode(String name, OgnlContent data) {
        super(name, true);
        this.data = data;

        initialize();
    }

    @Override
    public void resetContent() {
        document = null;
        initialize();
    }

    public boolean exists() {
        return exists;
    }

    public OgnlDocument getDocument() {
        if (document == null || isDocumentOutOfDate()) {
            initialize();
            if (exists()) {
                document = new OgnlDocument(data);
            }
        }

        return document;
    }

    @Override
    public long getSize() {
        return data.toText().length();
    }

    private boolean isDocumentOutOfDate() {
        return false;
    }

    private void initialize() {
        exists = true;
    }

    public boolean isReadonly() {
        return false;
    }
}
