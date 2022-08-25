package procesos;

import java.util.Random;
import buzon.Buzon;

public class ProcesoInicio extends Thread {
    /**
     * El buzón de salida es el buzón de entrada del proceso siguiente.
     */
    private Buzon salidaBuzon;


    /**
     * Arreglo con los subconjuntos de tamaño N.
     */
    private String[] subconjuntos;


    /**
     * Constructor del Proceso Inicial.
     * 
     * @param salidaBuzon
     * @param subconjuntos
     */
    public ProcesoInicio(Buzon salidaBuzon, String[] subconjuntos) {
        this.salidaBuzon = salidaBuzon;
        this.subconjuntos = subconjuntos;
    }

    @Override
    public void run() {
        Random random = new Random();

        /*
         * Enviar los subconjuntos al buzón externo.
         */

        int enviados = 0;
        while (enviados != subconjuntos.length) {
            while (!this.salidaBuzon.isFull()) {
                try {
                    // Dormir el thread
                    Thread.sleep(random.nextLong(50, 500));
                } catch (InterruptedException e) {
                }
                salidaBuzon.almacenarProcesoInicial(subconjuntos[enviados]);
                enviados++;
            }
            ProcesoInicio.yield();
        }


        /*
         * Enviar los mensajes de FIN
         */
        enviados = 0;

        while (enviados != 3) {
            while (!this.salidaBuzon.isFull()) {
                try {
                    // Dormir el thread
                    Thread.sleep(random.nextLong(50, 500));
                } catch (InterruptedException e) {
                }
                // Enviar mensaje de FIN
                salidaBuzon.almacenarProcesoInicial("FIN");
                enviados++;
            }
            ProcesoInicio.yield();
        }
    }


}
