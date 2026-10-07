public class GestorInmobiliario {

    private String nombre;
    private RegistroPropiedad registro; // asociación: referencia al registro

    public GestorInmobiliario(String nombre, RegistroPropiedad registro) {
        this.nombre = nombre;
        this.registro = registro;
    }

    public void solicitarTransferencia(Propiedad p, Propietario nuevoTitular) {

        System.out.println(nombre + " solicita transferir " + p.getDireccion()
                + " a nombre de " + nuevoTitular.getNombreCompleto() + ".");

        boolean exito = registro.transferirInmueble(p, nuevoTitular);

        if (!exito) {
            System.out.println(nombre + " informa al cliente que la operación no pudo concretarse.");
        }
    }
}