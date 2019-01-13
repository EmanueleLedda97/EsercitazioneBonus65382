package com.example.shiko.esercitazionebonus65382;

import java.io.Serializable;

public class User implements Serializable{

    private String username;
    private String password;

    /** Costruttore della classe */

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
        this("ginetto","wow");
    }

    /** Getter e Setter */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
