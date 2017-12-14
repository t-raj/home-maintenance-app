import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class MenuIT {

    HashMap<String, AddComponents> components = new HashMap<String, AddComponents>();
    AddComponents myComponent = new AddComponents("testname", "testmodel", "testdate", "testnotes");

    @Before
    public void setUp() throws Exception {
        components.put("testname", myComponent);
    }

    public void listComponents() throws Exception {
        Menu.listComponents(components);
    }

    @Test
    public void saveComponentInfo() throws Exception {
        Menu.saveComponentInfo("testname", components);
    }


}