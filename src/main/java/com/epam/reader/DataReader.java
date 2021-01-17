package com.epam.reader;

import com.epam.exception.ReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);

    public String readFile(String filePath) throws ReaderException {
        String result = "";
        Path path = Paths.get(filePath);

        try (Stream<String> listStream = Files.lines(path)) {

            List<String> lines = listStream.collect(Collectors.toList());
            result = String.join("\n", lines);

        } catch (IOException e) {
            LOGGER.error("Exception while reading file: " + e);
            throw new ReaderException(e);
        }

        return result;
    }
}
