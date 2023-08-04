package com.demoproj.enums;

public enum FileSeparator {
    WINDOWS("\\"),
    LINUX("/");

    private String value;

    FileSeparator(String value) {

        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
