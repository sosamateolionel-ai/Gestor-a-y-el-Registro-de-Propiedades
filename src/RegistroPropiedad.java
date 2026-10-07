public class RegistroPropiedad {

    public boolean transferirInmueble(Propiedad p, Propietario nuevoTitular) {

        if (p.tieneEmbargo()) {
            System.out.println("Transferencia rechazada: la propiedad en " + p.getDireccion()
                    + " tiene un embargo vigente.");
            return false;
        }

        Propietario anterior = p.getPropietarioActual();

        p.setPropietarioActual(nuevoTitular);

        System.out.println("Transferencia exitosa: " + p.getDireccion() + " pasó de "
                + anterior.getNombreCompleto() + " a " + nuevoTitular.getNombreCompleto() + ".");

        return true;
    }
}