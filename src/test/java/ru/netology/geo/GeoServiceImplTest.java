package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeoServiceImplTest {

    @Test
    void locationByIPTest(){
        GeoServiceImpl geoService = new GeoServiceImpl();

        Assertions.assertEquals("Moscow", geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCity());
    }
    
}
