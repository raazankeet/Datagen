package com.ankit.raj.datagen.constants;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FakerGenerators {

    public static final String FIRST_NAME  = "firstName";
    public static final String LAST_NAME  = "lastName";
    public static final String FULL_NAME = "fullName";

    public static final String PHONE_NUMBER  = "phoneNumber";
    public static final String RANDOM_NUMBER  = "randomNumber";
    public static final String CITY  = "city";
    public static final String STATE  = "state";
    public static final String ZIPCODE  = "zipcode";
    public static final String FULL_ADDRESS = "fullAddress";
    public static final String STREET_ADDRESS = "streetAddress";
    public static final String ANCIENT_GOD = "ancientGod";
    public static final String ANIMAL_NAME = "animalName";
    public static final String ARTIST_NAME = "artistName";
    public static final String CREDIT_CARD_NUMBER = "creditCardNumber";
    public static final String PRODUCT_NAME = "productName";
    public static final String CATCH_PHRASE = "catchPhrase";
    public static final String SHA_256 = "sha256";
    public static final String FUTURE_DATE = "futureDate";
    public static final String PAST_DATE = "pastDate";
    public static final String SSN = "ssn";
    public static final String UUID = "uuid";
    public static final String EMAIL_ID = "emailID";

    public static final String SENTENCES = "sentences";
    public static final String HOSPITAL_NAME = "hospitalName";
    public static final String DISEASE_NAME = "diseaseName";
    public static final String MEDICINE_NAME = "medicineName";
    public static final String WEATHER = "weather";
    public static final String TEMPERATURE = "temperature";
    public static final String BOOK_NAME = "bookName";
    public static final String BOOK_AUTHOR = "bookAuthor";

    public static final String QUOTES = "quotes";
    public static final String FRIENDS_QUOTES = "friendsQuotes";
    public static final String HARRY_POTTER_QUOTES = "harryPotterQuotes";
    public static final String HOBBIT_QUOTES = "hobbitQuotes";
    public static final String HIMYM_QUOTES = "himymQuotes";
    public static final String HHGTTG_QUOTES = "hhgttgQuotes";
    public static final String GOT_QUOTES = "gotQuotes";
    public static final String RICKANDMORTY_QUOTES = "rickandmortyQuotes";
    public static final String LEBOWSKI_QUOTES = "lebowskiQuotes";
    public static final String MATZ_QUOTES = "matzQuotes";
    public static final String OVERWATCH_QUOTES = "overwatchQuotes";
    public static final String PRINCESSBRIDE_QUOTES = "princessbrideQuotes";


    // Add more generator types here if needed

    private static final Map<String, Function<Faker, String>> generators = new HashMap<>();

    static {
        generators.put(FIRST_NAME, faker -> faker.name().firstName());
        generators.put(LAST_NAME, faker -> faker.name().lastName());
        generators.put(FULL_NAME, faker -> faker.name().fullName());

        generators.put(ANCIENT_GOD, faker -> faker.ancient().god());
        generators.put(ANIMAL_NAME, faker -> faker.animal().name());

        generators.put(STREET_ADDRESS, faker -> faker.address().streetAddress(true));
        generators.put(FULL_ADDRESS, faker -> faker.address().fullAddress());
        generators.put(CITY, faker -> faker.address().cityName());
        generators.put(STATE, faker -> faker.address().state());
        generators.put(ZIPCODE, faker -> faker.address().zipCode());

        generators.put(PHONE_NUMBER, faker -> faker.phoneNumber().cellPhone());
        generators.put(RANDOM_NUMBER, faker -> String.valueOf(faker.number().randomNumber()));
        generators.put(ARTIST_NAME, faker -> faker.artist().name());
        generators.put(CREDIT_CARD_NUMBER, faker -> faker.finance().creditCard());
        generators.put(PRODUCT_NAME, faker -> faker.commerce().productName());
        generators.put(CATCH_PHRASE, faker -> faker.company().catchPhrase());
        generators.put(SHA_256, faker -> faker.crypto().sha256());
        generators.put(FUTURE_DATE, faker -> String.valueOf(faker.date().future(21900,365,TimeUnit.DAYS)));
        generators.put(PAST_DATE, faker ->  String.valueOf(faker.date().past(21900,365,TimeUnit.DAYS)));
        generators.put(SSN, faker ->   faker.idNumber().ssnValid());
        generators.put(UUID, faker ->   faker.internet().uuid());
        generators.put(EMAIL_ID, faker ->   faker.internet().emailAddress());


        generators.put(SENTENCES, faker ->   faker.lorem().sentence(15,5));
        generators.put(HOSPITAL_NAME, faker ->   faker.medical().hospitalName());
        generators.put(DISEASE_NAME, faker ->   faker.medical().diseaseName());
        generators.put(MEDICINE_NAME, faker ->   faker.medical().medicineName());
        generators.put(WEATHER, faker ->   faker.weather().description());
        generators.put(TEMPERATURE, faker ->   faker.weather().temperatureCelsius());
        generators.put(BOOK_NAME, faker ->   faker.book().title());
        generators.put(BOOK_AUTHOR, faker ->   faker.book().author());

        generators.put(QUOTES, faker ->   faker.friends().quote());
        generators.put(HARRY_POTTER_QUOTES, faker ->   faker.harryPotter().quote());
        generators.put(HOBBIT_QUOTES, faker ->   faker.hobbit().quote());
        generators.put(HIMYM_QUOTES, faker ->   faker.howIMetYourMother().quote());
        generators.put(HHGTTG_QUOTES, faker ->   faker.hitchhikersGuideToTheGalaxy().quote());
        generators.put(GOT_QUOTES, faker ->   faker.gameOfThrones().quote());
        generators.put(RICKANDMORTY_QUOTES, faker ->   faker.rickAndMorty().quote());
        generators.put(LEBOWSKI_QUOTES, faker ->   faker.lebowski().quote());
        generators.put(MATZ_QUOTES, faker ->   faker.matz().quote());
        generators.put(OVERWATCH_QUOTES, faker ->   faker.overwatch().quote());
        generators.put(PRINCESSBRIDE_QUOTES, faker ->   faker.princessBride().quote());
        generators.put(FRIENDS_QUOTES, faker ->   faker.friends().quote());
        // Add more generators here if needed
    }

    private FakerGenerators() {
        // Private constructor to prevent instantiation
    }

    public static String generateValue(Faker faker, String generatorType) {
        Function<Faker, String> generatorFunction = generators.getOrDefault(generatorType, f -> "Unknown generator");
        return generatorFunction.apply(faker);
    }

    public static boolean isValidGenerator(String generator) {
        // Use the final string constants from the FakerGenerators class
        return generator.equals(FIRST_NAME) ||
                generator.equals(LAST_NAME) ||
                generator.equals(FULL_NAME) ||
                generator.equals(ANCIENT_GOD) ||
                generator.equals(ANIMAL_NAME) ||
                generator.equals(STREET_ADDRESS) ||
                generator.equals(CITY) ||
                generator.equals(STATE) ||
                generator.equals(ZIPCODE) ||
                generator.equals(PHONE_NUMBER) ||
                generator.equals(CREDIT_CARD_NUMBER) ||
                generator.equals(PRODUCT_NAME) ||
                generator.equals(RANDOM_NUMBER) ||
                generator.equals(CATCH_PHRASE) ||
                generator.equals(ARTIST_NAME) ||
                generator.equals(FUTURE_DATE) ||
                generator.equals(PAST_DATE) ||
                generator.equals(SHA_256) ||
                generator.equals(SSN) ||
                generator.equals(EMAIL_ID) ||
                generator.equals(QUOTES) ||
                generator.equals(SENTENCES) ||
                generator.equals(HOSPITAL_NAME) ||
                generator.equals(DISEASE_NAME) ||
                generator.equals(MEDICINE_NAME) ||
                generator.equals(WEATHER) ||
                generator.equals(TEMPERATURE) ||
                generator.equals(BOOK_NAME) ||
                generator.equals(BOOK_AUTHOR) ||
                generator.equals(FULL_ADDRESS);
        // Add more valid generator types as needed...
    }

}
