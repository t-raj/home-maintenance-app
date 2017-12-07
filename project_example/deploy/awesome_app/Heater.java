import java.util.Scanner;

public class Heater extends AddComponents {
    //Initiate variable for heater specific notes
    private String notes;
    //Constructors
    //Create item with itemName predetermined, prompt for model and last maintenance date
    //Figure out the type of heater before assigning instructions
    public Heater(String model, String lastChangeDate) {
        super("Heater", model, lastChangeDate);
        this.setNotes();
    }

    //Setters
    //Prompts for figuring out the type of heater
    public void setNotes() {
        String instructions = "";
        Scanner user = new Scanner(System.in);
        System.out.println("Is your heating system radiators or a furnace?");
        String heat = user.nextLine();
        heat = heat.toLowerCase();
        while (!heat.equals("radiators") && !heat.equals("radiator") && !heat.equals("furnace")) {
            System.out.println("Please input 'radiator' or 'heater' after the prompt");
            System.out.println("Is your heating system radiators or a furnace?");
            heat = user.nextLine();
            heat = heat.toLowerCase();
        }
        if (heat.equals("radiators") || heat.equals("radiator")) {
            instructions = "When your radiators start in the Fall, check all around for leaks. If you notice any let your landlord know ASAP!";
        } else {
            instructions = "Filters have to be changed every 3 months. The easiest way to tell what type of filter you have is to look for a part number or size displayed somewhere on the filter. Most manufacturers will put their part number or nominal size on the outside of the filter for easy identification.";
        }
        this.notes = instructions;
    }

    //Getters
    //Call heater specific notes
    public String getNotes() {
        return this.notes;
    }

    //Setters
    //Add to Heater notes
    public void setNotes(String notes) {
        this.notes = this.notes + "/n Your notes: " + notes;
    }

}