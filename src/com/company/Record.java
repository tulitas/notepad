package com.company;
//abstraktnij klass ne pozvoljaet izmenenij
public abstract class Record {

    private static int count = 0;
    private int id;

    public Record() {
        count ++;
        id = count;
    }

    public abstract boolean hasSubstring(String str);

    public int getId() {
        return id;
    }
}
