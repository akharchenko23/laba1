package Humans;//This class describes a human being.
import Enums.Sex;

import java.util.StringTokenizer;

@SuppressWarnings("unused")
public class Human {
    protected String name;
    protected Sex sex;
    protected int age;

    public Human(String name, Sex sex, int age){
        this.name = refactor(name);
        this.sex = sex;
        this.age = age;
    }

    public Human(){
        name = "Людина";
        sex = Sex.INTERSEX;
        age = 0;
    }

    /**
     * Refactors name, so it always starts with a letter and has only one space between every two words
     * @param name Starting name
     * @return Refactored name
     */
    private String refactor(String name){
        if(name == null) return "";
        StringTokenizer st = new StringTokenizer(name);
        StringBuilder res = new StringBuilder();
        while(st.hasMoreTokens()){
            res.append(st.nextToken());
            res.append(" ");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
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
