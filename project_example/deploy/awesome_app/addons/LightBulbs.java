import java.util.Scanner;

public class LightBulbs extends AddComponents {
    //Instructions for upgrading to energy efficient lighting
    private String notes = "You can replace standard A-type lightbulbs with more energy-efficient options " +
            "such as CFLs, LEDs, and energy-saving (halogen) incandescents. If the bulb you are replacing is on a " +
            "dimmer switch you'll have to check what types of bulbs are compatible before switching types";

    //Constructors
    //Create item with itemName predetermined, prompt for model and last maintenance date
    public LightBulbs(String model, String lastChangeDate) {
        super("Light Bulbs", model, lastChangeDate);
    }

    //Getters
    //Call light bulb specific notes
    public String getNotes(){
        return this.notes;
    }

    //Setters
    //Add to Light Bulb notes
    public void setNotes(String notes) {
        this.notes = this.notes + "/n Your notes: " + notes;
    }

}