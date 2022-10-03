package beans;

import java.sql.Date;

/**
 *
 * @author juceb
 */
public class Prueba {
    private int id;
    private String username;
    private String titulo_prueba;
    private Date fecha_prueba;
    private int resultado_prueba;  

    public Prueba(int id, String username, String titulo_prueba, Date fecha_prueba, int resultado_prueba) {
        this.id = id;
        this.username = username;
        this.titulo_prueba = titulo_prueba;
        this.fecha_prueba = fecha_prueba;
        this.resultado_prueba = resultado_prueba;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitulo_prueba() {
        return titulo_prueba;
    }

    public void setTitulo_prueba(String titulo_prueba) {
        this.titulo_prueba = titulo_prueba;
    }

    public Date getFecha_prueba() {
        return fecha_prueba;
    }

    public void setFecha_prueba(Date fecha_prueba) {
        this.fecha_prueba = fecha_prueba;
    }

    public int getResultado_prueba() {
        return resultado_prueba;
    }

    public void setResultado_prueba(int resultado_prueba) {
        this.resultado_prueba = resultado_prueba;
    }

    @Override
    public String toString() {
        return "Prueba{" + "id=" + id + ", username=" + username + ", titulo_prueba=" + titulo_prueba + ", fecha_prueba=" + fecha_prueba + ", resultado_prueba=" + resultado_prueba + '}';
    }  
}
