package com.software.aws_spring_boot_native_dsql.model;

import java.util.UUID;

public class Book {

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private UUID id;
    private String title;

}
