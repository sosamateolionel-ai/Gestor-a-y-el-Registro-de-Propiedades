public class Propiedad {

    private String direccion;
    private double tasacion;
    private String estadoLegal; // "libre" o "embargada"
    private Propietario propietarioActual;

    public Propiedad(String direccion, double tasacion, String estadoLegal, Propietario propietarioActual) {
        this.direccion = direccion;
        this.tasacion = tasacion;
        this.estadoLegal = estadoLegal;
        this.propietarioActual = propietarioActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getTasacion() {
        return tasacion;
    }

    public String getEstadoLegal() {
        return estadoLegal;
    }

    public Propietario getPropietarioActual() {
        return propietarioActual;
    }

    public void setPropietarioActual(Propietario propietarioActual) {
        this.propietarioActual = propietarioActual;
    }

    public boolean tieneEmbargo() {
        return estadoLegal.equals("embargada");
    }
}