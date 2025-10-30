import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee employee){
        String sql= "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDesignation());
            ps.setDouble(3,employee.getSalary());
            ps.executeUpdate();
            System.out.println("Employee added Successfully");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try ( Connection connection = DBConnection.getConnection();
              Statement statement = connection.createStatement();
              ResultSet resultSet= statement.executeQuery(sql)){
            while (resultSet.next()){
                Employee emp = new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("designation"),
                        resultSet.getDouble("salary")

                );

                list.add(emp);
        }
    } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    public void updateEmployee(int id, double newSalary){
        String sql= "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps= connection.prepareStatement(sql)){

            ps.setDouble(1,newSalary);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Salary updated successfully");
        } catch (SQLException e){
            e.printStackTrace();


        }
    }

    public void deleteEmployee(int id){
        String sql= "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();

            System.out.println("Employee deleted successfully");
        } catch (SQLException e){
            e.printStackTrace();

        }
    }


}
