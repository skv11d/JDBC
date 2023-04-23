import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "skv1d";
    private static final String PASSWORD = "MaX06iSNa";

    public static void main(String[] args) {

        registerDriver();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            statement.execute("""
                    SELECT eci.PhoneNumber, efi.ResidencePlace FROM EmployeesContactsInformation eci
                    INNER JOIN EmployeesFamilyInformation efi ON eci.EmployeeID = efi.EmployeeID;""");

            statement.execute("""
                    SELECT efi.BirthDate, eci.PhoneNumber FROM EmployeesContactsInformation eci
                    INNER JOIN EmployeesFamilyInformation efi ON eci.EmployeeID = efi.EmployeeID
                    WHERE FamilyStatus = "not married";""");

            statement.execute("""
                    SELECT efi.BirthDate, eci.PhoneNumber FROM EmployeesContactsInformation eci
                    INNER JOIN EmployeesFamilyInformation efi ON eci.EmployeeID = efi.EmployeeID
                    INNER JOIN EmployeesProfessionalInformation epi ON eci.EmployeeID = epi.EmployeeID
                    WHERE Position = "manager";""");

            boolean closed = statement.isClosed();
            System.out.println(closed);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert connection != null;
                connection.close();
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}