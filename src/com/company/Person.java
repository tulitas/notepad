package com.company;
//extends nasleduet ID i count iz Record
public class Person extends Record {
    //private ograni4ivaet dostup k peremennim
    //peremennaja dlja personi

    private String name;
    private String surname;
    private String phone;
private  String email;
    //konstruktor dlja id s4et4ika

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    //get i set pozvoljaet rabotat` s peremennimi
    // pravij klik i generate, tam vibiraem get set



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
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean hasSubstring(String str) {
        return name.contains(str) || surname.contains(str) ||
                phone.contains(str) ||
                email.contains(str);

    }
}
