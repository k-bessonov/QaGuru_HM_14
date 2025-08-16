package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    public static Faker faker = new Faker(new Locale("en-GB"));

    private static final String[] goodSearchValues =
            {"протеин", "чипсы", "мороженое", "дубайский", "шоколад", "бокс"};

    private static final String[] badSearchValues =
            {"badSearchValues", "непонятночтоищувообще", "невалидныйрезультат"};

    public static String goodSearchValue = faker.options().option(goodSearchValues),
    badSearchValue = faker.options().option(badSearchValues);


}
