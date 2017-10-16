import java.util.Scanner;

public class Heater extends AddComponents {
    private String notes;
    //Constructors
    public Heater() {
        super();
    }

    public Heater(String model, String lastChangeDate, String notes) {
        super("Heater", model, lastChangeDate, notes);
    }

    //Setters
    public void setNotes() {
        String instructions = "";
        Scanner user = new Scanner(System.in);
        System.out.println("Is your heating system radiators or a furnace?");
        String heat = user.nextLine();
        heat = heat.toLowerCase();
        user.close();
        if (heat.equals("radiators") || heat.equals("radiator")) {
            instructions = "When your radiators start in the Fall, check all around for leaks. If you notice any let your landlord know ASAP!";
        } else if (heat.equals("furnace")) {
            instructions = "Filters have to be changed every 3 months. The easiest way to tell what type of filter you have is to look for a part number or size displayed somewhere on the filter. Most manufacturers will put their part number or nominal size on the outside of the filter for easy identification.";
        } else {
            System.out.println("Please input 'radiator' or 'heater' after the prompt");
            this.setNotes();
        }
        this.notes = instructions;
    }

    //Getters
    public String getNotes() {
        return this.notes;
    }

}