package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Prueba;
import connection.DBConnection;

public class PruebaController implements IPruebaController {

    @Override
    public String listarPruebas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, u.username, a.titulo_prueba, a.fecha_prueba, a.resultado_prueba from areas l "
                + "inner join prueba a on l.id = a.id inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> pruebas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");                
                String titulo_prueba = rs.getString("titulo_prueba");               
                Date fecha_prueba = rs.getDate("fecha_prueba");          
                int resultado_prueba = rs.getInt("resultado_prueba");
                
                Prueba prueba = new Prueba(id, username, titulo_prueba, fecha_prueba, resultado_prueba);

                pruebas.add(gson.toJson(prueba));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(pruebas);
    }
}
