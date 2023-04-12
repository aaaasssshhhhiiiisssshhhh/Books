package com.example;

import java.util.Random;
import java.util.UUID;

public class FirebaseIdGenerator {
    // Modeled after base64 web-safe chars, but ordered by ASCII.
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    // We generate 72-bits of randomness which get turned into 12 characters and appended to the timestamp to prevent
    // collisions with other clients. We store the last characters we generated because in the event of a collision,
    // we'll use those same characters except "incremented" by one.
    private static final int[] LAST_RAND_CHARS = new int[72];
    private static final Random random = new Random();
    // Timestamp of last push, used to prevent local collisions if you push twice in one ms.
    private static long lastPushTime = 0L;

    private FirebaseIdGenerator() {

    }

    public static synchronized String generateId() {
        long now = System.currentTimeMillis();
        boolean duplicateTime = now == lastPushTime;
        lastPushTime = now;

        var timeStampChars = new char[8];
        for (var i = 7; i >= 0; i--) {
            timeStampChars[i] = PUSH_CHARS.charAt((int) (now % 64));
            now = now / 64;
        }

        if (now != 0) {
            throw new AssertionError("We should have converted the entire timestamp.");
        }

        var id = new StringBuilder(20);
        for (char c : timeStampChars) {
            id.append(c);
        }

        if (!duplicateTime) {
            for (var i = 0; i < 12; i++) {
                LAST_RAND_CHARS[i] = random.nextInt(64);
            }
        } else {
            // If the timestamp hasn't changed since last push, use the same random number, except incremented by 1.
            var i = 0;
            for (i = 11; i >= 0 && LAST_RAND_CHARS[i] == 63; i--) {
                LAST_RAND_CHARS[i] = 0;
            }
            LAST_RAND_CHARS[i]++;
        }

        for (var i = 0; i < 12; i++) {
            id.append(PUSH_CHARS.charAt(LAST_RAND_CHARS[i]));
        }

        if (id.length() != 20) {
            throw new AssertionError("Length should be 20.");
        }

        return id.toString();
    }

    public static synchronized String generate(){
        long timestamp = System.currentTimeMillis();
        var uuid = new UUID(timestamp, 0);
        return uuid.toString();
    }


}
