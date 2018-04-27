import org.junit.Test;

import java.io.IOException;

public class Tests {

    @Test
    public void init(){
        Store store = Store.getInstance();
    }

    @Test
    public void testCSV() throws IOException {
        CSVWrite writer = new CSVWrite();
        writer.write("./assets/test.csv");
    }
}
