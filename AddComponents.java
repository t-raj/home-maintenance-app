public class AddComponents {
    private String itemName;
    private String model;
    private String lastChangeDate;
    private String notes;

    //Constructors
    public AddComponents(){
        this.itemName = "Not Specified";
        this.model = "Not Specified";
        this.lastChangeDate = "Not Specified";
        this.notes = "Not Specified";
    }

    public AddComponents(String itemName, String model, String lastChangeDate, String notes){
        this.itemName = itemName;
        this.model = model;
        this.lastChangeDate = lastChangeDate;
        this.notes = notes;
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
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}