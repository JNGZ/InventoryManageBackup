import CSV.CSVFormatException;
import CSV.CSVUtility;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Tests {

    CSVUtility csvUtility;

    Store store;

    @Before@Test
    public void init(){
        csvUtility = new CSVUtility();
        store = Store.getInstance();
    }

    @Test
    public void testCSVWrite() throws CSVFormatException {

    }

    @Test
    public void testCSVRead() throws CSVFormatException {
        csvUtility.read("./assets/item_properties.csv");
    }

    @Test
    public void testWriteItemList() throws CSVFormatException {
        store.stock.saveArray();
    }
}
