package org.example.model;

public class Duration {

    private Long id;
    private String name;

    public Duration() {
    }

    public Duration(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "name='" + name + '\'' +
                '}';
    }

}
