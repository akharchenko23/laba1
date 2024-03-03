import Enums.Position;
import Enums.Sex;
import Humans.Human;
import Humans.Student;
import Humans.Teacher;
import NaUKMA.Chair;
import NaUKMA.Faculty;
import NaUKMA.University;
import utils.Array;
import utils.Sorter;

import java.io.IOException;

import static utils.DataInput.*;

public class KvitSlaveMarket {
    public static void main(String[] args) throws IOException {
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

        studentsMathChair = new Student[]{st5, st6};
        studentsITchair = new Student[]{st1, st2, st3, st4};
        studentsEconomicsChair = new Student[]{st9, st10, st11, st12, st13, st14};
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

        Faculty fi = new Faculty("Факультет Інформатики", chairsFI);
        Faculty fen = new Faculty("Факультет економічних наук", chairsFEN);
        Faculty fgn = new Faculty("Факультет гуманітарних наук", chairsFGN);

        faculties = new Faculty[]{fi, fen, fgn};

        University NaUKMA = new University("НаУКМА", faculties);

        welcomeToUniversity(NaUKMA);
        System.out.println("Гарного вам дня!");
    }


    private static void welcomeToUniversity(University university) throws IOException {
        int fate = 0;
        do {
            System.out.println("Ласкаво просимо до університету " + university.getName() + "!");
            switch (whatToDo("Інформація", "Пошук по універу", "Робота з факультетами", "Завершити роботу")) {
                case 1:
                    universityInfo(university);
                    break;
                case 2:
                    universitySearch(university);
                    break;
                case 3:
                    facultyWork(university);
                    break;
                default:
                    fate = 2;
                    break;

            }
        } while (fate != 2);
    }

