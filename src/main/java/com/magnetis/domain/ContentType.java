package com.magnetis.domain;

public enum ContentType {
    VIDEO("video"),
    IMAGE("image"),
    TEXT("image");

    private String typec;

    ContentType(String typec) {
        this.typec = typec;
    }

}