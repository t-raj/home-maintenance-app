import java.util.Scanner;

public class Windows extends AddComponents {
    //Instructions for sealing windows in the winter
    private String notes = "You can buy window insulation kits from a hardware store or online. " +
            "Kits usually include plastic shrink film that is applied to the indoor window frame with " +
            "double-stick tape, then heated with a hair dryer to shrink the film and remove any wrinkles.";

    //Constructors
    //Create item with itemName predetermined, prompt for model and last maintenance date
    public Windows() {
        super("Windows");
    }

    //Getters
    //Call windows specific notes
    public String getNotes(){
        return this.notes;
    }

}