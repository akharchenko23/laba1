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









    public static void main(String[] args) {
        Student[] studentsMathChair, studentsITchair, studentsLiteratureChair, studentsHistoryChair, studentsEconomicsChair;
        Teacher[] teachersMathChair, teachersITchair, teachersLiteratureChair, teachersHistoryChair, teachersEconomicsChair;
        Chair[] chairsFI, chairsFGN, chairsFEN;
        Faculty[] faculties;

        Student st1 = new Student("Кондрашов Тимофій", Sex.MALE, 18, "ІПЗ", 1);
        Student st2 = new Student("Харченко Аліна", Sex.FEMALE, 18, "ІПЗ", 1);
        Student st3 = new Student("Булавіна Дарія", Sex.INTERSEX, 17, "ІПЗ", 1);
        Student st4 = new Student("Сокайло Дмитро", Sex.MALE, 19, "ІПЗ", 2);
        Student st5 = new Student("Бондаренко Олександра", Sex.FEMALE, 20, "ПМ", 2);
        Student st6 = new Student("Мельник Михайло", Sex.MALE, 21, "ПМ", 3);
        Student st7 = new Student("Павленко Віталій", Sex.MALE, 19, "Історія", 1);
        Student st8 = new Student("Лисенко Олександра", Sex.FEMALE, 20, "Історія", 2);
        Student st9 = new Student("Шевченко Іван", Sex.MALE, 22, "Економіка", 4);
        Student st10 = new Student("Петров Максим", Sex.MALE, 20, "Економіка", 2);
        Student st11 = new Student("Іванова Анна", Sex.FEMALE, 19, "Економіка", 1);
        Student st12 = new Student("Сидоренко Олексій", Sex.MALE, 21, "Економіка", 3);
        Student st13 = new Student("Коваленко Марія", Sex.FEMALE, 18, "Маркетинг", 1);
        Student st14 = new Student("Петренко Олег", Sex.MALE, 19, "Маркетинг", 1);
        Student st15 = new Student("Грищенко Анастасія", Sex.FEMALE, 20, "Філологія", 3);
        Student st16 = new Student("Безруков Василь", Sex.MALE, 21, "Філологія", 4);
        Student st17 = new Student("Савченко Софія", Sex.FEMALE, 18, "Філологія", 1);
        Student st18 = new Student("Шевченко Карл", Sex.INTERSEX, 22, "Філологія", 4);

        Teacher t1 = new Teacher("Митник Юрій", Sex.MALE, 55, Position.SENIOR);
        Teacher t2 = new Teacher("Силенко Ілля", Sex.MALE, 25, Position.ASSISTANT);
        Teacher t3 = new Teacher("Глибовець Андрій", Sex.MALE, 45, Position.DEAN);
        Teacher t4 = new Teacher("Пєчкурова Олена", Sex.FEMALE, 45, Position.SENIOR);
        Teacher t5 = new Teacher("Ковальов Олег", Sex.MALE, 40, Position.DEAN);
        Teacher t6 = new Teacher("Попова Марина", Sex.FEMALE, 35, Position.SENIOR);
        Teacher t7 = new Teacher("Михайленко Євгенія", Sex.FEMALE, 30, Position.ASSISTANT);
        Teacher t8 = new Teacher("Козлов Олексій", Sex.MALE, 50, Position.SENIOR);
        Teacher t9 = new Teacher("Іванова Наталія", Sex.FEMALE, 60, Position.DEAN);
        Teacher t10 = new Teacher("Богданов Сергій", Sex.MALE, 55, Position.SENIOR);
        Teacher t11 = new Teacher("Литвиненко Ірина", Sex.FEMALE, 45, Position.SENIOR);
        Teacher t12 = new Teacher("Кравченко Олег", Sex.MALE, 38, Position.ASSISTANT);
        Teacher t13 = new Teacher("Квіт Сергій", Sex.MALE, 60, Position.PRESIDENT);

        studentsMathChair = new Student[]{st1, st2, st4};
        studentsITchair = new Student[]{st5, st6};
        studentsEconomicsChair = new Student[] {st9, st10, st11, st12, st13, st14};
        studentsLiteratureChair = new Student[]{st15, st16, st17, st18};
        studentsHistoryChair = new Student[]{st7, st8};

        teachersMathChair = new Teacher[]{t1, t2, t13};
        teachersITchair = new Teacher[]{t3, t4, t13};
        teachersEconomicsChair = new Teacher[]{t5, t6, t7, t8, t13};
        teachersLiteratureChair = new Teacher[]{t9, t10, t13};
        teachersHistoryChair = new Teacher[]{t11, t12, t13};

        Chair mathChair = new Chair("Кафедра математики", teachersMathChair, studentsMathChair);
        Chair ITChair = new Chair("Кафедра інформатики", teachersITchair, studentsITchair);
        Chair economicsChair = new Chair("Кафедра економіки", teachersEconomicsChair, studentsEconomicsChair);
        Chair literatureChair = new Chair("Кафедра літератури", teachersLiteratureChair, studentsLiteratureChair);
        Chair historyChair = new Chair("Кафедра історії", teachersHistoryChair, studentsHistoryChair);

        chairsFI = new Chair[]{mathChair, ITChair};
        chairsFEN = new Chair[]{economicsChair};
        chairsFGN = new Chair[]{literatureChair, historyChair};

        Faculty fi = new Faculty("ФІ", chairsFI);
        Faculty fen = new Faculty("ФЕН", chairsFEN);
        Faculty fgn = new Faculty("ФГН", chairsFGN);

        faculties = new Faculty[]{fi, fen, fgn};

        University NaUKMA = new University("НаУКМА", faculties);

        System.out.println(NaUKMA);


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
