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
        notify();
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
        notify();
        return s;
    }



}
