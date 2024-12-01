package com.theithorian.aoc;

import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class DayInputService implements IDayInputService {

    Logger logger = LoggerFactory.getLogger(DayInputService.class);

    public DayInput getInput(long dayId) throws ResourceNotFoundException {
        try {
            logger.info(String.format("Getting input data for day %s", dayId));

            var file = ResourceUtils.getFile("classpath:static/inputs/day" + dayId + ".txt");

            var fileBytes = Files.readAllBytes(file.toPath());

            logger.info(String.format("Found %s bytes from input file", fileBytes.length));

            return new DayInput(dayId, fileBytes);
        } catch (Exception ex) {
            throw new ResourceNotFoundException(String.format("Input for day %s not found", dayId));
        }

    }
}
