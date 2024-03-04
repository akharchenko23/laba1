package Enums;

/**
 * енам посад в університеті
 */
public enum Position {
    PRESIDENT, DEAN, SENIOR, ASSISTANT;
    public String toString(){
        switch(this.ordinal()){
            case 0:
                return "Президент";
            case 1:
                return "Декан";
            case 2:
                return "Старший викладач";
            default:
                return "Асистент";
        }
    }
}