    private static void facultyWork(University university) throws IOException {
        int victim;
        int fate = 0;
        do {
            showcase(university.getFaculties());
            switch (whatToDo("Редагувати факультет", "Створити факультет", "Видалити факультет", "Піти звідси")) {
                case 1:
                    System.out.print("Який факультет бажаєте редагувати? ");
                    victim = decide(university.getFaculties().length);
                    chairWork(university.getFaculties()[victim - 1]);
                    break;
                case 2:
                    university.addFaculty(createFaculty());
                    break;
                case 3:
                    System.out.print("Який факультет бажаєте видалити? (Всіх студентів буде відраховано, а викладачів звільнено): ");
                    victim = decide(university.getFaculties().length);
                    university.deleteFaculty(university.getFaculties()[victim - 1]);
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void chairWork(Faculty faculty) throws IOException {
        int fate = 0;
        int victim;
        do {
            showcase(faculty.getChairs());
            switch (whatToDo("Перейменувати факультет", "Редагувати кафедру", "Створити кафедру", "Видалити кафедру", "Піти звідси")) {
                case 1:
                    faculty.setName(getTitle("факультету"));
                    break;
                case 2:
                    System.out.print("Який факультет бажаєте редагувати? ");
                    victim = decide(faculty.getChairs().length);
                    peopleWork(faculty.getChairs()[victim - 1]);
                    break;
                case 3:
                    faculty.addChair(createChair());
                    break;
                case 4:
                    System.out.print("Яку кафедру бажаєте видалити? (Всіх студентів буде відраховано, а викладачів звільнено): ");
                    victim = decide(faculty.getChairs().length);
                    faculty.deleteChair(faculty.getChairs()[victim - 1]);
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void peopleWork(Chair chair) throws IOException {
        int victim;
        int fate = 0;
        do {
            System.out.println(chair);
            switch (whatToDo("Перейменувати кафедру", "Редагувати студента", "Редагувати викладача", "Зарахувати студента", "Найняти викладача", "Відрахувати студента", "Звільнити викладача", "Інформація", "Піти звідси")) {
                case 1:
                    chair.setName(getTitle("кафедри"));
                    break;
                case 2:
                    System.out.print("Якого студента бажаєте редагувати? ");
                    victim = decide(chair.getStudents().length);
                    studentWork(chair.getStudents()[victim - 1]);
                    break;
                case 3:
                    System.out.print("Якого викладача бажаєте редагувати? ");
                    victim = decide(chair.getTeachers().length);
                    teacherWork(chair.getTeachers()[victim - 1]);
                    break;
                case 4:
                    chair.enslaveMoreStudents(createStudent());
                    break;
                case 5:
                    chair.enslaveMoreTeachers(createTeacher());
                    break;
                case 6:
                    System.out.print("Якого студента бажаєте відрахувати? ");
                    victim = decide(chair.getStudents().length);
                    chair.kill(chair.getStudents()[victim - 1]);
                    break;
                case 7:
                    System.out.print("Якого викладача бажаєте звільнити? ");
                    victim = decide(chair.getTeachers().length);
                    chair.kill(chair.getTeachers()[victim - 1]);
                    break;
                case 8:
                    chairInfo(chair);
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void chairInfo(Chair chair) throws IOException {
        int course;
        int fate = 0;
        do {
            switch (whatToDo("Список студентів за курсами", "Загальний список студентів", "Загальний список викладачів", "Знайти студентів за курсом", "Знайти студентів за курсом та посортувати за іменем", "Піти звідси")) {
                case 1:
                    Sorter.sortCourse(chair.getStudents());
                    Array.print(chair.getStudents());
                    break;
                case 2:
                    Sorter.sortName(chair.getStudents());
                    Array.print(chair.getStudents());
                    break;
                case 3:
                    Sorter.sortName(chair.getTeachers());
                    Array.print(chair.getTeachers());
                    break;
                case 4:
                    System.out.println("Який курс вас цікавить? ");
                    course = decide(4);
                    for (int i = 0, j = 1; i < chair.getStudents().length; i++) {
                        if (chair.getStudents()[i].getCourse() == course) {
                            System.out.println(j + ". " + chair.getStudents()[i]);
                            j++;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Який курс вас цікавить? ");
                    course = decide(4);
                    Sorter.sortName(chair.getStudents());
                    for (int i = 0, j = 1; i < chair.getStudents().length; i++) {
                        if (chair.getStudents()[i].getCourse() == course) {
                            System.out.println(j + ". " + chair.getStudents()[i]);
                            j++;
                        }
                    }
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void teacherWork(Teacher teacher) throws IOException {
        int fate = 0;
        do {
            System.out.println(teacher);
            switch (whatToDo("Змінити ім'я", "Змінити вік", "Змінити стать", "Змінити посаду", "піти звідси")) {
                case 1:
                    teacher.setName(getName("викладача"));
                    break;
                case 2:
                    teacher.setAge(getAge());
                    break;
                case 3:
                    teacher.setSex(getSex());
                    break;
                case 4:
                    teacher.setPosition(getPosition());
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void studentWork(Student student) throws IOException {
        int fate = 0;
        do {
            System.out.println(student);
            switch (whatToDo("Змінити ім'я", "Змінити вік", "Змінити стать", "Змінити групу", "Змінити курс", "Піти звідси")) {
                case 1:
                    student.setName(getName("студента"));
                    break;
                case 2:
                    student.setAge(getAge());
                    break;
                case 3:
                    student.setSex(getSex());
                    break;
                case 4:
                    student.setGroup(getTitle("групи"));
                case 5:
                    student.setCourse(getCourse());
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void showcase(Chair[] chairs) {
        System.out.println("Наявні кафедри:");
        for (int i = 0; i < chairs.length; i++) {
            System.out.println((i + 1) + ". " + chairs[i].getName());
        }
    }

    private static void showcase(Faculty[] faculties) {
        System.out.println("Наявні факультети:");
        for (int i = 0; i < faculties.length; i++) {
            System.out.println((i + 1) + ". " + faculties[i].getName());
        }
    }

    private static void universitySearch(University university) throws IOException {
        if (whatToDo("Знайти викладача", "Знайти студента") == 1) {
            searchForNames(Sorter.sortName(university.getTeachers()));
        } else {
            searchForStudents(university);
        }
    }

    private static void searchForStudents(University university) throws IOException {
        int fate = 0;
        do {
            switch (whatToDo("Шукати за ім'ям", "Шукати за курсом", "Шукати за спеціальністю", "Піти звідси")) {
                case 1:
                    searchForNames(Sorter.sortName(university.getStudents()));
                    break;
                case 2:
                    searchForCourse(university.getStudents());
                    break;
                case 3:
                    searchForGroup(university.getStudents());
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    private static void searchForGroup(Student[] students) throws IOException {
        System.out.print("Введіть групу: ");
        String find;
        boolean notFound = true;
        do {
            find = getString();
        } while (find.isEmpty());
        System.out.println("Було знайдено: ");
        for (Student student : students) {
            if (student.getGroup().length() < find.length()) continue;
            String group = student.getGroup().toLowerCase().substring(0, find.length());
            if (find.toLowerCase().equals(group)) {
                System.out.println(student);
                notFound = false;
            }
        }
        if (notFound) System.out.println("Нікого");
    }

    private static void searchForCourse(Student[] students) throws IOException {
        Sorter.sortName(students);
        System.out.print("Введіть курс: ");
        int find;
        boolean notFound = true;
        find = decide(4);
        System.out.println("Було знайдено: ");
        for (Student student : students) {
            int course = student.getCourse();
            if (find == course) {
                System.out.println(student);
                notFound = false;
            }
        }
        if (notFound) System.out.println("Нікого");
    }

    private static void searchForNames(Human[] humans) throws IOException {
        System.out.print("Введіть ім'я: ");
        String find;
        boolean notFound = true;
        do {
            find = getString();
            if (find.isEmpty()) System.out.println("Ім'я має містити хоча б одну літеру: ");
        } while (find.isEmpty());
        System.out.println("Було знайдено: ");
        for (Human human : humans) {
            if (human.getName().length() < find.length()) continue;
            String name = human.getName().toLowerCase().substring(0, find.length());
            if (find.toLowerCase().equals(name)) {
                System.out.println(human);
                notFound = false;
            }
        }
        if (notFound) System.out.println("Нікого");
    }

    private static void universityInfo(University university) throws IOException {
        int fate = 0;
        do {
            switch (whatToDo("Загальний виклад університету", "Список студентів за курсами", "Загальний список студентів", "Загальний список викладачів", "Піти звідси")) {
                case 1:
                    System.out.println(university);
                    break;
                case 2:
                    Array.print(Sorter.sortCourse(university.getStudents()));
                    break;
                case 3:
                    Array.print(Sorter.sortName(university.getStudents()));
                    break;
                case 4:
                    Array.print(Sorter.sortName(university.getTeachers()));
                    break;
                default:
                    fate = 2;
                    break;
            }
        }while(fate != 2);
    }

    private static int whatToDo(String... strings) throws IOException {
        int count = 0;
        for (String string : strings) {
            count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nЩо бажаєте зробити?\n");
        for (int i = 0; i < count; i++) {
            sb.append(i + 1).append(". ").append(strings[i]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        System.out.print("\nВаш вибір: ");
        return decide(count);
    }

    private University createUniversity() throws IOException {
        return new University(getTitle("університету"), getFaculties());
    }

    private Faculty[] getFaculties() throws IOException {
        System.out.print("Скільки факультетів буде містити цей університет?");
        int numOfFaculties = decide(Integer.MAX_VALUE);
        Faculty[] faculties = new Faculty[numOfFaculties];
        for (int i = 0; i < numOfFaculties; i++) {
            System.out.print("Факультет " + (i + 1) + ": ");
            faculties[i] = createFaculty();
        }
        return faculties;
    }

    private static Faculty createFaculty() throws IOException {
        return new Faculty(getTitle("факультету"), getChairs());
    }

    private static Chair[] getChairs() throws IOException {
        System.out.print("Скільки кафедр буде містити цей факультет?");
        int numOfChairs = decide(Integer.MAX_VALUE);
        Chair[] chairs = new Chair[numOfChairs];
        for (int i = 0; i < numOfChairs; i++) {
            System.out.print("Кафедра " + (i + 1) + ": ");
            chairs[i] = createChair();
        }
        return chairs;
    }

    private static Chair createChair() throws IOException {
        return new Chair(getTitle("кафедри"), getTeachers(), getStudents());
    }

    private static Student[] getStudents() throws IOException {
        System.out.print("Скільки студентів буде належати цій кафедрі?");
        int numOfStudents = decide(Integer.MAX_VALUE);
        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Студент " + (i + 1) + ": ");
            students[i] = createStudent();
        }
        return students;
    }

    private static Teacher[] getTeachers() throws IOException {
        System.out.print("Скільки викладачів буде належати цій кафедрі?");
        int numOfTeachers = decide(Integer.MAX_VALUE);
        Teacher[] teachers = new Teacher[numOfTeachers];
        for (int i = 0; i < numOfTeachers; i++) {
            System.out.print("Викладач " + (i + 1) + ": ");
            teachers[i] = createTeacher();
        }
        return teachers;
    }

    private static Student createStudent() throws IOException {
        return new Student(getName("студента"), getSex(), getAge(), getTitle("групи"), getCourse());
    }

    private static Teacher createTeacher() throws IOException {
        return new Teacher(getName("викладача"), getSex(), getAge(), getPosition());
    }

    private static Position getPosition() throws IOException {
        System.out.print("Введіть посаду (1 - асистент, 2 - старший викладач, 3 - декан, 4 - президент): ");
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

    private static String getTitle(String owner) throws IOException {
        System.out.print("Введіть назву " + owner + ": ");
        String name;
        do {
            name = getString();
        } while (name == null);
        return name;
    }

    private static int getCourse() throws IOException {
        System.out.print("Введіть курс:");
        return decide(4);
    }


    private static Sex getSex() throws IOException {
        System.out.print("Введіть стать (1 - чоловіча, 2 - жіноча, 3 - інтерсекс): ");
        switch (decide(3)) {
            case 1:
                return Sex.MALE;
            case 2:
                return Sex.FEMALE;
            default:
                return Sex.INTERSEX;
        }
    }

    private static int getAge() throws IOException {
        System.out.print("Введіть вік:");
        return decide(120);
    }

    private static String getName(String owner) throws IOException {
        System.out.print("Введіть ім'я " + owner + ": ");
        String name;
        do {
            name = getString();
        } while (name == null);
        return name;
    }
}
