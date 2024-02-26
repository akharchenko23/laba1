//This class describes a human being.
import Enums.Sex;
@SuppressWarnings("unused")
public class Human {
    protected String name;
    protected Sex sex;
    protected int age;

    public Human(String name, Sex sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Increases age of a human by 1 year
     */
    public void incAge(){
        age++;
    }

    //Returns something like "Харченко Аліна. Дівчина, 18"
    public String toString(){
        return name + ". " + sex + ", " + age;
    }
}
