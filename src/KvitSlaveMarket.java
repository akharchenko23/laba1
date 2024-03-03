import Enums.Position;
import Enums.Sex;
import Humans.Student;
import Humans.Teacher;
import NaUKMA.Chair;
import NaUKMA.Faculty;
import NaUKMA.University;

import java.io.IOException;

import static utils.DataInput.*;

public class KvitSlaveMarket {

    Student[] fiStudents, fgnStudents, fenStudents;
    Teacher[] fiTeachers, fgnTeachers, fenTeachers;
    Chair[] mathChair, itChair, economicsChair, literatureChair, ukrainianLanguageChair;
    Faculty[] fi, fgn, fen;


    public static void main(String[] args) {

    }

    private int whatToDo(String ... strings) throws IOException {
        int count = 0;
        for(String string : strings){
           count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Що бажаєте зробити?\n");
        for(int i = 0; i < count; i++){
            sb.append(i+1).append(". ").append(strings[i]).append(";\n");
        }
        System.out.println("Ваш вибір: ");
        return decide(count);
    }

    private University createUniversity() throws IOException {
        return new University(getTitle("університету"), getFaculties());
    }

    private Faculty[] getFaculties() throws IOException {
        System.out.println("Скільки факультетів буде містити цей університет?");
        int numOfFaculties;
        do {
            numOfFaculties = getInt();
        } while (numOfFaculties < 0);
        Faculty[] faculties = new Faculty[numOfFaculties];
        for (int i = 0; i < numOfFaculties; i++) {
            System.out.println("Факультет " + i + ": ");
            faculties[i] = createFaculty();
        }
        return faculties;
    }

    private Faculty createFaculty() throws IOException {
        return new Faculty(getTitle("факультету"), getChairs());
    }

    private Chair[] getChairs() throws IOException {
        System.out.println("Скільки кафедр буде містити цей факультет?");
        int numOfChairs;
        do {
            numOfChairs = getInt();
        } while (numOfChairs < 0);
        Chair[] chairs = new Chair[numOfChairs];
        for (int i = 0; i < numOfChairs; i++) {
            System.out.println("Кафедра " + i + ": ");
            chairs[i] = createChair();
        }
        return chairs;
    }

    private Chair createChair() throws IOException {
        return new Chair(getTitle("кафедри"), getTeachers(), getStudents());
    }

    private Student[] getStudents() throws IOException {
        System.out.println("Скільки студентів буде належати цій кафедрі?");
        int numOfStudents;
        do {
            numOfStudents = getInt();
        } while (numOfStudents < 0);
        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            System.out.println("Студент " + i + ": ");
            students[i] = createStudent();
        }
        return students;
    }

    private Teacher[] getTeachers() throws IOException {
        System.out.println("Скільки викладачів буде належати цій кафедрі?");
        int numOfTeachers;
        do {
            numOfTeachers = getInt();
        } while (numOfTeachers < 0);
        Teacher[] teachers = new Teacher[numOfTeachers];
        for (int i = 0; i < numOfTeachers; i++) {
            System.out.println("Викладач " + i + ": ");
            teachers[i] = createTeacher();
        }
        return teachers;
    }

    private Student createStudent() throws IOException {
        return new Student(getName("студента"), getSex(), getAge(), getTitle("групи"), getCourse());
    }

    private Teacher createTeacher() throws IOException {
        return new Teacher(getName("викладача"), getSex(), getAge(), getPosition());
    }

    private Position getPosition() throws IOException {
        System.out.println("Введіть посаду (1 - асистент, 2 - старший викладач, 3 - декан, 4 - президент): ");
        switch (decide(4)) {
            case 1:
                return Position.ASSISTANT;
            case 2:
                return Position.SENIOR;
            case 3:
                return Position.DEAN;
            default:
                return Position.PRESIDENT;
        }
    }

    private String getTitle(String owner) throws IOException {
        System.out.print("Введіть назву " + owner + ": ");
        String name;
        do {
            name = getString();
        } while (name == null);
        return name;
    }

    private int getCourse() throws IOException {
        System.out.print("Введіть курс:");
        int course;
        do {
            course = getInt();
        } while (course < 1 || course > 4);
        return course;
    }


    private Sex getSex() throws IOException {
        System.out.println("Введіть стать (1 - чоловіча, 2 - жіноча, 3 - інтерсекс): ");
        switch (decide(3)) {
            case 1:
                return Sex.MALE;
            case 2:
                return Sex.FEMALE;
            default:
                return Sex.INTERSEX;
        }
    }

    private int getAge() throws IOException {
        System.out.print("Введіть вік:");
        int age;
        do {
            age = getInt();
        } while (age < 0 || age > 120);
        return age;
    }

    private String getName(String owner) throws IOException {
        System.out.print("Введіть ім'я " + owner + ": ");
        String name;
        do {
            name = getString();
        } while (name == null);
        return name;
    }
}
