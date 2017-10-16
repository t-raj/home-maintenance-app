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

    public String getNotes() {
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
        this.notes = user.nextLine();
    }

}

class TestRun {
    public static void main(String[] args) {
        AddComponents test = new AddComponents();
        System.out.println(test.getItemName());
        System.out.println(test.getModel());
        System.out.println(test.getLastChangeDate());
        System.out.println(test.getNotes());

        AddComponents testWin = new Windows();
        System.out.println(testWin.getItemName());
        System.out.println(testWin.getModel());
        System.out.println(testWin.getLastChangeDate());
        System.out.println(testWin.getNotes());

        AddComponents testLight = new LightBulbs();
        System.out.println(testLight.getItemName());
        System.out.println(testLight.getModel());
        System.out.println(testLight.getLastChangeDate());
        System.out.println(testLight.getNotes());

        AddComponents testHeat = new Heater();
        System.out.println(testHeat.getItemName());
        System.out.println(testHeat.getModel());
        System.out.println(testHeat.getLastChangeDate());
        System.out.println(testHeat.getNotes());
    }
}