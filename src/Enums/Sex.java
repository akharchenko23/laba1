package Enums;

/**
 * енам статей
 */
public enum Sex {
    MALE, FEMALE, INTERSEX;

    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "Хлопець";
            case 1:
                return "Дівчина";
            default:
                return "Інтерсекс";
        }
    }
}