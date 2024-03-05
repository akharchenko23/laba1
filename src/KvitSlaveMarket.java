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

import java.util.StringTokenizer;

import static utils.DataInput.*;

public class KvitSlaveMarket {
    public static void main(String[] args)  {
        /*
          Ініціалізація студентів, викладачів, кафедр, факультетів, університету, всіх об'єктів. заповнення дефолтних масивів
         */
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

    /**
     * Головне меню
     * @param university приймає університет для використання його назви
     */
    private static void welcomeToUniversity(University university)  {
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

    /**
     * Реалізує взаємодію з користувачем з приводу усіх можливих дій із факультетами
     * @param university приймає університет для використання його назви
     */
    private static void facultyWork(University university)  {
        int victim;
        int fate = 0;
        do {
            showcase(university.getFaculties());
            switch (whatToDo("Інформація","Редагувати факультет", "Створити факультет", "Видалити факультет", "Піти звідси")) {
                case 1:
                    System.out.print("Про який факультет бажаєте дізнатись? ");
                    victim = decide(university.getFaculties().length);
                    facultyInfo(university.getFaculties()[victim - 1]);
                    break;
                case 2:
                    System.out.print("Який факультет бажаєте редагувати? ");
                    victim = decide(university.getFaculties().length);
                    chairWork(university.getFaculties()[victim - 1]);
                    break;
                case 3:
                    university.addFaculty(createFaculty());
                    break;
                case 4:
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

    /**
     * Реалізує взаємодію із користувачем, дозволяючи переглянути впорядковані за абеткою списки студентів та викладачів кафедри
     * @param faculty Факультет про який надається інформація
     */
    private static void facultyInfo(Faculty faculty) {
        int fate = 0;
        do {
            switch (whatToDo("Загальний список студентів","Загальний список викладачів", "Піти звідси")) {
                case 1:
                    Array.print(Sorter.sortName(faculty.getStudents()));
                    break;
                case 2:
                    Array.print(Sorter.sortName(faculty.getTeachers()));
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }

    /**
     * Реалізує взаємодію з користувачем з приводу усіх можливих дій із кафедрами
     * @param faculty приймаю кафедру для роботи над нею
     */
    private static void chairWork(Faculty faculty)  {
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

    /**
     * Працює із викладачами та студентами певної кафедри
     * @param chair приймає кафедру і витягає з неї дані студентів та викладачів
     */
    private static void peopleWork(Chair chair) {
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

    /**
     * Виводить інформацію списками студентів за різними критеріями
     * @param chair Кафедра про яку треба щось дізнатись
     */
    private static void chairInfo(Chair chair){
        int course;
        int fate = 0;
        int j;
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
                    System.out.print("Який курс вас цікавить? ");
                    course = decide(4);
                    j = 1;
                    for (int i = 0; i < chair.getStudents().length; i++) {
                        if (chair.getStudents()[i].getCourse() == course) {
                            System.out.println(j + ". " + chair.getStudents()[i]);
                            j++;
                        }
                    }
                    if(j==1) System.out.println("Нікого не знайдено.");
                    break;
                case 5:
                    System.out.print("Який курс вас цікавить? ");
                    course = decide(4);
                    Sorter.sortName(chair.getStudents());
                    j = 1;
                    for (int i = 0; i < chair.getStudents().length; i++) {
                        if (chair.getStudents()[i].getCourse() == course) {
                            System.out.println(j + ". " + chair.getStudents()[i]);
                            j++;
                        }
                    }
                    if(j==1) System.out.println("Нікого не знайдено.");
                    break;
                default:
                    fate = 2;
                    break;
            }
        } while (fate != 2);
    }
    /**
     * Метод для роботи з вчителем, дозволяє змінювати особисту інформацію про вчителя.
     *
     * @param teacher Об'єкт вчителя, з яким потрібно працювати
     */
    private static void teacherWork(Teacher teacher) {
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
    /**
     * Метод для роботи зі студентом, дозволяє змінювати особисту інформацію про студента.
     *
     * @param student Об'єкт студента, з яким потрібно працювати
     */
    private static void studentWork(Student student) {
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
    /**
     * Відображає список кафедр.
     *
     * @param chairs Масив кафедр
     */
    private static void showcase(Chair[] chairs) {
        System.out.println("Наявні кафедри:");
        for (int i = 0; i < chairs.length; i++) {
            System.out.println((i + 1) + ". " + chairs[i].getName());
        }
    }
    /**
     * Відображає список факультетів.
     *
     * @param faculties Масив факультетів
     */
    private static void showcase(Faculty[] faculties) {
        System.out.println("Наявні факультети:");
        for (int i = 0; i < faculties.length; i++) {
            System.out.println((i + 1) + ". " + faculties[i].getName());
        }
    }
    /**
     * Пошук в університеті за ім'ям.
     *
     * @param university Об'єкт університету
     */
    private static void universitySearch(University university) {
        if (whatToDo("Знайти викладача", "Знайти студента") == 1) {
            searchForNames(Sorter.sortName(university.getTeachers()));
        } else {
            searchForStudents(university);
        }
    }

    /**
     * Пошук студентів
     * @param university Університет в якому ведеться пошук людей
     */
    private static void searchForStudents(University university) {
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
    /**
     * Пошук студентів за групою.
     *
     * @param students Масив студентів
     */
    private static void searchForGroup(Student[] students){
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
    /**
     * Пошук студентів за курсом.
     *
     * @param students Масив студентів
     */
    private static void searchForCourse(Student[] students){
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
    /**
     * Пошук за ім'ям в університеті.
     *
     * @param humans Масив об'єктів, які належать до класу Human
     */
    private static void searchForNames(Human[] humans) {
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
        StringTokenizer st;
        for (Human human : humans) {
            st = new StringTokenizer(human.getName());
            while(st.hasMoreTokens()) {
                String name = st.nextToken();
                name = st.nextToken();
                if (name.length() < find.length()) continue;
                name = name.toLowerCase().substring(0, find.length());
                if (find.toLowerCase().equals(name)) {
                    System.out.println(human);
                    notFound = false;
                }
            }
        }
        if (notFound) System.out.println("Нікого");
    }
    /**
     * Інформація про університет.
     *
     * @param university Об'єкт університету
     */
    private static void universityInfo(University university){
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
    /**
     * Питає користувача, що робити, і повертає вибір.
     *
     * @param strings Масив рядків з варіантами дій
     * @return Вибір користувача
     */
    private static int whatToDo(String... strings) {
        int count = strings.length;
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
    /**
     * Створює новий факультет.
     *
     * @return Новий об'єкт факультету
     */
    private static Faculty createFaculty() {
        return new Faculty(getTitle("факультету"), getChairs());
    }
    /**
     * Створює масив кафедр.
     *
     * @return Масив кафедр
     */
    private static Chair[] getChairs() {
        System.out.print("Скільки кафедр буде містити цей факультет?");
        int numOfChairs = decide(Integer.MAX_VALUE);
        Chair[] chairs = new Chair[numOfChairs];
        for (int i = 0; i < numOfChairs; i++) {
            System.out.print("Кафедра " + (i + 1) + ": ");
            chairs[i] = createChair();
        }
        return chairs;
    }
    /**
     * Створює нову кафедру.
     *
     * @return Новий об'єкт кафедри
     */
    private static Chair createChair(){
        return new Chair(getTitle("кафедри"), getTeachers(), getStudents());
    }
    /**
     * Створює масив студентів.
     *
     * @return Масив студентів
     */
    private static Student[] getStudents() {
        System.out.print("Скільки студентів буде належати цій кафедрі?");
        int numOfStudents = decide(Integer.MAX_VALUE);
        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Студент " + (i + 1) + ": ");
            students[i] = createStudent();
        }
        return students;
    }
    /**
     * Створює масив викладачів.
     *
     * @return Масив викладачів
     */
    private static Teacher[] getTeachers(){
        System.out.print("Скільки викладачів буде належати цій кафедрі?");
        int numOfTeachers = decide(Integer.MAX_VALUE);
        Teacher[] teachers = new Teacher[numOfTeachers];
        for (int i = 0; i < numOfTeachers; i++) {
            System.out.print("Викладач " + (i + 1) + ": ");
            teachers[i] = createTeacher();
        }
        return teachers;
    }
    /**
     * Створює нового студента.
     *
     * @return Новий об'єкт студента
     */
    private static Student createStudent() {
        return new Student(getName("студента"), getSex(), getAge(), getTitle("групи"), getCourse());
    }
    /**
     * Створює нового викладача.
     *
     * @return Новий об'єкт викладача
     */
    private static Teacher createTeacher() {
        return new Teacher(getName("викладача"), getSex(), getAge(), getPosition());
    }
    /**
     * Вибір посади викладача.
     *
     * @return Посада викладача
     */
    private static Position getPosition()  {
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
    /**
     * Введення назви.
     *
     * @param owner Рядок, що вказує на тип введення (наприклад, "групи", "факультету" тощо)
     * @return Введена назва
     */
    private static String getTitle(String owner) {
        System.out.print("Введіть назву " + owner + ": ");
        String name;
        do {
            name = getString();
            if (containsNums(name)){
                System.out.print("Назва не має містити числа або знаки! Спробуйте ще раз:");
                name = null;
            }
        } while (name == null);
        return name;
    }
    /**
     * Введення номера курсу.
     *
     * @return Номер курсу
     */
    private static int getCourse(){
        System.out.print("Введіть курс:");
        return decide(4);
    }

    /**
     * Вибір статі.
     *
     * @return Стать
     */
    private static Sex getSex() {
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
    /**
     * Введення віку.
     *
     * @return Вік
     */
    private static int getAge(){
        System.out.print("Введіть вік:");
        return decide(120);
    }
    /**
     * Введення імені.
     *
     * @param owner Рядок, що вказує на тип введення (наприклад, "студента", "викладача" тощо)
     * @return Введене ім'я
     */
    private static String getName(String owner)  {
        System.out.print("Введіть ім'я " + owner + ": ");
        String name;
        do {
            name = getString();
            if (containsNums(name)){
                System.out.print("Ім'я не має містити числа або знаки! Спробуйте ще раз:");
                name = null;
            }
        } while (name == null);
        return name;
    }

    private static boolean containsNums(String name) {
        for(int i = 0; i < name.length(); i++){
            if((name.charAt(i) < 1000 || name.charAt(i) > 1200) && name.charAt(i) != ' '){
                return true;
            }
        }
        return false;
    }
}
