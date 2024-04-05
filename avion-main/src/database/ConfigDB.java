package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static Connection openConnection() {

        try {
            //Llamamos al driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos las variables de conexión
            String url = "jdbc:mysql://b3utjxmnweinhk5k8gm5-mysql.services.clever-cloud.com/b3utjxmnweinhk5k8gm5";
            String user = "ude14x53yx2e1btd";
            String password = "xu5V3SVjwOpA4bCRbAxx";

            //Establecer conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecte perfectamente");
/*            Statement sentencia = objConnection.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM tutabla");

            while (resultado.next()){
                System.out.println(resultado.getString("nombreColumna"));
            }

            resultado.close();
            sentencia.close();
            objConnection.close();*/

        } catch (ClassNotFoundException error) {
            System.out.println("ERROR >> Driver no instalado" + error.getMessage());
        } catch (SQLException error) {
            System.out.println("ERROR >> al conectar con la base de datos" + error.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection() {

        try {
            //Si hay una conexión activa entonces la cierra
            if (objConnection != null) objConnection.close();
        } catch (SQLException error) {
            System.out.println("Error" + error.getMessage());
        }


    }
}