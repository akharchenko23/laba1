package utils;

import Humans.*;
import NaUKMA.Chair;

public class Sorter {
    /**
     * Sorts an array of humans based on their names
     *
     * @param humans An array of humans (can be students or teachers too)
     */
    public static void sortName(Human[] humans) {
        sortName(humans, 0, humans.length - 1, 0);
    }

    public static void sortName(Chair[] chairs) {
        sortName(chairs, 0, chairs.length - 1, 0);
    }

    private static void sortName(Chair[] chairs, int start, int end, int pos) {
        boolean itsOk = true;
        for (int i = start; i <= end; i++) {
            if (pos >= chairs[i].getName().length() - 1) {
                itsOk = false;
                break;
            }
        }
        if (itsOk) {
            sort(chairs, start, end, pos);
            char ch = chairs[start].getName().toLowerCase().charAt(pos);
            int fst = start;
            int snd = start;
            for (int i = start + 1; i <= end; i++) {
                if (chairs[i].getName().toLowerCase().charAt(pos) == ch) {
                    snd = i;
                } else {
                    if (snd - fst > 0) {
                        sortName(chairs, fst, snd, pos + 1);
                    } else {
                        fst = i;
                        snd = i;
                        ch = chairs[i].getName().toLowerCase().charAt(pos);
                    }
                }
            }
            if (snd - fst > 0) {
                sortName(chairs, fst, snd, pos + 1);
            }
        }
    }

    private static void sortName(Human[] humans, int start, int end, int pos) {
        boolean itsOk = true;
        for (int i = start; i <= end; i++) {
            if (pos >= humans[i].getName().length() - 1) {
                itsOk = false;
                break;
            }
        }
        if (itsOk) {
            sort(humans, start, end, pos);
            char ch = humans[start].getName().toLowerCase().charAt(pos);
            int fst = start;
            int snd = start;
            for (int i = start + 1; i <= end; i++) {
                if (humans[i].getName().toLowerCase().charAt(pos) == ch) {
                    snd = i;
                } else {
                    if (snd - fst > 0) {
                        sortName(humans, fst, snd, pos + 1);
                    } else {
                        fst = i;
                        snd = i;
                        ch = humans[i].getName().toLowerCase().charAt(pos);
                    }
                }
            }
            if (snd - fst > 0) {
                sortName(humans, fst, snd, pos + 1);
            }
        }
    }

    private static void sort(Chair[] chairs, int start, int end, int pos) {
        for (int k = start; k < end - start; k++) {
            for (int i = start, j = start + 1; j <= end; i++, j++) {
                int fst = chairs[i].getName().toLowerCase().charAt(pos);
                int snd = chairs[j].getName().toLowerCase().charAt(pos);
                if (greater(fst, snd)) {
                    swap(chairs, i, j);
                }
            }
        }
    }

    private static void sort(Human[] humans, int start, int end, int pos) {
        for (int k = start; k < end - start; k++) {
            for (int i = start, j = start + 1; j <= end; i++, j++) {
                int fst = humans[i].getName().toLowerCase().charAt(pos);
                int snd = humans[j].getName().toLowerCase().charAt(pos);
                if (greater(fst, snd)) {
                    swap(humans, i, j);
                }
            }
        }
    }

    private static boolean greater(int fst, int snd) {
        double uno = check(fst);
        double duo = check(snd);
        return uno > duo;
    }

    private static double check(int num) {
        switch (num) {
            case 1169: //ґ
                return 1075.5;
            case 1108: //є
                return 1077.5;
            case 1110: //і
                return 1080.3;
            case 1111: //ї
                return 1080.6;
        }
        return num;
    }

    private static void swap(Object[] objs, int fst, int snd) {
        Object temp = objs[fst];
        objs[fst] = objs[snd];
        objs[snd] = temp;
    }
}
