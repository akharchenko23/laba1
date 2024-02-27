package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Double getDouble() throws IOException {
        String s = getString();
        return Double.valueOf(s);
    }

    public static Float getFloat() throws IOException {
        String s = getString();
        return Float.valueOf(s);
    }

    public static Long getLong() throws IOException {
        String s = getString();
        return Long.valueOf(s);
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt() throws IOException {
        String s = getString();
        return Integer.valueOf(s);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    /**
     * Makes user enter a number from 1 to numOfChoice
     * @param numOfChoice A max value of choice (usually 2)
     * @return Number from 1 t numOfChoice that can be used in a switch statement to decide something
     * @throws IOException In case user is too stupid to enter natural number
     */
    public static int decide(int numOfChoice) throws IOException {
        int fate = getInt();
        while (fate < 1 || fate > numOfChoice) {
            System.out.print("Невірне значення! Будь ласка, введіть число від 1 до " + numOfChoice + ": ");
            fate = getInt();
        }
        return fate;
    }
}