import Enums.Position;
import Enums.Sex;
import Humans.Student;
import Humans.Teacher;
import NaUKMA.Chair;
import utils.Array;
import utils.Sorter;

public class Tester {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        Teacher[] teachers = new Teacher[2];
        Student st1 = new Student("Тимко", Sex.MALE, 18, "ІПЗ", 1);
        Student st2 = new Student("Аліна", Sex.FEMALE, 18, "ІПЗ", 1);
        Student st3 = new Student("Дарія", Sex.INTERSEX, 17, "ІПЗ", 1);
        Teacher t1 = new Teacher("Митник", Sex.INTERSEX, 55, Position.SENIOR);
        Teacher t2 = new Teacher("Силенко", Sex.FEMALE, 25, Position.ASSISTANT);
        Teacher t3 = new Teacher("Глиба", Sex.MALE, 45, Position.DEAN);
        students = new Student[]{st1, st2, st3};
        teachers = new Teacher[]{t1,t2,t3};
        Chair test = new Chair("Факультет інформатики", teachers, students);
        test.setStudents(students);
        Array.print(test.getStudents());
        test.kill(st1);
        Array.print(test.getStudents());
        test.addStudent(st1).addStudent(st1).addStudent(st3);
        Array.print(test.getStudents());
        Sorter.sortName(test.getStudents());
        Array.print(test.getStudents());

        System.out.println(test);
    }
}
