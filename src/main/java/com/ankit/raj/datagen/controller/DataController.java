package com.ankit.raj.datagen.controller;

import com.ankit.raj.datagen.constants.FakerGenerators;
import com.ankit.raj.datagen.pojo.ColumnData;
import com.ankit.raj.datagen.pojo.ColumnDataResponse;
import com.ankit.raj.datagen.pojo.ErrorResponse;
import com.ankit.raj.datagen.pojo.RequestData;
import com.github.javafaker.Faker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

    @PostMapping("/generateData")
    public ResponseEntity<Object> generateData(@RequestBody RequestData requestData) {

        List<String> quoteList = Arrays.asList("friendsQuotes", "harryPotterQuotes", "hobbitQuotes", "himymQuotes", "hhgttgQuotes",
                "gotQuotes", "rickandmortyQuotes", "lebowskiQuotes", "matzQuotes", "overwatchQuotes","princessbrideQuotes");
        String quoteGenerator;
        try {
            // Validate the request data before processing
            if (requestData.getNumRecords() <= 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("numRecords should be greater than 0."));
            }

            if (requestData.getColumnsData() == null || requestData.getColumnsData().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("At least one column should be provided."));
            }

            // Initialize the Faker instance with the provided locale
            Faker faker = new Faker(new java.util.Locale(requestData.getLocale()));

            List<ColumnDataResponse> response = new ArrayList<>();
            List<String> invalidGenerators = new ArrayList<>();

            for (ColumnData columnData : requestData.getColumnsData()) {
                String columnName = columnData.getColumnName();
                List<String> values = new ArrayList<>();

                String generatorType = columnData.getGenerator();
                if (!FakerGenerators.isValidGenerator(generatorType)) {
                    invalidGenerators.add(generatorType);
                    continue;
                }

                for (int i = 0; i < requestData.getNumRecords(); i++) {

                    if(generatorType.equalsIgnoreCase("quotes")){
                        Random random = new Random();
                        int randomIndex = random.nextInt(quoteList.size());
                        quoteGenerator = quoteList.get(randomIndex);

                        values.add(FakerGenerators.generateValue(faker, quoteGenerator));

                    }

                    values.add(FakerGenerators.generateValue(faker, generatorType));


                }

                ColumnDataResponse columnDataResponse = new ColumnDataResponse();
                columnDataResponse.setColumnName(columnName);
                columnDataResponse.setValues(values);

                response.add(columnDataResponse);
            }

            if (!invalidGenerators.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Invalid generators: " + invalidGenerators));
            }

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("An error occurred while generating data."));
        }
    }


    private String generateValue(Faker faker, String generator) {
        if (FakerGenerators.isValidGenerator(generator)) {
            return FakerGenerators.generateValue(faker, generator);
        } else {
            throw new IllegalArgumentException("Invalid generator type: " + generator);
        }
    }

}
