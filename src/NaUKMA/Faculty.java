package NaUKMA;

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

    //редагувати кафедру


}
