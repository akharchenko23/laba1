package NaUKMA;

import Humans.Student;
import Humans.Teacher;

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
     * можна редагувати кафедру
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
     * видаляє кафедру
     * @param victim кафедра яку видалимо
     */
    private void deleteChair(Chair victim) {
        for (int i = 0; i < chairs.length; i++) {
            if (chairs[i].equals(victim)) {
                chairs[i] = null;
            }
        }
        noChairsChanged();
    }

    /**
     * Прибирає усі null із масиву , тим самим зменшуючи його
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
}
