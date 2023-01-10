package com.example.newsapp.Models;

import java.io.Serializable;

public class Source implements Serializable {      // changes are 'implements Serializalble for new activity to show news

    String id = "";
    String name = "";

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
}
