public class Solution {
    private int id;
    private String created;
    private String updated;
    private int excersise_id;
    private int users_id;

    public Solution() {
    }

    public Solution(int id, String created, String updated, int excersise_id, int users_id) {

        this.created = created;
        this.updated = updated;
        this.excersise_id = excersise_id;
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getExcersise_id() {
        return excersise_id;
    }

    public void setExcersise_id(int excersise_id) {
        this.excersise_id = excersise_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
