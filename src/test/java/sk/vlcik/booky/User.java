package sk.vlcik.booky;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int id;
    public String name;

    @JsonBackReference
    public List<Item> userItems = new ArrayList<>();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addItem(Item item){
        userItems.add(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<Item> userItems) {
        this.userItems = userItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userItems=" + userItems +
                '}';
    }
}
