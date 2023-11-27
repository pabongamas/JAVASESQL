import javax.xml.stream.events.StartDocument;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn=null;
        PreparedStatement myStamt=null;
        Statement myStamtNormal=null;
        ResultSet myRes=null;

        try {
            myConn= DriverManager.getConnection("jdbc:mysql://localhost:33060/jdbcprueba","root","secret");
            System.out.println("Genial Nos conectamos");

//            conectarse por postgres
//            myConn= DriverManager.getConnection("jdbc:postgresql://192.168.1.102:5432/dbdemo62","signo","pr4y2ct4s3gn4");
//            System.out.println("Genial Nos conectamos");
//
//
//            /** SELECT*/
//            myStamtNormal=myConn.createStatement();
//            myRes=myStamtNormal.executeQuery("SELECT * FROM persona limit 10");
//            while (myRes.next()){
//                System.out.println(myRes.getString("nombre_usuario")+" "+myRes.getString("apellidos_usuario"));
//            }


            /** SELECT*/
            /**myRes=myStamt.executeQuery("SELECT * FROM employees");*/
            /**while (myRes.next()){
             System.out.println(myRes.getString("first_name"));
             }*/


            /** PREPARED STATEMENT INSERT */
//            String sql=("insert into employees (first_name,pa_surname) values(?,?)");
//            myStamt=myConn.prepareStatement(sql);
//            myStamt.setString(1,"Johana");
//            myStamt.setString(2,"Dorantes");
//            int rowsAffected=myStamt.executeUpdate();
//            if(rowsAffected>0){
//                System.out.println("Se ha creado un nuevo empleado");
//            }

            /*
            actualizar
            * */
            myStamtNormal=myConn.createStatement();
            int rowsAffected=myStamtNormal.executeUpdate("UPDATE employees set email='johana2@example.com' WHERE first_name='Johana'");

            myRes=myStamtNormal.executeQuery("SELECT * FROM employees order by pa_surname");

            while(myRes.next()){
                System.out.println(myRes.getString("first_name")+","+myRes.getString("email"));
            }

            /*
            * eliminar*/
            myStamtNormal=myConn.createStatement();
            int rowsAffectedByDelete=myStamtNormal.executeUpdate("DElETE FROM employees WHERE email='john.doe@example.com'");

            System.out.println("Se ha eliminado existosamente "+rowsAffectedByDelete+" registro");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Algo salio mal ):");
        }
    }
}