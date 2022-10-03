package test;

import beans.Areas;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperacionesBD {

    public static void main(String[] args) {
        listarAreas();
    }

    public static void actualizarAreas(int id, String nombre_area) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE areas SET nombre_area = '" + nombre_area + "'WHERE id = " + id;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarAreas() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM areas";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre_area = rs.getString("nombre_area");
                Double sueldo_area = rs.getDouble("sueldo_area");
                Areas area = new Areas(id,nombre_area,sueldo_area);
                System.out.println(area.toString());
            }
            
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
}
