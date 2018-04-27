package CSV;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVUtility {

    public void write(String fileName) throws IOException {
        try{
            CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            String[] testRecord = {"1", "2", "3"};
            csvWriter.writeNext(testRecord);
            csvWriter.close();
        } catch (Exception err){

        }

    }

}
