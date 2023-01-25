package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void localeRuCountryTest(){
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
    }

    @Test
    void localeBrCountryTest(){
        Assertions.assertEquals("Welcome", localizationService.locale(Country.BRAZIL));
    }

    @Test
    void localeUsCountryTest(){
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}
