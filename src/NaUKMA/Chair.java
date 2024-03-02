package NaUKMA;

import Humans.Human;
import Humans.Student;
import Humans.Teacher;

public class Chair {
    private Student[] students;
    private Teacher[] teachers;
    private String name;

    public Chair(String name, Teacher[] teachers, Student[] students) {
        this.students = students;
        this.teachers = teachers;
        this.name = name;
    }

    public Chair(String name) {
        this.name = name;
    }

    public Chair() {
        name = "Кафедра тестування";
    }

    public Chair kill(Human victim){
        if(victim.getClass().equals(Student.class)){
            killStudent(victim);
        } else {
            killTeacher(victim);
        }
        return this;
    }

    /**
     * Прибирає студента із масиву студентів
     *
     * @param victim Студент якого треба видалити
     */
    private void killStudent(Human victim) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(victim)) {
                students[i] = null;
            }
        }
        noStudentsWereHarmedInTheProcess();
    }

    /**
     * Прибирає вчителя із масиву вчителів
     *
     * @param victim Вчитель якого треба видалити
     */
    private void killTeacher(Human victim) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].equals(victim)) {
                teachers[i] = null;
            }
        }
        noTeachersWereHarmedInTheProcess();
    }

    /**
     * Прибирає усі null із масиву студентів, тим самим зменшуючи його
     */
    private void noStudentsWereHarmedInTheProcess() {
        int count = 0;
        for (Student student : students) {
            if (student == null) count++;
        }
        Student[] survivors = new Student[students.length - count];
        for (int i = 0, j = 0; i < students.length; i++) {
            if (students[i] != null) {
                survivors[j] = students[i];
                j++;
            }
        }
        students = survivors;
    }

    /**
     * Прибирає усі null із масиву вчителів, тим самим зменшуючи його
     */
    private void noTeachersWereHarmedInTheProcess() {
        int count = 0;
        for (Teacher teacher : teachers) {
            if (teacher == null) count++;
        }
        Teacher[] survivors = new Teacher[teachers.length - count];
        for (int i = 0, j = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                survivors[j] = teachers[i];
                j++;
            }
        }
        teachers = survivors;
    }

    /**
     * Додає студента в базу даних
     *
     * @param newGuy Студент якого треба додати
     * @return Повертає кафедру з новим студентом
     */
    public Chair addStudent(Student newGuy) {
        Student[] expanded = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            expanded[i] = students[i];
        }
        expanded[expanded.length - 1] = newGuy;
        students = expanded;
        return this;
    }

    /**
     * Додає вчителя в базу даних
     *
     * @param newGuy Студент якого треба додати
     * @return Повертає кафедру з новим студентом
     */
    public Chair addTeacher(Teacher newGuy) {
        Teacher[] expanded = new Teacher[students.length + 1];
        for (int i = 0; i < teachers.length; i++) {
            expanded[i] = teachers[i];
        }
        expanded[expanded.length - 1] = newGuy;
        teachers = expanded;
        return this;
    }

    public Student[] getStudents() {
        return students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public String getName() {
        return name;
    }

    public Student getStudent(int index) {
        if (index >= 0 && index < students.length) return students[index];
        return null;
    }

    public Teacher getTeacher(int index) {
        if (index >= 0 && index < teachers.length) return teachers[index];
        return null;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent(Student student, int index) {
        if (index >= 0 && index < students.length) students[index] = student;
    }

    public void getTeacher(Teacher teacher, int index) {
        if (index >= 0 && index < teachers.length) teachers[index] = teacher;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(name).append('\n').append("Викладачі:").append('\n');
        for(int i = 0; i < teachers.length; i++){
            sb.append(i+1).append(". ").append(teachers[i].toString()).append('\n');
        }
        sb.append("Студенти:").append('\n');
        for(int i = 0; i < students.length; i++){
            sb.append(i+1).append(". ").append(students[i].toString()).append('\n');
        }
        return sb.toString();
    }
}
