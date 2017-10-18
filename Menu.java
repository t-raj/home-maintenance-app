import java.util.*;
import java.io.*;

public class Menu {

    public static void main(String[] args) {
        //This hash map will hold all the components the user adds
        HashMap<String, AddComponents> components = new HashMap<String, AddComponents>();

        Scanner sc = new Scanner(System.in);
        PrintStream std = System.out;
        PrintStream fileStream;
        System.out.println("Type \"list\" for a list of all saved components, \"add\" to add a new component, the name of a component to view or edit its details, or \"details\" to view details for all components, or \"save\" to write this info to a file.");
        String response = (sc.next()).toLowerCase();
        if (response == "list")
            listComponents(sc, components);
        else if (response == "add")
            componentFactory(sc, components, null);
        else if ((response == "details") || (response == "save")) {
            if (response == "save") {
                System.out.println("Enter name of file to write to"); 
                String response2 = (sc.next()).toLowerCase();
                try {
                    File file = new File(response2);
                    PrintStream fileout = new PrintStream(file);
                    System.setOut(fileout);
                }
                catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Output will be written to the console instead;");
                }
            }
            for(Map.Entry<String, AddComponents> entry : components.entrySet()) {
                String key = entry.getKey();
                getComponentInfo(key, components, sc);
            }
            System.setOut(std);
        }
        else
            getComponentInfo(response, components, sc);
    }

    public static void listComponents(Scanner sc, HashMap<String, AddComponents> components) {
        System.out.println("components: " + components.keySet() + "\n");
    }

    public static void componentFactory(Scanner sc, HashMap<String, AddComponents> components, String name){
        AddComponents component = components.get(name);
        if (name == "heater")
            component = new Heater();
        if (name == "windows")
            component = new Windows();
        if (name == "light bulbs")
            component = new LightBulbs();
        if(component == null) {
            component = new AddComponents();
            components.put(name, component);
        }
        else {
            component.setItemName();
            component.setModel();
            component.setLastChangeDate();
            component.setNotes();
        }
        System.out.println("Added " + name + " to component list \n");
    }

    public static void getComponentInfo(String name, HashMap<String, AddComponents> components, Scanner sc) {
        AddComponents component = components.get(name);
        System.out.println("name " + component.getItemName());
        System.out.println("model " + component.getModel());
        System.out.println("last change date " + component.getLastChangeDate());
        System.out.println("notes " + component.getNotes());
        System.out.println("Would you like to edit this component? (y/n)");
        String response = (sc.next()).toLowerCase();
        if ((response == "y") || (response == "Y"))
            componentFactory(sc, components, name);
    }
}

