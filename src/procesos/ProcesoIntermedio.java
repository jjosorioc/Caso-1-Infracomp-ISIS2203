package procesos;

import java.util.Random;
import buzon.Buzon;


/**
 * El primer proceso solo tiene un buzón de salida y el último proceso solo tiene un buzón de
 * salida.
 */
public class ProcesoIntermedio extends Thread {

    /**
     * El buzón de entrada es el buzón de salida del proceso anterior.
     */
    private Buzon entradaBuzon;

    /**
     * El buzón de salida es el buzón de entrada del proceso siguiente.
     */
    private Buzon salidaBuzon;

    /**
     * Nivel de transformación (Las filas en el ejemplo)
     */
    private int nivelTransformacion;

    /**
     * Las columnas en el ejemplo Número del 1 al 3
     */
    private int idColumna;

    /**
     * Mensaje que lleva el proceso
     */
    private String mensaje;


    /**
     * Constructor de un proceso intermedio.
     * 
     * @param entradaBuzon
     * @param salidaBuzon
     * @param nivelTransformacion
     * @param idColumna
     */
    public ProcesoIntermedio(Buzon entradaBuzon, Buzon salidaBuzon, int nivelTransformacion,
            int idColumna) {
        this.entradaBuzon = entradaBuzon;
        this.salidaBuzon = salidaBuzon;
        this.nivelTransformacion = nivelTransformacion;
        this.idColumna = idColumna;
    }


    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            mensaje = entradaBuzon.extraer();
            if (mensaje.equals("FIN")) {
                try {
                    Thread.sleep(random.nextLong(50, 500));
                } catch (InterruptedException e) {

                }
                salidaBuzon.almacenar("FIN");
                break;
            }

            try {
                Thread.sleep(random.nextLong(50, 500));
            } catch (InterruptedException e) {

            }
            salidaBuzon.almacenar(mensaje + this.toString());
        }



    }


    @Override
    public String toString() {
        return "T" + nivelTransformacion + idColumna;
    }

}
