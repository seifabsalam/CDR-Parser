package com.billing.cdrparser;

import java.nio.file.*;
import java.util.List;

public class CDRParser {

    public static void main(String[] args) throws Exception {
        Path inputDir  = Path.of(args[0]);
        Path outputDir = Path.of(args[1]);

        var ctx = DatabaseAdaptor.connect();

        WatchService watcher = FileSystems.getDefault().newWatchService();
        inputDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
        System.out.println("Watching: " + inputDir);

        while (true) {
            WatchKey key = watcher.take();

            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.OVERFLOW) continue;

                Path filename = (Path) event.context();
                if (!filename.toString().endsWith(".csv")) continue;

                Path file   = inputDir.resolve(filename);
                Path target = outputDir.resolve(filename);

                try {
                    List<LineItem> records = CsvReader.read(file.toString());
                    DatabaseWriter.write(records, ctx);
                    Files.move(file, target, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Processed: " + filename);
                } catch (Exception e) {
                    System.getLogger(CDRParser.class.getName())
                            .log(System.Logger.Level.ERROR, "Failed to process: " + filename, e);
                }
            }

            if (!key.reset()) break;
        }
    }
}
