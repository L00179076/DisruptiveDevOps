package com.example.mavendemo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Vunerabilities {
    String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
    out.println("<p>Welcome, " + userInput + "!</p>");

    Runtime.getRuntime().exec("ping " + userInput);
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
    Object obj = ois.readObject();
    public Vunerabilities(ObjectInputStream ois) {
        this.ois = ois;
    }
    public String getQuery() {
        return query;
    }
    /**
     * @param query
     */
    public void setQuery(String query) {
        this.query = query;
    }
    public ObjectInputStream getOis() {
        return ois;
    }
    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    
}
