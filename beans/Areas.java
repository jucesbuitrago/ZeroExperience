package beans;
/**
 *
 * @author juceb
 */
public class Areas {
    private int id;
    private String nombre_area;
    private Double sueldo_area;

    public Areas(int id, String nombre_area, Double sueldo_area) {
        this.id = id;
        this.nombre_area = nombre_area;
        this.sueldo_area = sueldo_area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public Double getSueldo_area() {
        return sueldo_area;
    }

    public void setSueldo_area(Double sueldo_area) {
        this.sueldo_area = sueldo_area;
    }

    @Override
    public String toString() {
        return "Areas{" + "id=" + id + ", nombre_area=" + nombre_area + ", sueldo_area=" + sueldo_area + '}';
    }
    
    
}
