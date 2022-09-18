package beans;

import java.sql.Date;

/**
 *
 * @author juceb
 */
public class Prueba {
    private int id_area;
    private int username;
    private String titulo_prueba;
    private Date fecha_prueba;
    private int registrados_prueba;  
    private boolean novedad;
    private String genero;

    public Prueba(int id_area, int username, String titulo_prueba, Date fecha_prueba, int registrados_prueba, boolean novedad, String genero) {
        this.id_area = id_area;
        this.username = username;
        this.titulo_prueba = titulo_prueba;
        this.fecha_prueba = fecha_prueba;
        this.registrados_prueba = registrados_prueba;
        this.novedad = novedad;
        this.genero = genero;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
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

    public int getRegistrados_prueba() {
        return registrados_prueba;
    }

    public void setRegistrados_prueba(int registrados_prueba) {
        this.registrados_prueba = registrados_prueba;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Prueba{" + "id_area=" + id_area + ", username=" + username + ", titulo_prueba=" + titulo_prueba + ", fecha_prueba=" + fecha_prueba + ", registrados_prueba=" + registrados_prueba + ", novedad=" + novedad + ", genero=" + genero + '}';
    }
    
}
