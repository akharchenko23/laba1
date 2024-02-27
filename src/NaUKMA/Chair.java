package NaUKMA;

public class Chair {


    public static void main(String[] args) {

        System.out.println(findSomeone("б", studentsArray));

        printArray(killSomeone(studentsArray, "а"));
        System.out.println();
        printArray(addSomeone(teachersArray, "ю"));

    }



    //todo нормальні масиви замість тестових зробити
    public static String[] studentsArray = {"Булавіна Дарія", "Кондрашов Тимофій", "а", "б", "а"};
    public static String[] teachersArray = {"Глибовець Андрій", "Пєчкурова Олена"};

    /**
     *  прибирає людину з бази даних
     * @param array масив, з яким працюємо
     * @param enteredData людина, яку шукаємо
     * @return повертаємо новий масив людей
     */
    public static String[] killSomeone(String[] array, String enteredData) {
        //count рахує кількість входжень пошукового запиту в масив,
        // щоб створити новий масив потрібної розмірності
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == enteredData) {
                count++;
            }
        }
        String[] arrayNew = new String[array.length - count];
        for (int i = 0, k = 0; i < array.length; i++) {

            if (array[i] != enteredData) {
                arrayNew[k] = array[i];

                k++;
            }
        }
//        for (int j=0; j<arrayNew.length; j++){
//            System.out.print(arrayNew[j]+ " ");
//        }
        return arrayNew;

    }

    /**
     * додає людину в базу даних
     * @param array масив, з яким працюватимемо
     * @param someone той, кого додамо
     * @return повертає новий масив людей
     */
    public static String[] addSomeone(String[] array, String someone) {

        String[] arrayNew = new String[array.length + 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            arrayNew[k] = array[i];
            k++;
        }
        arrayNew[array.length] = someone;
//        for (int j=0; j<arrayNew.length; j++){
//            System.out.print(arrayNew[j]+ " ");
//        }
        return arrayNew;

    }

    public static String findSomeone(String someone, String[] array){
        for (int i=0; i<array.length; i++){
            if(array[i] == someone){
                return array[i];
            }
        }
        return "";
    }

    public static void printArray(String[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }

}
