package NaUKMA;

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
     * видалення факультету
     * @param victim
     */
    private void deleteFaculty(Faculty victim) {
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].equals(victim)) {
                faculties[i] = null;
            }
        }
        noFacultiesChanged();
    }

    /**
     * Прибирає усі null із масиву , тим самим зменшуючи його
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(name).append('\n');
        for (Faculty faculty : faculties) {
            sb.append(faculty).append("\n");
        }
        return sb.toString();
    }
}
