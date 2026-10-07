//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    RegistroPropiedad registro = new RegistroPropiedad();
    GestorInmobiliario gestor = new GestorInmobiliario("Laura Pérez (Martillera)", registro);

    Propietario duenioOriginal1 = new Propietario("25123456", "Carlos Fernández");
    Propietario duenioOriginal2 = new Propietario("27654321", "Marisa López");

    Propietario comprador1 = new Propietario("33111222", "Juan Ramírez");
    Propietario comprador2 = new Propietario("34222333", "Sofía Castro");

    Propiedad casaLibre = new Propiedad("Av. San Martín 1234", 150000.0, "libre", duenioOriginal1);
    Propiedad casaEmbargada = new Propiedad("Calle Belgrano 567", 95000.0, "embargada", duenioOriginal2);

    System.out.println("--- Caso 1: transferencia exitosa ---");
    gestor.solicitarTransferencia(casaLibre, comprador1);

    System.out.println("\n--- Caso 2: transferencia bloqueada por embargo ---");
    gestor.solicitarTransferencia(casaEmbargada, comprador2);

    System.out.println("\n--- Verificación final ---");
    System.out.println(casaLibre.getDireccion() + " ahora pertenece a " + casaLibre.getPropietarioActual().getNombreCompleto());
    System.out.println(casaEmbargada.getDireccion() + " sigue perteneciendo a " + casaEmbargada.getPropietarioActual().getNombreCompleto());
}


