public class Group {
    private int id;
    private String descryption;

    public Group() {
    }

    public Group(String descryption) {

        this.descryption = descryption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }
}
