import CSV.CSVUtility;
import org.junit.Test;

import java.io.IOException;

public class Tests {

    @Test
    public void init(){
        Store store = Store.getInstance();
    }

    @Test
    public void testOpenCSV() throws IOException {
        CSVUtility openCSV = new CSVUtility();
        openCSV.write("./assets/test.csv");
    }
}
