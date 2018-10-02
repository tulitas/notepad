package com.company;

public class Note extends Record{

    private String text;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean hasSubstring(String str) {
        return text.contains(str);
    }
}
