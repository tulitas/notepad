package com.company;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {


    static Scanner scanner = new Scanner(System.in);
    static List<Record> recordList = new ArrayList<>();
    static List<Person> person = new ArrayList<>();

    //sozdanije komand dlja metodov
    public static void main(String[] args) {

        while (true) {

            System.out.println("Enter comand:");
            String cmd = scanner.next();

            switch (cmd) {
                case "help":
                    help();
                    break;
                case "create":
                case "cp":
                    create();
                    break;
                case "cn":
                    cn();
                    break;
                case "exit":
                    return;
                case "list":
                    list();
                    break;
                case "find":
                    find();
                    break;
                case "remove":
                    removeById();

                    break;

                default:
                    System.out.println("It isn`t a command");


            }

        }

    }


    private static void help() {
        System.out.println("Creat - create person");
        System.out.println("List - loock list");
        System.out.println("Exit - exit");
        System.out.println("cn - create note");
        System.out.println("Remove - remove ID");
        System.out.println("Find - find note");

    }

    //metod poiska po zapisjam, v note i person sozdani boolean substringi(sgenerirovani)
    private static void find() {
        System.out.println("Find what?");
        String str = askString();
        for (Record r : recordList) {
            if (r.hasSubstring(str)) {
                System.out.println(r);
            }
        }
    }

    private static void cn() {

        System.out.println("Enter note");
        String cn = askString();
        Note r = new Note();
        r.setText(cn);
        recordList.add(r);
        System.out.println(r);
    }


    private static void removeById() {
        System.out.println("Enter ID to remove:");
        int id = scanner.nextInt();
        for (int i = 0; i < recordList.size(); i++) {
            Record p = recordList.get(i);
            if (id == p.getId()) {
                recordList.remove(i);
                System.out.println("ID" + id + "is remoed");
                break;
            }
        }

        loadList();
    }

    //metod pozvoljaet vvesti i vivesti na ekran dannie
    private static void create() {
        System.out.println("Enter name");
        String name = askString();

        System.out.println("Enter surname");
        String surname = askString();

        System.out.println("Enter phone");
        String phone = askString();

        System.out.println("Enter email");
        String email = askString();


        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);
        p.setEmail(email);

        recordList.add(p);
        person.add(p);

        saveList();
        System.out.println(p);
    }


    //metod pozvoljaet vvodit` dvojnie imena i familii obozna4aja ih kavi4kami

    private static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {

            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    //string join soeedinjaet vse slova v stroku 4erez probel
                    String str = String.join(" ", result);
                    //substring pozvoljaet virezat` simvoli , tut kavi4ki
                    return str.substring(1, str.length() - 1);

                }
                word = scanner.next();
            } while (true);

        } else {
            return word;


        }

    }

    //vivodim spisok
    private static void list() {
        for (Record p : recordList) {
            System.out.println(p);

        }

    }

    private static void loadList() {
        File file = new File("person_file.txt");
        try (Scanner in = new Scanner(file)) {
            while (in.hasNext()) {
                Person list = new Person();
                list.setName(in.next());
                list.setSurname(in.next());
                list.setPhone(in.next());
                person.add(list);
            }
        } catch (IOException e) {
            System.out.println("Cannnot load from file");
        }
    }

    private static void saveList() {
        //sozdajom fail sohranenija
        File file = new File("person_file.txt");
        try (PrintWriter out = new PrintWriter(file)) {
            for (Person p : person) {
                out.printf("%d %s %s %s %s\n", p.getId(), p.getName(), p.getSurname(),
                        p.getPhone(), p.getEmail());

            }
        } catch (IOException e) {
            System.out.println("Cannot save file");
        }
    }


}


