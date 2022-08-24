package procesos;

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
        for (int i = 0; i < subconjuntos.length; i++) {
            salidaBuzon.almacenar(subconjuntos[i]);
        }
    }


}
