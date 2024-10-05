package com.festivals.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "artists")
public class Artist {
    @Id
    private String id;
    private String name;
    private String music;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}