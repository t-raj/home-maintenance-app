import java.util.*;

public class AddComponents {
    private String itemName;
    private String model;
    private String lastChangeDate;
    private String notes = "No notes yet";

    //Constructors
    public AddComponents(String itemName, String model, String lastChangeDate, String notes){
        setItemName(itemName);
        setModel(model);
        setLastChangeDate(lastChangeDate);
        setNotes(notes);
    }
    //Constructor for specific items found in all apartments
    public AddComponents(String name, String model, String changedate){
        this.itemName = name;
        setModel(model);
        setLastChangeDate(changedate);
    }

    //Getters
    public String getItemName() {
        return itemName;
    }

    public String getModel() {
        return model;
    }

    public String getLastChangeDate() {
        return lastChangeDate;
    }

    public String getNotes() {
        return notes;
    }

    //Setters
    //Add the name of the household item that you'd like maintenance reminders for
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    //Add the model of the item, if there is one for easy access when contacting repair companies
    public void setModel(String model) {
        this.model = model;
    }
    //Add the date that you last performed maintenance for this item, what counts as "maintenance" will vary from item to item
    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
    //Add notes on what maintenance you performed, tips on how to do it, or whatever other reminders you may need
    public void setNotes(String notes) {
        this.notes = notes;
    }

}