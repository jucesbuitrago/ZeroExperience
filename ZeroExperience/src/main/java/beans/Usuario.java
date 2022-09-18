package beans;
/**
 *
 * @author juceb
 */
public class Usuario {
    private String username;
    private String clave_usuario;
    private String nombre_usuario;
    private String apellidos_usuario;
    private String area_usuario;

    public Usuario(String username, String clave_usuario, String nombre_usuario, String apellidos_usuario, String area_usuario) {
        this.username = username;
        this.clave_usuario = clave_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellidos_usuario = apellidos_usuario;
        this.area_usuario = area_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellidos_usuario() {
        return apellidos_usuario;
    }

    public void setApellidos_usuario(String apellidos_usuario) {
        this.apellidos_usuario = apellidos_usuario;
    }

    public String getArea_usuario() {
        return area_usuario;
    }

    public void setArea_usuario(String area_usuario) {
        this.area_usuario = area_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", clave_usuario=" + clave_usuario + ", nombre_usuario=" + nombre_usuario + ", apellidos_usuario=" + apellidos_usuario + ", area_usuario=" + area_usuario + '}';
    }
   
}