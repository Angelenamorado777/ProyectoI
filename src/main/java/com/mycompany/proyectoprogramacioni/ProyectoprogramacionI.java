/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectoprogramacioni;

import java.util.Scanner;

/**
 *
 * @author Angel
 */

public class ProyectoprogramacionI {

public static void main(String[] args) {
   Scanner sc = new Scanner (System.in);
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
    
    while(opcionmenu != 6){
      System.out.println("SISTEMA FARMACIA");
      System.out.println("-------------");
      System.out.println("1.Registrar medicamento");
      System.out.println("2.Ver el medicamento en el inventario");
      System.out.println("3.Vender el medicamento");
      System.out.println("4.Ver el total de medicamentos vendidos");
      System.out.println("5.Ingresar al submenu para ingresar un nuevo medicamento");
      System.out.println("6.Salir del sistema");
      System.out.print("Seleccione una de las opciones del 1 al 6: ");
     
      opcionmenu  = sc.nextInt();
      sc.nextLine(); 

      switch(opcionmenu){
       case 1:
          System.out.print("Codigo: ");
          codigo = sc.nextLine();
          System.out.print("Nombre: "); 
          nombre = sc.nextLine();
          System.out.print("Precio: "); 
          precio = sc.nextDouble();
          System.out.print("Cantidad: "); 
          cantidad = sc.nextInt(); 
          sc.nextLine();
          System.out.println("Medicamento registrado en el sistema");
          break;

       case 2:
          System.out.print("Ingrese codigo o nombre: "); 
          String dato = sc.nextLine();
          if
            (dato.trim().equalsIgnoreCase(codigo) || dato.trim().equalsIgnoreCase(nombre))
            System.out.println("Codigo: " + codigo + "Nombre: " + nombre + " Precio: " + precio + " Cantidad: " + cantidad);
          else
            System.out.println("No existe el nombre del medicamento en el sistema");
          break;

       case 3:
          System.out.println("Venta del Medicamento");
          System.out.print("Cliente: "); 
          cliente = sc.nextLine();
          System.out.print("Edad: "); 
          edad = sc.nextInt(); sc.nextLine();
          System.out.print("Cantidad a comprar: ");
          venta = sc.nextInt(); 
          sc.nextLine();
          
        if(venta <= cantidad){
        total = precio * venta;
        if(edad >= 60) total = total * 0.85;
        cantidad = cantidad - venta;
        totalacumulado += total;
        System.out.println("Medicamento comprado total: "+total);
         }else
        System.out.println("Este medicamento no se encuentra en el inventario");
          break;

        case 4:
          System.out.println("Total recaudado: "+totalacumulado);
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
        System.out.print("Seleccione una opcion del 1 al 5 ");

        if (sc.hasNextInt()) {
            submenu = sc.nextInt();
            sc.nextLine(); 
        } else {
            System.out.println("Tiene que ingresar un nuero entre 1 y 5");
            sc.nextLine(); 
            submenu = 0; 
            continue;
        }

        switch (submenu) {
            case 1:
        System.out.print("Codigo: ");
        codigo = sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Precio: ");
        precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        cantidad = sc.nextInt();
         sc.nextLine();
        if (precio < 0) {
        System.out.println("El precio tiene que ser positivo");
        } else {
        medicamentoRegistrado = true;
        System.out.println("El medicamento se registro en el sistema");
        }
         break;

        case 2:
         if (medicamentoRegistrado) {
         System.out.print("Nuevo precio del medicamento: ");
         precio = sc.nextDouble();
         sc.nextLine();
          if (precio >= 0) {
          System.out.println("Precio del medicamento actualizado");
          } else {
          System.out.println("El precio del medicamento no tiene que ser negativo");
          }
          } else {
          System.out.println("No se encontro el medicamento");
           }
          break;
          case 3:
          if (medicamentoRegistrado) {
          System.out.print("Cantidad del medicamento: ");
          int extra = sc.nextInt();
          sc.nextLine();
          if (extra > 0) {
          cantidad += extra;
          System.out.println("Ingrese una nueva cantidad: " + cantidad);
          } else {
          System.out.println("Tiene que ingresar un numero positivo");
          }
          } else {
          System.out.println("No hay ningun medicamento en el sistema");
                 }
          break;

          case 4:
          medicamentoRegistrado = false;
          codigo = "";
          nombre = "";
          precio = 0;
          cantidad = 0;
          System.out.println("Medicamento eliminado del sistema");
          break;
         case 5:
          System.out.println("Regresando a sistema farmacia");
          break;
         default:
         System.out.println("Ingrese una opcion del 1 al 5");
         }
         }while (submenu != 5);
          break;
            
        case 6:
          System.out.println("Saliendo del sistema");
           break;

        default:
          System.out.println("Opcion no valida");
      }

      if(opcionmenu!= 5){
        System.out.println("\nPresione enter para seguir utilizando el sistema");
        sc.nextLine();
      }
    }
    
    //Holaaaaaaaaaaaaaaaaaaaaa soy Angel
 
    }//Fin de main
}//Fin de class
