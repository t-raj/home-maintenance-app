import java.util.Scanner;

public class LightBulbs extends AddComponents {
    //Instructions for upgrading to energy efficient lighting
    private String notes = "You can replace standard A-type lightbulbs with more energy-efficient options " +
            "such as CFLs, LEDs, and energy-saving (halogen) incandescents. If the bulb you are replacing is on a " +
            "dimmer switch you'll have to check what types of bulbs are compatible before switching types";

    //Constructors
    //Create item with itemName predetermined, prompt for model and last maintenance date
    public LightBulbs() {
        super("Light Bulbs");
    }

    //Getters
    //Call light bulb specific notes
    public String getNotes(){
        return this.notes;
    }

}