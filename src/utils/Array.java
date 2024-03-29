package utils;

/**
 * утилітний клас для виводу масивів
 */
public class Array {
    /**
     * виводить масив
     * @param array
     */
    public static void print(Object[] array) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : array) {
            sb.append(obj).append("\n"); // prints every number one by one, separated by new line
        }
        System.out.println(sb);
    }

    /**
     * виводить масив масивів
     * @param array
     */
    public static void print(Object[][] array) {
        StringBuilder sb = new StringBuilder();
        for (Object[] row : array) {
            for (Object obj : row) {
                sb.append(obj).append(", "); // prints every number one by one, separated by comas
            }
            sb.setCharAt(sb.length() - 1, '\n'); // starts a new row
        }
        sb.setCharAt(sb.length() - 2, '.'); // replaces last coma with a dot
        System.out.println(sb);
    }
}