import java.util.Scanner;

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

    public AddComponents(String itemName){
        this.itemName = itemName;
        setModel();
        setLastChangeDate();
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

    public String getFindSizeInstructions() {
        return notes;
    }

    //Setters
    public void setItemName() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the name of the household object you'd like to track:");
        this.itemName = user.nextLine();
    }

    public void setModel() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the model of the object, or n/a if not available:");
        this.model = user.nextLine();
    }

    public void setLastChangeDate() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter the date that you last serviced this object:");
        this.lastChangeDate = user.nextLine();
    }

    public void setNotes() {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter any notes you have about servicing this object:");
        this.notes = notes;
    }

}