package procesos;

import buzon.Buzon;

public class ProcesoFinal extends Thread {

    /**
     * El buzón de entrada es el buzón de salida del proceso anterior.
     */
    private Buzon entradaBuzon;


    /**
     * Constructor del Proceso Final.
     * 
     * @param entradaBuzon
     */
    public ProcesoFinal(Buzon entradaBuzon) {
        this.entradaBuzon = entradaBuzon;
    }



    @Override
    public void run() {
        while (true) {
            String subconjunto = entradaBuzon.extraer();
            if (subconjunto == null) {
                break;
            }
            System.out.println(subconjunto);
        }
    }
}
