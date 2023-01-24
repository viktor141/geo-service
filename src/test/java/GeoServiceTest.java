import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class GeoServiceTest {


    @Test
    void localizationTextRuTest(){
        MessageSenderImpl messageSender = new MessageSenderImpl(Mockito.spy(GeoServiceImpl.class), Mockito.spy(LocalizationServiceImpl.class));

        Map<String, String> headers4= new HashMap<>();
        headers4.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers4));
        System.out.println();

        Map<String, String> headers1 = new HashMap<>();
        headers1.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers1));
        System.out.println();

        Map<String, String> headers3= new HashMap<>();
        headers3.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.67.12.175");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers3));
        System.out.println();
    }

    @Test
    void localizationTextUsaTest(){
        MessageSenderImpl messageSender = new MessageSenderImpl(Mockito.spy(GeoServiceImpl.class), Mockito.spy(LocalizationServiceImpl.class));

        Map<String, String> headers4= new HashMap<>();
        headers4.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals("Welcome", messageSender.send(headers4));
        System.out.println();

        Map<String, String> headers1 = new HashMap<>();
        headers1.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.2.183.149");
        Assertions.assertEquals("Welcome", messageSender.send(headers1));
        System.out.println();

        Map<String, String> headers3= new HashMap<>();
        headers3.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.13.149");
        Assertions.assertEquals("Welcome", messageSender.send(headers3));
        System.out.println();
    }

    @Test
    void locationByIPTest(){
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);

        Assertions.assertEquals("Moscow", geoService.byIp(GeoServiceImpl.MOSCOW_IP).getCity());
    }

    @Test
    void localeTest(){
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);

        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.BRAZIL));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}
