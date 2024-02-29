package org.example;


import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Progress_Bar {

    private static long s = System.currentTimeMillis();

    public static String Main(int Complete_Progress, int Current_Progress, int ping) throws InterruptedException {
        int ProgressBarLength = 20;
        StringBuilder Bar = new StringBuilder();
        int _1 = Current_Progress * ProgressBarLength / Complete_Progress;

        for (int i = 0; i < _1; i++) {
            Bar.append("#");
        }

        double pre = (double) Current_Progress / Complete_Progress * 100.1;
        if (pre >= 100) {
            pre = 100;
        }
        return "\r[進度 |" + Bar.toString() + "] " + String.format("%02.3f",pre) + "% " + "進行時間: " + formatElapsedTime(ping);

    }
    private static String formatElapsedTime(int ping) {

        long current = System.currentTimeMillis();
        long elaspsed = current - s;

        long seconds = elaspsed / 1000;
        long minutes = seconds / 60;
        long Hour = minutes / 60;
        long Day = Hour / 24;
        long remainingSeconds = seconds % 60;
        try {
            TimeUnit.NANOSECONDS.sleep(ping);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return String.format("%02d:%02d:%02d:%02d:%02d",Day ,Hour ,minutes ,remainingSeconds, elaspsed);
    }
    
}
