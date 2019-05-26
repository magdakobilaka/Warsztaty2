public class Exercise {
    private int id;
    private String title;
    private String descryption;

    public Exercise() {
    }

    public Exercise(String title, String descryption) {

        this.title = title;
        this.descryption = descryption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }
}
