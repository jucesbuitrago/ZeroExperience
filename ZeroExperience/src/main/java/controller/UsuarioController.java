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

    /*@Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");
                boolean premium = rs.getBoolean("premium");

                Usuario usuario = new Usuario(username, contrasena,
                        nombre, apellidos, email, saldo, premium);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }*/
}
