package com.test.guo;

/**
 * Created by xiaojie.Ma on 2018/12/28.
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        User user = new User();
        if(user.getName() == null) {
            System.out.println("name is null");
        }
    }
}
