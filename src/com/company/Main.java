package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);
    static List<Person> personList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter comand:");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
                    create();
                    break;
                case "exit":
                    return;
                case "list":
                    list();
                    break;
                case "delete":
                    delete();
                default:
                    System.out.println("It isn`t a command");

            }

        }

    }
//metod pozvoljaet vvesti i vivesti na ekran dannie
    private static void create() {
        System.out.println("Enter name");
        String name = scanner.next();

        System.out.println("Enter surname");
        String surname = scanner.next();

        System.out.println("Enter phone");
        String phone = scanner.next();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);

        personList.add(p);

        System.out.println(p);

    }
//vivodim spisok
    private static void list() {
        for (Person p: personList){
            System.out.println(p);

        }

    }
    private static void delete(){
        System.out.println("ID number to delete");
        int cc = personList.size();
        int idnum = scanner.nextInt();
        for (int i = 1; i < cc; i++) {
            if(idnum==i);
            personList.remove(idnum);

        }
    }
}
