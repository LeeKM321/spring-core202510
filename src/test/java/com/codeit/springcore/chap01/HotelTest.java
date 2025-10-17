package com.codeit.springcore.chap01;

import com.codeit.springcore.chap03.Hotel;
import com.codeit.springcore.config.AppConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void hotelTest() {
        AppConfig config = new AppConfig();
        // 전달받은 호텔 객체 안에는 이미 의존 객체들이 주입되어 있는 상태.
        Hotel hotel = config.hotel();

        hotel.inform();
    }

}