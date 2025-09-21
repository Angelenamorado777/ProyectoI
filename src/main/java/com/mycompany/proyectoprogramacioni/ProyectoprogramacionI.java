package com.mycompany.proyectoprogramacioni;

import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class ProyectoprogramacionI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    final int MAX = 50;
String[] codigos = new String[100];
String[] nombres = new String[100];
double[] precios = new double[100];
int[] cantidades = new int[100];
int numMedicamentos = 0;

int opcionmenu = 0;
String codigo = "";
String nombre = "";
double precio = 0;
int cantidad = 0;
String cliente = "";
int edad = 0;
int venta = 0;
double total = 0;
double totalacumulado = 0;
boolean medicamentoRegistrado = false;

while (opcionmenu != 6) {
System.out.println("SISTEMA FARMACIA");
System.out.println("-------------");
System.out.println("1.Registrar medicamento");
System.out.println("2.Ver el medicamento en el inventario");
System.out.println("3.Vender el medicamento");
System.out.println("4.Ver el total de medicamentos vendidos");
System.out.println("5.Ingresar al submenu para ingresar un nuevo medicamento");
System.out.println("6.Salir del sistema");
System.out.print("Seleccione una de las opciones del 1 al 6: ");

opcionmenu = sc.nextInt();
sc.nextLine();

switch (opcionmenu) {
                case 1:
                    
                    if (numMedicamentos < MAX) {
System.out.print("Codigo: ");
codigo = sc.nextLine();
codigos[numMedicamentos] = codigo;

System.out.print("Nombre: ");
nombre = sc.nextLine();
nombres[numMedicamentos] = nombre;

System.out.print("Precio: ");
precio = sc.nextDouble();
precios[numMedicamentos] = precio;

System.out.print("Cantidad: ");
cantidad = sc.nextInt();
cantidades[numMedicamentos] = cantidad;
sc.nextLine();

numMedicamentos++;
medicamentoRegistrado = true;
System.out.println("Medicamento registrado en el sistema");
} else {
System.out.println("Inventario lleno, no se pueden registrar más medicamentos.");
}
break;

case 2:
System.out.print("Ingrese codigo o nombre: ");
String dato = sc.nextLine();
boolean encontrado = false;
for (int i = 0; i < numMedicamentos; i++) {
if (dato.trim().equalsIgnoreCase(codigos[i]) || dato.trim().equalsIgnoreCase(nombres[i])) {
codigo = codigos[i];
nombre = nombres[i];
precio = precios[i];
cantidad = cantidades[i];

System.out.println("Codigo: " + codigo + " Nombre: " + nombre + " Precio: " + precio + " Cantidad: " + cantidad);
encontrado = true;
break;
}
}
if (!encontrado) {
System.out.println("No existe el nombre del medicamento en el sistema");
}
break;

case 3:
                   
System.out.println("Venta del Medicamento");
System.out.print("Cliente: ");
cliente = sc.nextLine();
System.out.print("Edad: ");
edad = sc.nextInt();
sc.nextLine();
System.out.print("Ingrese codigo o nombre: ");
String buscar = sc.nextLine();
boolean vendido = false;

for (int i = 0; i < numMedicamentos; i++) {
if (buscar.equalsIgnoreCase(codigos[i]) || buscar.equalsIgnoreCase(nombres[i])) {
                           
codigo = codigos[i];
nombre = nombres[i];
precio = precios[i];
cantidad = cantidades[i];

System.out.print("Cantidad a comprar: ");
venta = sc.nextInt();
sc.nextLine();

if (venta <= cantidad && venta > 0) {
total = precio * venta;
if (edad >= 60) total = total * 0.85;
cantidades[i] = cantidades[i] - venta;
cantidad = cantidades[i];
totalacumulado += total;
System.out.println("Medicamento comprado total: " + total);
} else {
System.out.println("Este medicamento no se encuentra en el inventario o la cantidad es incorrecta");
}
vendido = true;
break;
}
}
if (!vendido) {
System.out.println("No se encontró el medicamento");
}
break;

case 4:
System.out.println("Total recaudado: " + totalacumulado);
break;

case 5:
                    
int submenu = 0;
do {
System.out.println("---SUBMENU DE MEDICAMENTOS---");
System.out.println("1. Registrar nuevo medicamento");
System.out.println("2. Modificar precio del medicamento");
System.out.println("3. Cambiar la cantidad del medicamento");
System.out.println("4. Eliminar medicamento");
System.out.println("5. Volver a sistema farmacia");
System.out.print("Seleccione una opcion del 1 al 5: ");

if (sc.hasNextInt()) {
submenu = sc.nextInt();
sc.nextLine();
} else {
System.out.println("Tiene que ingresar un numero entre 1 y 5");
sc.nextLine();
submenu = 0;
continue;
}

switch (submenu) {
case 1:
                               
if (numMedicamentos < MAX) {
System.out.print("Codigo: ");
codigo = sc.nextLine();
codigos[numMedicamentos] = codigo;

System.out.print("Nombre: ");
nombre = sc.nextLine();
nombres[numMedicamentos] = nombre;

System.out.print("Precio: ");
precio = sc.nextDouble();
precios[numMedicamentos] = precio;

System.out.print("Cantidad: ");
cantidad = sc.nextInt();
cantidades[numMedicamentos] = cantidad;
sc.nextLine();

if (precio < 0) {
System.out.println("El precio tiene que ser positivo");
} else {
medicamentoRegistrado = true;
numMedicamentos++;
System.out.println("El medicamento se registro en el sistema");
}
} else {
System.out.println("Inventario lleno.");
}
break;

case 2:
                                
if (numMedicamentos == 0) {
System.out.println("No hay medicamentos en el sistema");
break;
}
System.out.print("Ingrese codigo del medicamento: ");
String codPrecio = sc.nextLine();
boolean modificado = false;
for (int i = 0; i < numMedicamentos; i++) {
if (codPrecio.equalsIgnoreCase(codigos[i])) {
System.out.print("Nuevo precio del medicamento: ");
double nuevoPrecio = sc.nextDouble();
sc.nextLine();
if (nuevoPrecio >= 0) {
precios[i] = nuevoPrecio;
                                          
precio = nuevoPrecio;
System.out.println("Precio del medicamento actualizado");
} else {
System.out.println("El precio del medicamento no tiene que ser negativo");
}
modificado = true;
break;
}
}
if (!modificado) System.out.println("No se encontro el medicamento");
break;

case 3:
                               
if (numMedicamentos == 0) {
System.out.println("No hay ningun medicamento en el sistema");
break;
}
System.out.print("Ingrese codigo del medicamento: ");
String codCant = sc.nextLine();
boolean cambiado = false;
for (int i = 0; i < numMedicamentos; i++) {
if (codCant.equalsIgnoreCase(codigos[i])) {
System.out.print("Cantidad adicional a sumar (usar valor positivo) o nueva cantidad: ");
int nuevaCant = sc.nextInt();
sc.nextLine();
if (nuevaCant >= 0) {
cantidades[i] = nuevaCant;
                                            cantidad = cantidades[i]; 
System.out.println("Cantidad actualizada");
} else {
System.out.println("Debe ingresar un número positivo");
}
cambiado = true;
break;
}
}
if (!cambiado) System.out.println("Medicamento no encontrado");
break;

case 4:
                      
if (numMedicamentos == 0) {
System.out.println("No hay medicamentos para eliminar");
break;
}
System.out.print("Ingrese codigo del medicamento: ");
String codEliminar = sc.nextLine();
boolean eliminado = false;
for (int i = 0; i < numMedicamentos; i++) {
if (codEliminar.equalsIgnoreCase(codigos[i])) {
for (int j = i; j < numMedicamentos - 1; j++) {
codigos[j] = codigos[j + 1];
nombres[j] = nombres[j + 1];
precios[j] = precios[j + 1];
cantidades[j] = cantidades[j + 1];
}
                                        
codigos[numMedicamentos - 1] = null;
nombres[numMedicamentos - 1] = null;
precios[numMedicamentos - 1] = 0;
cantidades[numMedicamentos - 1] = 0;

numMedicamentos--;
eliminado = true;
System.out.println("Medicamento eliminado del sistema");
break;
}
}
if (!eliminado) System.out.println("Medicamento no encontrado");

medicamentoRegistrado = (numMedicamentos > 0);
if (!medicamentoRegistrado) {
codigo = "";
nombre = "";
precio = 0;
cantidad = 0;
}
break;

case 5:
System.out.println("Regresando a sistema farmacia");
break;

default:
System.out.println("Ingrese una opcion del 1 al 5");
}

} while (submenu != 5);
break;

case 6:
System.out.println("Saliendo del sistema");
break;

default:
System.out.println("Opcion no valida");
}

if (opcionmenu != 5) {
System.out.println("\nPresione enter para seguir utilizando el sistema");
sc.nextLine();
}
}

    }//Fin de main
}//Fin de 