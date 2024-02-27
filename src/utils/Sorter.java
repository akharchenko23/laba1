package utils;

import Enums.Sex;
import Humans.*;

import static utils.PrintArray.printArray;

public class Sorter {
    /**
     * Sorts an array of humans based on their names
     * @param humans An array of humans (can be students or teachers too)
     */
    public void sortName(Human[] humans) {
        sortName(humans, 0, humans.length - 1, 0);
    }

    private void sortName(Human[] humans, int start, int end, int pos) {
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

    private void sort(Human[] humans, int start, int end, int pos) {
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

    private boolean greater(int fst, int snd) {
        double uno = check(fst);
        double duo = check(snd);
        return uno > duo;
    }

    private double check(int num) {
        switch(num){
            //case 1068: //Ґ
            //    return 1043.5;
            //case 1028: //Є
            //    return 1045.5;
            //case 1030: //І
            //    return 1048.3;
            //case 1031: //Ї
            //    return 1048.6;
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

    private void swap(Human[] humans, int fst, int snd) {
        Human temp = humans[fst];
        humans[fst] = humans[snd];
        humans[snd] = temp;
    }
}
