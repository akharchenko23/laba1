package utils;

import Humans.*;

public class Sorter {
    public static void sortName(Human[] humans) {
        sortName(humans, 0, humans.length - 1, 0);
    }

    public static void sortName(Human[] humans, int start, int end, int pos) {
        sort(humans, start, end, pos);
        char ch = humans[start].getName().charAt(pos);
        int fst = start;
        int snd = start;
        for (int i = start + 1; i <= end; i++) {
            if (humans[i].getName().charAt(pos) == ch) {
                snd = i;
            } else {
                if (snd - fst > 0) {
                    sortName(humans, fst, snd, pos + 1);
                } else {
                    fst = i;
                    snd = i;
                    ch = humans[i].getName().charAt(pos);
                }
            }
        }
        if (snd - fst > 0) {
            sortName(humans, fst, snd, pos + 1);
        }
    }

    public static void sort(Human[] humans, int start, int end, int pos) {
        for (int k = start; k < end - start; k++) {
            for (int i = start, j = start + 1; j <= end; i++, j++) {
                int fst = humans[i].getName().charAt(pos);
                int snd = humans[j].getName().charAt(pos);
                if (greater(fst, snd)) {
                    swap(humans, i, j);
                }
            }
        }
    }

    private static boolean greater(int fst, int snd) {
        return true;
    }

    private static void swap(Human[] humans, int fst, int snd) {
        Human temp = humans[fst];
        humans[fst] = humans[snd];
        humans[snd] = temp;
    }

    public static void main(String[] args) {
        String test = "Aboba";
        int i = test.charAt(3);
        System.out.println(i);
        int j = test.charAt(-1);
        System.out.println(i);
    }
}
