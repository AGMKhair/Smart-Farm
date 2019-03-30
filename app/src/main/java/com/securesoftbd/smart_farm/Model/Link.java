package com.securesoftbd.smart_farm.Model;

public class Link {
    private String id;
    private String name;
    private String link;

    public Link(String id, String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public Link(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
