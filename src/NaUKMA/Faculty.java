package NaUKMA;

import Humans.Student;
import Humans.Teacher;
import utils.Sorter;

/*
уміє редагувати кафедру, видаляти кафедру, додавати кафедру
 */
public class Faculty {

    private Chair[] chairs;
    private String name;

    public Faculty(String name, Chair[] chairs){
        this.name = name;
        this.chairs = chairs;
    }
    public Faculty(String name){
        this.name = name;
    }

    public Faculty(){
        name = "Тестовий факультет";
    }

    /**
     * додати кафедру
     * @param newChair кафедра яку додаємо
     * @return
     */
    public Faculty addChair(Chair newChair){
        Chair[] expanded = new Chair[chairs.length+1];
        for (int i = 0; i < chairs.length; i++) {
            expanded[i] = chairs[i];
        }
        expanded[expanded.length - 1] = newChair;
        chairs = expanded;
        return this;
    }

    /**
     * Можна редагувати кафедру
     * @param toChangeChair
     * @param changedChair
     * @return
     */
    public Faculty changeChair(Chair toChangeChair, Chair changedChair){
        for (int i = 0; i < chairs.length; i++) {
            if(chairs[i] == toChangeChair){
                chairs[i] = changedChair;
            }
        }
        return this;
    }

    /**
     * Видаляє кафедру
     * @param victim кафедра яку видалимо
     */
    public void deleteChair(Chair victim) {
        for (int i = 0; i < chairs.length; i++) {
            if (chairs[i].equals(victim)) {
                chairs[i] = null;
            }
        }
        noChairsChanged();
    }

    /**
     * Прибирає усі null із масиву, тим самим зменшуючи його
     */
    private void noChairsChanged() {
        int count = 0;
        for (Chair chair : chairs) {
            if (chair == null) count++;
        }
        Chair[] survivors = new Chair[chairs.length - count];
        for (int i = 0, j = 0; i < chairs.length; i++) {
            if (chairs[i] != null) {
                survivors[j] = chairs[i];
                j++;
            }
        }
        chairs = survivors;
    }

    public void setChairs(Chair[] chairs) {
        this.chairs = chairs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chair[] getChairs() {
        return chairs;
    }

    public String getName() {
        return name;
    }

    /**
     * Отримати масив студентів на кафедрі.
     * @return Масив студентів.
     */
    public Student[] getStudents(){
        Student[] students = new Student[0];
        for(Chair chair : chairs){
            Student[] expanded = new Student[students.length + chair.getStudents().length];
            for(int i = 0; i < students.length; i++){
                expanded[i] = students[i];
            }
            for(int i = students.length; i < expanded.length; i++){
                expanded[i] = chair.getStudents()[i-students.length];
            }
            students = expanded;
        }
        return students;
    }
    /**
     * Отримати масив викладачів на кафедрі.
     * @return Масив викладачів.
     */
    public Teacher[] getTeachers(){
        Teacher[] teachers = new Teacher[0];
        for(Chair chair : chairs){
            Teacher[] expanded = new Teacher[teachers.length + chair.getTeachers().length];
            for(int i = 0; i < teachers.length; i++){
                expanded[i] = teachers[i];
            }
            for(int i = teachers.length; i < expanded.length; i++){
                expanded[i] = chair.getTeachers()[i-teachers.length];
            }
            teachers = expanded;
        }
        return teachers;
    }
    /**
     * Перетворює об'єкт кафедри у рядок.
     * @return Рядок, що містить інформацію про кафедру.
     */
    public String toString(){
        Sorter.sortName(chairs);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n').append('\n');
        for (Chair chair : chairs) {
            sb.append(chair).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
