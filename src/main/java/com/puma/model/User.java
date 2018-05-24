package com.puma.model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class User {
    private String name;
    private int id;
    public static List<User> userList;

    static {
        userRepository();
    }

    public User(int id, String name){
        this(name);
        this.id = id;
    }

    public User(String name){
        this.name = name;
    }

    public User(){

    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void userRepository(){
        userList = new ArrayList<>(asList(new User(1, "Joao"), new User(2, "Maria")));
    }

    public static void setUserList(List<User> userList) {
        User.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
