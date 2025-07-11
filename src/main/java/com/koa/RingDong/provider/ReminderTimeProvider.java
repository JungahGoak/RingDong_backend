package com.koa.RingDong.provider;

import com.koa.RingDong.entity.ReminderInterval;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

@Component
public class ReminderTimeProvider {

    public LocalDateTime generateRandomTime(ReminderInterval interval) {
        int intervalDays = interval.getDays();
        Random random = new Random();
        int plusDays = random.nextInt(intervalDays) + 1;
        LocalDate randomDate = LocalDate.now().plusDays(plusDays);

        int hour = 9 + random.nextInt(12);  // 9~20시
        int minute = random.nextInt(60);

        return LocalDateTime.of(randomDate, LocalTime.of(hour, minute));
    }

    public LocalDateTime generateRandomTimeForTomorrow(ReminderInterval interval) {
        LocalDateTime tomorrow = LocalDate.now().plusDays(1).atStartOfDay();
        Random random = new Random();

        int hour = 9 + random.nextInt(12);  // 9~20시
        int minute = random.nextInt(60);

        return tomorrow.plusHours(hour).plusMinutes(minute);
    }
}
