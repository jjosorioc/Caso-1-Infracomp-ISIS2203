package buzon;

import java.util.LinkedList;

/**
 * Hay 8 buzones en total. 6 intermedios tienen el mismo tamaño. 2 tienen 3 veces el tamaño, siendo
 * el de entrada y de salida.
 */
public class Buzon {

    /*
     * Capcidad del buzón.
     */
    private int capacidad;

    /**
     * Buffer
     */
    private LinkedList<String> list;

    /**
     * 
     * @param capacidad
     */
    public Buzon(int capacidad) {
        this.capacidad = capacidad;
        this.list = new LinkedList<String>();
    }


    /**
     * Almacenar un subconjunto
     * 
     * @param s
     */
    public synchronized void almacenar(String s) {
        while (this.list.size() == this.capacidad)
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Ocurrió un error al intentar almacenar el subconjunto");
            }

            
        this.list.add(s);
        notifyAll();
    }


    /**
     * Almacenar un subconjunto con espera activa.
     * 
     * @param s
     */
    public synchronized void almacenarProcesoInicial(String s) {
        this.list.add(s);
        notifyAll();
    }


    /**
     * Extraer un subconjunto
     * 
     * @return Un subconjunto
     */
    public synchronized String extraer() {
        while (this.list.size() == 0)
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Ocurrió un error al intentar extraer el subconjunto");
            }
        String s = this.list.removeFirst();
        notifyAll();
        return s;
    }


    /**
     * Extraer un subconjunto con espera activa
     * 
     * @return
     */
    public synchronized String extraerProcesoFinal() {
        String s = this.list.removeFirst();
        notifyAll();
        return s;
    }



    /**
     * Retorna si la lista está llena
     * 
     * @return
     */
    public boolean isFull() {
        return this.list.size() == this.capacidad;
    }


    /**
     * Retorna si la lista está vacía
     * 
     * @return
     */
    public boolean isEmpty() {
        return this.list.size() == 0;
    }


}
