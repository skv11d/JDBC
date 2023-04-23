import java.sql.*;
import java.util.ArrayList;

public class Test {
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
                    INSERT INTO EmployeesFamilyInformation
                    (EmployeeID, ResidencePlace, BirthDate, FamilyStatus)
                    VALUES
                    (1, "Nykilaev", "20.12.1998", "not married"),
                    (2, "Kiev", "05.05.1978", "married"),
                    (3, "Dnepr", "21.09.1990", "not married")""");

            statement.addBatch("""
                    INSERT INTO EmployeesContactsInformation (FullName, PhoneNumber) 
                    VALUES ("Іванов Владимир Іванович", "+380592574611")""");

            statement.addBatch("""
                    INSERT INTO EmployeesContactsInformation  (FullName, PhoneNumber)
                    VALUES ("Петров Іван Петрович", "+380980829411")""");

            statement.addBatch("""
                    INSERT INTO EmployeesContactsInformation  (FullName, PhoneNumber) 
                    VALUES ("Горбачов Петр Олегович", "+380963317566")""");

            statement.executeBatch();

            ArrayList<Employee> employees = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM EmployeesProfessionalInformation");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int salary = resultSet.getInt("Salary");
                String position = resultSet.getString("Position");

                Employee employee = new Employee(id, salary, position);

                employees.add(employee);
            }

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
