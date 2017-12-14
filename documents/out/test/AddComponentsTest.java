import org.junit.Test;

import static org.junit.Assert.*;

public class AddComponentsTest {
    //Create an object to test
    AddComponents myObject = new AddComponents("test name", "test model", "last change date", "notes");

    @Test
    public void getItemName() throws Exception {
        assertEquals("test name", myObject.getItemName());
    }

    @Test
    public void getModel() throws Exception {
        assertEquals("test model", myObject.getModel());
    }

    @Test
    public void getLastChangeDate() throws Exception {
        assertEquals("last change date", myObject.getLastChangeDate());
    }

    @Test
    public void getNotes() throws Exception {
        assertEquals("notes", myObject.getNotes());
    }

}