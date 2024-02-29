package Humans;

import Enums.Position;
import Enums.Sex;

public class Teacher extends Human {
    private Position position;

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

    public void setPosition(Position position) {
        this.position = position;
    }
    public String toString(){
        return super.toString() + " | " + position;
    }

}
