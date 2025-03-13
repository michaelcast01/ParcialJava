package org.example;
public class Gastos {
    private int numLlamadas;
    private int duracionTotal;
    private int costoTotal;
    public Gastos() {
        numLlamadas = 0;
        duracionTotal = 0;
        costoTotal = 0;
    }

    public Gastos(int numLlamadas, int duracionTotal, int costoTotal) {
        this.numLlamadas = numLlamadas;
        this.duracionTotal = duracionTotal;
        this.costoTotal = costoTotal;
    }

    public void registrarLlamada(int minutos, int tipo) {
        int tarifa;
        int costoLocal = 50;
        int costoLargaDistancia = 350;
        int costoCelular = 150;
        switch(tipo) {
            case 1:
                tarifa = costoLocal;
                break;
            case 2:
                tarifa = costoLargaDistancia;
                break;
            case 3:
                tarifa = costoCelular;
                break;
            default:
                System.out.println("Tipo de llamada inválido.");
                return;
        }
        numLlamadas++;
        duracionTotal += minutos;
        costoTotal += minutos * tarifa;
    }
    public void reiniciar() {
        numLlamadas = 0;
        duracionTotal = 0;
        costoTotal = 0;
    }
    public int getNumLlamadas() {
        return numLlamadas;
    }
    public int getDuracionTotal() {
        return duracionTotal;
    }
    public int getCostoTotal() {
        return costoTotal;
    }
}
