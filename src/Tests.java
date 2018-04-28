import CSV.CSVUtility;
import Stock.Item;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class Tests {

    @Before@Test
    public void init(){
        Store store = Store.getInstance();
    }

    @Test
    public void testCSVWrite() throws IOException {
        CSVUtility openCSV = new CSVUtility();
        openCSV.write("./assets/test.csv");
    }

    @Test
    public void testCSVRead() throws IOException {
        CSVUtility openCSV = new CSVUtility();
        openCSV.read("./assets/item_properties.csv");
    }
}
