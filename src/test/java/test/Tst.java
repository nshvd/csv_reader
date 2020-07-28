package test;

import io_utils.CSVReader;
import io_utils.SalesRecord;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.Map;

public class Tst {
    CSVReader reader;

    @BeforeClass
    public void setUp() throws IOException {
        this.reader = new CSVReader("5000 Sales Records.csv", true);
    }

    @Test
    public void t2() throws IOException {
        Map<String, String> line;
        while ((line = reader.readToMap()) != null) {
            SalesRecord record;

            try {
                record = new SalesRecord().populateFromLine(line);

                Assert.assertTrue(record != null,
                        "Couldn't Parse/Read Line #" + reader.getCounter()
                                + "\nRecord = " + line);

            } catch (Exception e) {
                Assert.fail("Couldn't Parse/Read Line #" + reader.getCounter()
                        + "\nRecord: " + line
                        + "\nReason: " + e.getMessage());
            }
        }
    }
}
