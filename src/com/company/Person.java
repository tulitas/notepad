package com.company;

public class Person {
    //private ograni4ivaet dostup k peremennim
    //peremennaja dlja personi
    private static int count = 0;
    private int id;
    private String name;
    private String surname;
    private String phone;

    //konstruktor dlja id s4et4ika

    public Person() {
        count ++;
        id = count;
    }

    //get i set pozvoljaet rabotat` s peremennimi
    // pravij klik i generate, tam vibiraem get set
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                " name=" + name + '\'' +
                " surname=" + surname + '\'' +
                " phone=" + phone + '\'' +
                '}';
    }
}
