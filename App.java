/**
 * 
 * App
 * 
 * @author Pintescul Patric (inherited: Stefano Punta)
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {

        // aggiungere una lettura dei valori...
        // prevedere di leggerli da tastiera
        Tabella s = new Tabella(3, 10, 13);

        s.popolaTabella();
        s.stampaTabella();
        s.calcolaMedieAlunni();
        s.stampaMedieTabella();
        s.stampaCrediti();
        /*

        */
    }

}