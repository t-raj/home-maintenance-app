import java.util.*;

public class AddComponents {
    private String itemName;
    private String model;
    private String lastChangeDate;
    private String notes = "No notes yet";

    //Constructors
    public AddComponents(){
        setItemName();
        setModel();
        setLastChangeDate();
        setNotes();
    }
    //Constructor for specific items found in all apartments
    public AddComponents(String itemName){
        this.itemName = itemName;
        setModel();
        setLastChangeDate();
    }

    //Constructor for testing purposes
    public AddComponents(String itemName, String model, String lastChangeDate, String notes){
        this.itemName = itemName;
        this.model = model;
        this.lastChangeDate = lastChangeDate;
        this.notes = notes;
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
    public void setItemName() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the name of the household object you'd like to track:");
        this.itemName = user.nextLine();
    }
    //Add the model of the item, if there is one for easy access when contacting repair companies
    public void setModel() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the model of the object, or n/a if not available:");
        this.model = user.nextLine();
    }
    //Add the date that you last performed maintenance for this item, what counts as "maintenance" will vary from item to item
    public void setLastChangeDate() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the date that you last serviced this object:");
        this.lastChangeDate = user.nextLine();
    }
    //Add notes on what maintenance you performed, tips on how to do it, or whatever other reminders you may need
    public void setNotes() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter any notes you have about servicing this object:");
        this.notes = user.nextLine();
    }

}