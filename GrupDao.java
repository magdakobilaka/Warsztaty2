import java.sql.*;

public class GrupDao {
    private static final String CREATE_GRUP_QUERY =
            "INSERT INTO users_grup(descryption) VALUES (?)";
    private static final String READ_GRUP_QUERY =
            "SELECT * FROM users_grup where id = ?";
    private static final String UPDATE_GRUP_QUERY =
            "UPDATE users_grup SET descryption = ? where id = ?";
    private static final String DELETE_GRUP_QUERY =
            "DELETE FROM users_grup WHERE id = ?";
    private static final String FIND_ALL_GRUPS_QUERY =
            "SELECT * FROM users_grup";


    public Group create(Group group) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GRUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getDescryption());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void find_All() {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_GRUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("users_grup.id");
                String descryotion = resultSet.getString("users_grup.descryotion");

                System.out.println(String.format(
                        "Id: %s, created: %s, descryotion: %s ",
                        id, descryotion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Group read(int grupId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GRUP_QUERY);
            statement.setInt(1, grupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setDescryption(resultSet.getString("descryption"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GRUP_QUERY);
            statement.setString(1, group.getDescryption());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int grupId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GRUP_QUERY);
            statement.setInt(1, grupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


