package com.kayyagari.objmeld;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.jmeld.JMeldException;
import org.jmeld.ui.text.AbstractBufferDocument;

/**
 * @author Kiran Ayyagari (kayyagari@apache.org)
 */
public class OgnlDocument extends AbstractBufferDocument {
    // instance variables:
    private OgnlContent data;

    public OgnlDocument(OgnlContent data)
    {
      this.data = data;

      setName(data.getName());

      setShortName(data.getName());
    }

    protected int getBufferSize() {
        return data.toText().length();
    }

    public Reader getReader() throws JMeldException {
        return new StringReader(data.toText());
    }

    protected Writer getWriter() throws JMeldException {
        return new StringWriter();
    }
}
