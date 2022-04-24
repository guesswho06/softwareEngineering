package model;

public class Owner {
    String name;
    String surname;


    public Owner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Owner: " + "name=" + name + " surname=" + surname;
    }
}
