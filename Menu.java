import java.util.*;
import java.io.*;

public class Menu {

    public static void main(String[] args) {
        //This hash map will hold all the components the user adds
        HashMap<String, AddComponents> components = new HashMap<String, AddComponents>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            PrintStream std = System.out;
            PrintStream fileStream;
            System.out.println("Type \"setup\" to set up your account for the first time");
            System.out.println("Type \"list\" for a list of all saved components");
            System.out.println("Type \"add\" to add a new component");
            //System.out.println("Type the name of a component to view or edit its details");
            System.out.println("Type \"details\" to view details for a component");
            System.out.println("Type \"save\" to write this info to a file.");
            System.out.println("Type \"exit\" to exit the program");
            String response = sc.next().toLowerCase();
            if (response.equals("setup")) {
                setup(components);
            } else if (response.equals("list"))
                if (components.isEmpty()) {
                    System.out.println("There are no saved items yet!");
                } else {
                    listComponents(components);
                }
            else if (response.equals("add"))
                componentFactory(components);
            else if (response.equals("details")) {
                System.out.println("Type the name of the item that you'd like to view:");
                sc.nextLine();
                String response2 = sc.nextLine();
                while (!components.containsKey(response2)) {
                    System.out.println("That item is not in the list! Please enter the name of the item you wish to view:");
                    response2 = sc.nextLine();
                }
                getComponentInfo(response2, components);
            } else if (response.equals("save")) {
                System.out.println("Enter name of file to write to");
                String response3 = (sc.nextLine());
                try {
                    File file = new File(response3);
                    PrintStream fileout = new PrintStream(file);
                    System.setOut(fileout);
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Output will be written to the console instead;");
                }
                for (Map.Entry<String, AddComponents> entry : components.entrySet()) {
                    String key = entry.getKey();
                    getComponentInfo(key, components);
                }
                System.setOut(std);
            }
            else if (response.equals("exit")){
                System.exit(0);
            }else
                System.out.println("What you've entered is not one of the menu options");
        }
    }

    public static void setup(HashMap<String, AddComponents> components){
        System.out.println("First we'll set up info about your heater");
        AddComponents heater = new Heater();
        System.out.println("Next we'll set up info about your light bulbs");
        AddComponents lightbulbs = new LightBulbs();
        System.out.println("Lastly we'll set up info about your windows");
        AddComponents windows = new Windows();
        components.put(heater.getItemName(), heater);
        components.put(lightbulbs.getItemName(), lightbulbs);
        components.put(windows.getItemName(), windows);
        System.out.println("Added items to component list");
    }

    public static void listComponents(HashMap<String, AddComponents> components) {
        System.out.println("components: " + components.keySet() + "\n");
    }

    public static void componentFactory(HashMap<String, AddComponents> components){
        AddComponents component = new AddComponents();
        components.put(component.getItemName(), component);
        System.out.println("Added item to component list");
    }


    public static void getComponentInfo(String name, HashMap<String, AddComponents> components) {
        Scanner sc = new Scanner(System.in);
        AddComponents component = components.get(name);
        System.out.println("name " + component.getItemName());
        System.out.println("model " + component.getModel());
        System.out.println("last change date " + component.getLastChangeDate());
        System.out.println("notes " + component.getNotes());
        System.out.println("Would you like to edit this component? (y/n)");
        String response = (sc.next()).toLowerCase();
        if ((response.equals("y")) || (response.equals("Y")))
            componentFactory(components);
    }
}

