package procesos;

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
     * Nivel de fila (Las columnas en el ejemplo) Número del 1 al 3
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



}
