package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cabinaIds = new String[100];
        Gastos[] cabinas = new Gastos[100];
        int numCabinas = 0;
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1. Crear cabina telefónica");
            System.out.println("2. Registrar una llamada");
            System.out.println("3. Mostrar información detallada de una cabina");
            System.out.println("4. Mostrar consolidado total");
            System.out.println("5. Reiniciar uso de una cabina");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            if(opcion == 1) {
                System.out.print("Ingresa el identificador de la cabina: ");
                String id = sc.nextLine();
                boolean existe = false;
                for(int i = 0; i < numCabinas; i++) {
                    if(cabinaIds[i].equals(id)) {
                        existe = true;
                    }
                }
                if(existe) {
                    System.out.println("Ya existe una cabina con ese identificador.");
                } else {
                    if(numCabinas < cabinaIds.length) {
                        cabinaIds[numCabinas] = id;
                        cabinas[numCabinas] = new Gastos();
                        numCabinas++;
                        System.out.println("Cabina creada exitosamente.");
                    } else {
                        System.out.println("Límite de cabinas alcanzado.");
                    }
                }
            } else if(opcion == 2) {
                System.out.print("Ingresa el identificador de la cabina: ");
                String id = sc.nextLine();
                int indice = -1;
                for(int i = 0; i < numCabinas; i++) {
                    if(cabinaIds[i].equals(id)) {
                        indice = i;
                    }
                }
                if(indice == -1) {
                    System.out.println("No existe una cabina con ese identificador.");
                } else {
                    System.out.println("Tipo de llamada: 1. Local, 2. Larga Distancia, 3. Celular");
                    System.out.print("Ingresa el tipo de llamada: ");
                    int tipo = sc.nextInt();
                    System.out.print("Ingresa la duración en minutos: ");
                    int minutos = sc.nextInt();
                    sc.nextLine();
                    cabinas[indice].registrarLlamada(minutos, tipo);
                    System.out.println("Llamada registrada.");
                }
            } else if(opcion == 3) {
                System.out.print("Ingresa el identificador de la cabina: ");
                String id = sc.nextLine();
                int indice = -1;
                for(int i = 0; i < numCabinas; i++) {
                    if(cabinaIds[i].equals(id)) {
                        indice = i;
                        break;
                    }
                }
                if(indice == -1) {
                    System.out.println("No existe una cabina con ese identificador.");
                } else {
                    System.out.println("Información de la cabina " + id + ":");
                    System.out.println("Número de llamadas: " + cabinas[indice].getNumLlamadas());
                    System.out.println("Duración total: " + cabinas[indice].getDuracionTotal() + " minutos");
                    System.out.println("Costo total: " + cabinas[indice].getCostoTotal() + " pesos");
                }
            } else if(opcion == 4) {
                int totalLlamadas = 0;
                int totalDuracion = 0;
                int totalCosto = 0;
                for(int i = 0; i < numCabinas; i++) {
                    totalLlamadas += cabinas[i].getNumLlamadas();
                    totalDuracion += cabinas[i].getDuracionTotal();
                    totalCosto += cabinas[i].getCostoTotal();
                }
                System.out.println("Consolidado total:");
                System.out.println("Número de llamadas: " + totalLlamadas);
                System.out.println("Duración total: " + totalDuracion + " minutos");
                System.out.println("Costo total: " + totalCosto + " pesos");
            } else if(opcion == 5) {
                System.out.print("Ingresa el identificador de la cabina a reiniciar: ");
                String id = sc.nextLine();
                int indice = -1;
                for(int i = 0; i < numCabinas; i++) {
                    if(cabinaIds[i].equals(id)) {
                        indice = i;
                    }
                }
                if(indice == -1) {
                    System.out.println("No existe una cabina con ese identificador.");
                } else {
                    cabinas[indice].reiniciar();
                    System.out.println("Cabina reiniciada.");
                }
            } else if(opcion == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida.");
            }
            System.out.println();
        } while(opcion != 6);
        sc.close();
    }
}
