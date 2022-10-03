/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import beans.Prueba;
import com.google.gson.Gson;
import connection.DBConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juceb
 */
public class RankingController implements IRankingController{
    
    @Override
    public String listar(boolean ordenar) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM prueba ORDER BY resultado_prueba DESC";

        if (ordenar == true) {
            sql += "";
        }

        List<String> prueba = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String titulo_prueba = rs.getString("titulo_prueba");
                Date fecha_prueba = rs.getDate("fecha_prueba");  
                int resultado_prueba = rs.getInt("resultado_prueba");

                Prueba pruebas = new Prueba(id, username, titulo_prueba, fecha_prueba, resultado_prueba);

                prueba.add(gson.toJson(pruebas));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(prueba);

    }    
}
