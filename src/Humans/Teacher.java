package Humans;

import Enums.Position;
import Enums.Sex;

/**
 * клас викладача
 */
public class Teacher extends Human {
    private Position position;

    /**
     * сетап викладача
     * @param name
     * @param sex
     * @param age
     * @param position
     */
    public Teacher(String name, Sex sex, int age, Position position) {
        super(name, sex, age);
        this.position = position;
    }

    public Teacher(){
        super();
    }

    public Position getPosition() {
        return position;
    }

    /**
     * надає позицію викладачу
     * @param position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * для виведення інфрмації в консоль
     * @return
     */
    public String toString(){
        return super.toString() + " | " + position;
    }

}
