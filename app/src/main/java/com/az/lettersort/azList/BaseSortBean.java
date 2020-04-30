package com.az.lettersort.azList;

public abstract class BaseSortBean {
    String name;
    String initials;

    public BaseSortBean(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return "BaseSortBean{" +
                "name='" + name + '\'' +
                ", initials='" + initials + '\'' +
                '}';
    }
}
