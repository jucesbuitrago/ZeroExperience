package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String clave_usuario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where username = '" + username
                + "' and clave_usuario = '" + clave_usuario + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellidos_usuario = rs.getString("apellidos_usuario");
                String area_usuario = rs.getString("area_usuario");

                Usuario usuario = new Usuario(username, clave_usuario, nombre_usuario, apellidos_usuario, area_usuario);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String register(String username, String clave_usuario, String nombre_usuario, String apellidos_usuario, String area_usuario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + clave_usuario + "', '" + nombre_usuario
                + "', '" + apellidos_usuario + "', '" + area_usuario + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, clave_usuario, nombre_usuario, apellidos_usuario, area_usuario);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String clave_usuario = rs.getString("clave_usuario");
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellidos_usuario = rs.getString("apellidos_usuario");
                String area_usuario = rs.getString("area_usuario");

                Usuario usuario = new Usuario(username, clave_usuario, nombre_usuario, apellidos_usuario, area_usuario);

                return gson.toJson(usuario);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }  

    @Override
    public String modificar(String username, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos,
            String nuevaArea) {   

        DBConnection con = new DBConnection();

        String sql = "Update usuario set clave_usuario = '" + nuevaContrasena +
                "', nombre_usuario = '" + nuevoNombre + "', "
                + "apellidos_usuario = '" + nuevosApellidos + "', area_usuario = '" 
                + nuevaArea + "'";
     
        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }
}
