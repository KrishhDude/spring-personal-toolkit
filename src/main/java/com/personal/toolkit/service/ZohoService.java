package com.personal.toolkit.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ZohoService {

    private static final int TOTAL_MINUTES = 8 * 60;

    public String calculateTimeLeft(String inputTime) {
        try {
            String[] timeSplit = inputTime.replaceAll("[.]", ":").split(":");
            int totalMinutes = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);

            int minutesLeft = TOTAL_MINUTES - totalMinutes;

            return String.format("%d hour%s %d minute%s",
                    minutesLeft / 60,
                    minutesLeft / 60 > 1 ? "s" : "",
                    minutesLeft % 60,
                    minutesLeft % 60 > 1 ? "s" : "");
        } catch (NumberFormatException e) {
            log.error("Invalid time format: {}", inputTime);
            return "Invalid time format";
        } catch (Exception e) {
            log.error("Error calculating time left", e);
            return "Error calculating time left" + e.getMessage();
        }
    }
}
