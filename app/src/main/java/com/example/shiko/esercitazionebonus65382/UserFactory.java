package com.example.shiko.esercitazionebonus65382;

import java.util.ArrayList;

public class UserFactory {

    private static UserFactory instance = null;
    private ArrayList<User> userList = new ArrayList<>();

    /** Costruzione della Factory */

    private UserFactory(){

        User user1 = new User("lollo", "xD");
        User user2 = new User("chicco", "1");
        User user3 = new User("asd", "123");
        User user4 = new User("manu", "ledda");
        User user5 = new User("maracaibo", "oleole");
        User user6 = new User("italian", "spiderman");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);

    }

    /** Metodo per ottenere l'istanza della factory */

    public static UserFactory getInstance() {

        if (instance == null) {
            instance = new UserFactory();
        }

        return instance;
    }

    /** Getter e Setter */

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public boolean checkUser(String username, String password){
        boolean flag = false;

        for (User u : this.userList) {
            if(u.getPassword().equals(password) && u.getUsername().equals(username)){
                flag=true;
                break;
            }
        }

        return flag;
    }

}
