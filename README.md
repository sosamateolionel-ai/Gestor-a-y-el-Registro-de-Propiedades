# Sistema de Transferencia de Propiedades

## Descripción

Este proyecto simula un sistema de transferencia de propiedades inmobiliarias utilizando **Programación Orientada a Objetos en Java**.

El sistema permite que un gestor inmobiliario solicite la transferencia de una propiedad a un nuevo propietario. Antes de realizar la transferencia, se verifica el estado legal de la propiedad para determinar si posee un embargo.

## Funcionamiento

El programa crea:

* Un `RegistroPropiedad`.
* Un `GestorInmobiliario`.
* Propietarios originales.
* Compradores.
* Dos propiedades.

Se realizan dos operaciones:

1. **Transferencia exitosa:** una propiedad con estado legal `libre` cambia de propietario.
2. **Transferencia rechazada:** una propiedad con estado `embargada` no puede ser transferida.

Finalmente, se verifica quién es el propietario actual de cada propiedad.

## Clase `Propietario`

Representa a una persona que puede ser propietaria de un inmueble.

### Atributos

* `dni`: documento del propietario.
* `nombreCompleto`: nombre completo.

Los atributos están encapsulados utilizando `private`.

### Métodos

* `getDni()`: obtiene el DNI.
* `getNombreCompleto()`: obtiene el nombre del propietario.

## Clase `Propiedad`

Representa un inmueble que puede ser transferido.

### Atributos

* `direccion`: dirección del inmueble.
* `tasacion`: valor de la propiedad.
* `estadoLegal`: indica si está `libre` o `embargada`.
* `propietarioActual`: propietario actual del inmueble.

### Métodos principales

#### `tieneEmbargo()`

Comprueba si la propiedad tiene un embargo vigente.

```java
public boolean tieneEmbargo()
```

Devuelve `true` cuando el estado legal es `embargada`.

#### `setPropietarioActual()`

Permite modificar el propietario actual cuando una transferencia es aprobada.

## Clase `RegistroPropiedad`

Representa el registro encargado de realizar legalmente la transferencia.

### `transferirInmueble()`

Recibe una propiedad y un nuevo propietario.

Primero verifica si la propiedad tiene un embargo:

```java
if (p.tieneEmbargo()) {
    // Transferencia rechazada
}
```

Si existe un embargo, la operación se rechaza.

Si la propiedad está libre:

1. Se obtiene el propietario anterior.
2. Se establece el nuevo propietario.
3. Se informa que la transferencia fue exitosa.
4. El método devuelve `true`.

## Clase `GestorInmobiliario`

Representa al gestor que solicita la transferencia en nombre del cliente.

### Atributos

* `nombre`: nombre del gestor.
* `registro`: referencia al `RegistroPropiedad`.

Esta referencia representa una **asociación entre clases**.

### `solicitarTransferencia()`

El gestor solicita al registro que realice la transferencia.

El método recibe:

* La propiedad.
* El nuevo propietario.

Luego llama a:

```java
registro.transferirInmueble(p, nuevoTitular);
```

Si la operación falla, informa al cliente que la transferencia no pudo realizarse.

## Ejemplo del programa

### Caso 1: transferencia exitosa

La propiedad:

```text
Av. San Martín 1234
Estado: libre
Propietario: Carlos Fernández
```

Se intenta transferir a:

```text
Juan Ramírez
```

La transferencia se realiza correctamente y la propiedad pasa a pertenecer a Juan Ramírez.

### Caso 2: transferencia bloqueada

La propiedad:

```text
Calle Belgrano 567
Estado: embargada
Propietario: Marisa López
```

Se intenta transferir a:

```text
Sofía Castro
```

La operación es rechazada debido al embargo.

## Resultado final

Al finalizar el programa se verifica que:

```text
Av. San Martín 1234 ahora pertenece a Juan Ramírez
Calle Belgrano 567 sigue perteneciendo a Marisa López
```

Esto demuestra que solamente se modifica el propietario cuando la transferencia cumple con las condiciones establecidas.

## Relación entre las clases

```text
GestorInmobiliario
        │
        │ solicita
        ▼
RegistroPropiedad
        │
        │ verifica y modifica
        ▼
     Propiedad
        │
        │ tiene
        ▼
   Propietario
```

El `GestorInmobiliario` mantiene una referencia al `RegistroPropiedad`, mientras que cada `Propiedad` mantiene una referencia a su `Propietario` actual.

## Conceptos utilizados

* Programación Orientada a Objetos.
* Clases y objetos.
* Constructores.
* Encapsulamiento.
* Atributos privados.
* Getters y setters.
* Asociación entre clases.
* Referencias a objetos.
* Métodos que reciben objetos como parámetros.
* Valores booleanos.
* Condicionales `if`.
* Validación de condiciones.
* Retorno de valores `boolean`.
* Cambio de estado de un objeto.

## Ejecución

<img width="927" height="412" alt="image" src="https://github.com/user-attachments/assets/86fb8d7a-7beb-4aa7-b4fc-4d655f84ea3c" />
