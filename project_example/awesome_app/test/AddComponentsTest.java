import org.junit.Test;

import static org.junit.Assert.*;

public class AddComponentsTest {
    @org.junit.jupiter.api.Test
    void getItemName1() {
    }

    @org.junit.jupiter.api.Test
    void getModel1() {
    }

    @org.junit.jupiter.api.Test
    void getLastChangeDate1() {
    }

    @org.junit.jupiter.api.Test
    void getNotes1() {
    }

    @org.junit.jupiter.api.Test
    void setItemName1() {
    }

    @org.junit.jupiter.api.Test
    void setModel1() {
    }

    @org.junit.jupiter.api.Test
    void setLastChangeDate1() {
    }

    @org.junit.jupiter.api.Test
    void setNotes1() {
    }

    AddComponents myComponent = new AddComponents("name", "model","date", "notes");

    @Test
    public void getItemName() throws Exception {
        assertEquals("name", myComponent.getItemName());
    }

    @Test
    public void getModel() throws Exception {
        assertEquals("model", myComponent.getModel());
    }

    @Test
    public void getLastChangeDate() throws Exception {
        assertEquals("date", myComponent.getLastChangeDate());
    }

    @Test
    public void getNotes() throws Exception {
        assertEquals("notes", myComponent.getNotes());
    }

    @Test
    public void setItemName() throws Exception {
        myComponent.setItemName("newName");
        assertEquals("newName", myComponent.getItemName());
    }

    @Test
    public void setModel() throws Exception {
    }

    @Test
    public void setLastChangeDate() throws Exception {
    }

    @Test
    public void setNotes() throws Exception {
    }

}