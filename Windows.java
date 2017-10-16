import java.util.Scanner;

public class Windows extends AddComponents {
    private String notes = "You can buy window insulation kits from a hardware store or online. " +
            "Kits usually include plastic shrink film that is applied to the indoor window frame with " +
            "double-stick tape, then heated with a hair dryer to shrink the film and remove any wrinkles.";

    //Constructors
    public Windows() {
        super("Windows");
    }

    //Getters
    public String getNotes(){
        return this.notes;
    }

}