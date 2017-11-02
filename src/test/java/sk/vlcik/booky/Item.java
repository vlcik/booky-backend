package sk.vlcik.booky;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Item {
    public int id;
    public String itemName;

    @JsonManagedReference
    public User owner;

    public Item(int id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }

    public Item(int id, String itemName, User owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public User getOwner() {
        return owner;
    }



    public void setOwner(User owner) {
        this.owner = owner;
    }
}
