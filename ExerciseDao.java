import java.sql.*;

public class ExerciseDao {


    private static final String CREATE_EXERCISE_QUERY =
            "INSERT INTO excersie(title,descryption) VALUES (?,?)";
    private static final String READ_EXERCISE_QUERY =
            "SELECT * FROM excersie where id = ?";
    private static final String UPDATE_EXERCISE_QUERY =
            "UPDATE excersie SET title=?, descryption = ? where id = ?";
    private static final String DELETE_EXERCISE_QUERY =
            "DELETE FROM excersie WHERE id = ?";
    private static final String FIND_ALL_EXERCISES_QUERY =
            "SELECT * FROM excersie";


    public Exercise create(Exercise excersie) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_EXERCISE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, excersie.getTitle());
            statement.setString(2, excersie.getDescryption());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                excersie.setId(resultSet.getInt(1));
            }
            return excersie;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    public void delete(int id) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_EXERCISE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Exercise read(int excersieId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_EXERCISE_QUERY);
            statement.setInt(1, excersieId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Exercise excersie = new Exercise();
                excersie.setId(resultSet.getInt("id"));
                excersie.setTitle(resultSet.getString("title"));
                excersie.setDescryption(resultSet.getString("descryption"));
                return excersie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Exercise excersie) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_EXERCISE_QUERY);
            statement.setString(1, excersie.getTitle());
            statement.setString(2, excersie.getDescryption());
            statement.setInt(3, excersie.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findall(int excersieId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_EXERCISES_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("excersie.id");
                String title = resultSet.getString("excersie.title");
                String descryption = resultSet.getString("excersie.descryption");

                System.out.println(String.format(
                        "Id: %s, title: %s,  descryption: %s",
                        id, title, descryption));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



