package Humans;

import Enums.Sex;

/**
 * клас студента
 */
//Студент успадковує від людини поля ім'я, вік, стать. Має свої групи (у значенні спеціальність) та курс
public class Student extends Human {

    protected int course;
    protected String group;

    public Student(String name, Sex sex, int age) {
        super(name, sex, age);

    }

    /**
     * сетап студента
     * @param name
     * @param sex
     * @param age
     * @param group
     * @param course
     */
    public Student(String name, Sex sex, int age, String group, int course) {
        super(name, sex, age);
        this.group = group;
        this.course = course;
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
            System.out.println("випускник");
        }

    }

    public String toString() {
        return super.toString() + " | " + group + "-" + course;
    }

}
