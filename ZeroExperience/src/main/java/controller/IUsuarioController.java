package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String clave_usuario);

    public String register(String username, String clave_usuario, 
            String nombre_usuario, String apellidos_usuario, String area_usuario);

    /*public String pedir(String username);*/
}

