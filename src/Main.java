import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn=null;
        PreparedStatement myStamt=null;
        ResultSet myRes=null;

        try {
            myConn= DriverManager.getConnection("jdbc:mysql://localhost:33060/jdbcprueba","root","secret");
            System.out.println("Genial Nos conectamos");


            /** SELECT*/
            /**myRes=myStamt.executeQuery("SELECT * FROM employees");*/
            /**while (myRes.next()){
             System.out.println(myRes.getString("first_name"));
             }*/

            /** PREPARED STATEMENT INSERT */
            String sql=("insert into employees (first_name,pa_surname) values(?,?)");
            myStamt=myConn.prepareStatement(sql);
            myStamt.setString(1,"Johana");
            myStamt.setString(2,"Dorantes");
            int rowsAffected=myStamt.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Se ha creado un nuevo empleado");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ):");
        }
    }
}