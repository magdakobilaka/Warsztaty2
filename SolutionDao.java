import java.sql.*;

public class SolutionDao {


    private static final String CREATE_SOLUTION_QUERY =
            "INSERT INTO solution(created,updated,excersise_id,users_id) VALUES (?,?,?,?)";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET created=?, updated = ?,excersise_id=?,c=? where id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_SOLUTIONS_QUERY =
            "SELECT*FROM warsztat.solution;";
    private static final String FIND_ALL_BY_USERID =
            "SELECT users.id, users.username ,excersie.id, excersie.title  FROM warsztat.excersie join warsztat.solution on solution.excersise_id = excersie.id\n" +
                    "join warsztat.users on users.id = solution.users_id where users.id =?;";
    private static final String FIND_ALL_BY_EXCERSID =
            "SELECT solution.created,excersie.title, excersie.descryption,solution.users_id  FROM warsztat.excersie join warsztat.solution on solution.excersise_id = excersie.id\n" +
                    "order by created ASC;";


    public Solution create(Solution solution) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setInt(3, solution.getExcersise_id());
            statement.setInt(4, solution.getUsers_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution read(int solutionId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setExcersise_id(resultSet.getInt("excersise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solution solution) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setInt(3, solution.getExcersise_id());
            statement.setInt(4, solution.getUsers_id());
            statement.setInt(5, solution.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int solutionId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void findAllByUserId(int userId) {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_USERID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userid = resultSet.getInt("users.id");
                String name = resultSet.getString("users.username");
                int excersieid = resultSet.getInt("excersie.id");
                String title = resultSet.getString("excersie.title ");
                System.out.println(String.format(
                        "userId: %s, username: %s, excersiseID: %s, title: %s ", userId, name, excersieid, title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void findall() {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_BY_EXCERSID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("solution.id");
                String created = resultSet.getString("solution.created");
                String updated = resultSet.getString("solution.updated");
                int excersie_id = resultSet.getInt("solution");
                int users_id = resultSet.getInt("solution.users_id ");
                System.out.println(String.format(
                        "Id: %s, created: %s,  updated: %s, excersie_id: %s, users_id: %s ",
                        id, created, updated, excersie_id, users_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void findsolutionquery() {
        try (Connection conn = ConnetionUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String created = resultSet.getString("solution.created");
                String title = resultSet.getString("excersie.title");
                String descryption = resultSet.getString("excersie.descryption");
                int users_id = resultSet.getInt("solution.users_id ");
                System.out.println(String.format(
                        "created: %s, title: %s, descryption: %s, users_id: %s ", created, title, descryption, users_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




