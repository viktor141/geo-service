package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    MessageSenderImpl messageSender = new MessageSenderImpl(Mockito.spy(GeoServiceImpl.class), Mockito.spy(LocalizationServiceImpl.class));

    @Test
    void localizationTextRuFirstLocation() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.MOSCOW_IP);
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
        System.out.println();
    }

    @Test
    void localizationTextRuSecondLocation() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
        System.out.println();
    }

    @Test
    void localizationTextRuThirdLocation() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.67.12.175");
        Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
        System.out.println();
    }

    @Test
    void localizationTextUsaFirstLocationTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, GeoServiceImpl.NEW_YORK_IP);
        Assertions.assertEquals("Welcome", messageSender.send(headers));
        System.out.println();
    }

    @Test
    void localizationTextUsaSecondLocationTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.2.183.149");
        Assertions.assertEquals("Welcome", messageSender.send(headers));
        System.out.println();
    }

    @Test
    void localizationTextUsaThirdLocationTest() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.13.149");
        Assertions.assertEquals("Welcome", messageSender.send(headers));
        System.out.println();
    }
}
