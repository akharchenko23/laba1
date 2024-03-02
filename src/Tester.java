import Enums.Position;
import Enums.Sex;
import Humans.Student;
import Humans.Teacher;
import NaUKMA.Chair;
import NaUKMA.Faculty;
import NaUKMA.University;
import utils.Array;
import utils.Sorter;

public class Tester {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        Teacher[] teachers = new Teacher[2];
        Chair[] chairs;
        Faculty[] faculties;
        Student st1 = new Student("Тимко", Sex.MALE, 18, "ІПЗ", 1);
        Student st2 = new Student("Аліна", Sex.FEMALE, 18, "ІПЗ", 1);
        Student st3 = new Student("Дарія", Sex.INTERSEX, 17, "ІПЗ", 1);
        Teacher t1 = new Teacher("Митник", Sex.INTERSEX, 55, Position.SENIOR);
        Teacher t2 = new Teacher("Силенко", Sex.FEMALE, 25, Position.ASSISTANT);
        Teacher t3 = new Teacher("Глиба", Sex.MALE, 45, Position.DEAN);
        students = new Student[]{st1, st2, st3};
        teachers = new Teacher[]{t1,t2,t3};
        Chair ukrLanguageChair = new Chair("Кафедра укр мови", teachers, students);
        Chair mathChair = new Chair("Кафедра математики", teachers, students);
        chairs = new Chair[]{ukrLanguageChair, mathChair};
        Faculty fi = new Faculty("ФІ", chairs);
        Faculty fgn = new Faculty("ФГН", chairs);
        faculties = new Faculty[]{fi, fgn};
        University NaUKMA = new University("НаУКМА", faculties);
        //тест редагування студента
        ukrLanguageChair.changeStudent(st1, st2);
        Array.print(students);
        //тест редагування кафедри
        //System.out.println("please be right");
        //fi.changeChair(ukrLanguageChair, mathChair);
        Array.print(chairs);
        ukrLanguageChair.setStudents(students);
        Array.print(ukrLanguageChair.getStudents());
        ukrLanguageChair.kill(st1);
        Array.print(ukrLanguageChair.getStudents());
        ukrLanguageChair.addStudent(st1).addStudent(st1).addStudent(st3);
        Array.print(ukrLanguageChair.getStudents());
        Sorter.sortName(ukrLanguageChair.getStudents());
        Array.print(ukrLanguageChair.getStudents());

       // System.out.println(ukrLanguageChair);


        System.out.println(NaUKMA);

    }
}
