import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import  java.sql.Statement;
import java.sql.DriverManager;
public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
       insertStudent();
       selectStudent();
      updateStudent();
       deleteStudent();
    }
        static void insertStudent()
        {
            Student student = new Student();
            student.setRollno(scanner.nextInt());
            student.setName(scanner.next());
            student.setEmail(scanner.next());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "");
                Statement st = con.createStatement();
                st.executeUpdate("insert into student values('" + student.getRollno() + "','" + student.getName() + "','" + student.getEmail() + "')");
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        static void selectStudent()
        {
            Student student = new Student();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "");
                Statement st = con.createStatement();
                st.executeQuery("select * from student");
                ResultSet rs = (ResultSet) st.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getString("rollno"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("email"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        static void updateStudent()
        {
            Student student = new Student();
            student.setRollno(scanner.nextInt());
            student.setName(scanner.next());
            student.setEmail(scanner.next());
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "");
                Statement st = con.createStatement();
                st.executeUpdate("update student set name='"+student.getName()+"',email='"+student.getEmail()+"'where rollno='"+student.getRollno()+"'");
                 selectStudent(student.getRollNo());
                }

             catch (Exception e)
        {
                System.out.println(e);
            }
        }
        static void selectStudent(int rollno)
        {
            Student student = new Student();
            int rollNo=scanner.nextInt();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "");
                Statement st = con.createStatement();
                st.executeQuery("select * from student");
                ResultSet rs = (ResultSet) st.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getString("rollno"));
                    System.out.println(rs.getString("name"));
                    System.out.println(rs.getString("email"));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        static void deleteStudent()
        {
            int rollNo=scanner.nextInt();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", "root", "");
                Statement st = con.createStatement();
                int count=st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
                if(count>0){
                    System.out.println("Student Is Deleted From DataBase");
                }
            }

            catch (Exception e)
            {
                System.out.println(e);
            }
        }


    }
