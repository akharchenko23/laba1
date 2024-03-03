package NaUKMA;

import Humans.Student;
import Humans.Teacher;
import utils.Sorter;

public class University {
    private Faculty[] faculties;
    private String name;

    public University(String name, Faculty[] faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public University(String name) {
        this.name = name;
    }
    public University(){
        name = "Test uni";
    }

    /**
     * додати факультет
     * @param newFaculty
     * @return
     */
    public University addFaculty(Faculty newFaculty){
        Faculty[] expanded = new Faculty[faculties.length+1];
        for (int i = 0; i < faculties.length; i++) {
            expanded[i] = faculties[i];
        }
        expanded[expanded.length - 1] = newFaculty;
        faculties = expanded;
        return this;
    }

    /**
     * редагувати факультет
     * @param toChangeFaculty
     * @param changedFaculty
     * @return
     */
    public University changeFaculty(Faculty toChangeFaculty, Faculty changedFaculty){
        for (int i = 0; i < faculties.length; i++) {
            if(faculties[i] == toChangeFaculty){
                faculties[i] = changedFaculty;
            }
        }
        return this;
    }

    /**
     * Видалення факультету
     * @param victim
     */
    public void deleteFaculty(Faculty victim) {
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].equals(victim)) {
                faculties[i] = null;
            }
        }
        noFacultiesChanged();
    }

    /**
     * Прибирає усі null із масиву, тим самим зменшуючи його
     */
    private void noFacultiesChanged() {
        int count = 0;
        for (Faculty faculty : faculties) {
            if (faculty == null) count++;
        }
        Faculty[] survivors = new Faculty[faculties.length - count];
        for (int i = 0, j = 0; i < faculties.length; i++) {
            if (faculties[i] != null) {
                survivors[j] = faculties[i];
                j++;
            }
        }
        faculties = survivors;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }

    public String getName() {
        return name;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents(){
        Student[] students = new Student[0];
        for(Faculty faculty : faculties){
            Student[] expanded = new Student[students.length + faculty.getStudents().length];
            for(int i = 0; i < students.length; i++){
                expanded[i] = students[i];
            }
            for(int i = students.length; i < expanded.length; i++){
                expanded[i] = faculty.getStudents()[i-students.length];
            }
            students = expanded;
        }
        return students;
    }

    public Teacher[] getTeachers(){
        Teacher[] teachers = new Teacher[0];
        for(Faculty faculty : faculties){
            Teacher[] expanded = new Teacher[teachers.length + faculty.getTeachers().length];
            for(int i = 0; i < teachers.length; i++){
                expanded[i] = teachers[i];
            }
            for(int i = teachers.length; i < expanded.length; i++){
                expanded[i] = faculty.getTeachers()[i-teachers.length];
            }
            teachers = expanded;
        }
        return teachers;
    }

    public String toString(){
        Sorter.sortName(faculties);
        StringBuilder sb = new StringBuilder();
        sb.append(name).append('\n').append('\n');
        for (Faculty faculty : faculties) {
            sb.append(faculty).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
