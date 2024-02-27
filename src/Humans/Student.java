package Humans;

import Enums.Sex;

@SuppressWarnings("unused")
//Студент успадковує від людини поля ім'я, вік, стать. Має свої групи (у значенні спеціальність) та курс
public class Student extends Human {

    protected int course;
    protected String group;

    public Student(String name, Sex sex, int age) {
        super(name, sex, age);

    }

    public Student(String name, Sex sex, int age, int course, String group) {
        super(name, sex, age);
        this.course = course;
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Increases the course of a student by 1 year till 4
     */
    public void incCourse() {
        if (course < 4) {
            course++;
        } else {
            // TODO придумати як реалізуємо випускника
        }

    }

    public String toString() {
        return super.toString() + " | " + course + ", " + group;
    }

}
