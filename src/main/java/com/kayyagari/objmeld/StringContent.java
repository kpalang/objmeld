package com.kayyagari.objmeld;

import java.util.Map;
import java.util.TreeMap;

public class StringContent implements OgnlContent {
    private String name;
    private String data;

    private Map<String, OgnlContent> children = new TreeMap<>();

    public StringContent(String name, String data) {
        this.name = name;
        this.data = data;
        if(this.data == null) {
            this.data = "";
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPath() {
        return name;
    }

    @Override
    public String toText() {
        return data;
    }

    public void addChild(OgnlContent child) {
        children.put(child.getName(), child);
    }

    @Override
    public Map<String, OgnlContent> children() {
        return children;
    }

    @Override
    public OgnlContent emptyPeer() {
        StringContent sc = new StringContent(name, null);
        return sc;
    }
}
