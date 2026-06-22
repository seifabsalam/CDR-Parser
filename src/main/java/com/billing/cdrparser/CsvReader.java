package com.billing.cdrparser;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class CsvReader {

    public static List<LineItem> read(String filePath) throws Exception {
        try (FileReader reader = new FileReader(filePath)) {
            return new CsvToBeanBuilder<LineItem>(reader)
                    .withType(LineItem.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build()
                    .parse();
        }
    }
}
