/**
 * Progetto Scrutinio per il tabellone riassuntivo di tutti i voti compresi Ed.
 * civica e Condotta
 * 
 * 
 * @author Pintescul Patric (inherited: Stefano Punta)
 * @version 1.0
 */
public class Tabella {

    private int classe; // può assumere il valore 3,4,5 che indica la classe di cui si esegue lo
                        // scrutinio
    private int[][] tabellone; // tabellone dei voti
    private float[] media_voti;

    /**
     * Costruttore degli oggetti di classe Tabella con tabellone di n_alunni e
     * numero materie
     */
    public Tabella(int classe, int n_alunni, int n_materie) {
        // viene definito il vettore con numero di n valori
        this.classe = classe;
        tabellone = new int[n_alunni][n_materie];
        media_voti = new float[n_alunni];
    }

    /**
     * Popola, inizializza il vettore con valori tra 1 e 10 tipo dei voti
     * 
     */
    public void popolaTabella() {
        // inserisce dei valori tra 1 e 10 nel vettore
        int max = 35;
        int min = 1;
        int range = max - min + 1;
        // con questo la probilità di prendere una insuff è di 1 su 30 rispetto alla
        // probabilità di prendere una suff

        int media;
        for (int alunno = 0; alunno < tabellone.length; alunno++)
            for (int materia = 0; materia < tabellone[0].length; materia++) {
                media = (int) (Math.random() * range) + min;
                if (media == 1) // se è uscito il numero 1 può prendere un media da 3 a 5
                    tabellone[alunno][materia] = (int) (Math.random() * 3) + 3;
                else if ((media >= 2) && (media <= 25)) // da 2 a 25 può prendere da 6 a 7
                    tabellone[alunno][materia] = (int) (Math.random() * 2) + 6;
                else // negli altri casi può prendere 8 a 10
                    tabellone[alunno][materia] = (int) (Math.random() * 3) + 8;
            }
    }

    /**
     * Stampa il tabellone
     * 
     * 
     */
    public void stampaTabella() {
        System.out.println("\n*-Alunno-----Materie--------Tabellone"+"-".repeat(27)+"*");
        for (int alunno = 0; alunno < tabellone.length; alunno++) {
            // uso l' accorgimento di stampare alunno 1 e non 0
            System.out.format("Alunno %-2s -> ", alunno + 1);
            for (int materia = 0; materia < tabellone[0].length; materia++) {
                System.out.format("%3s|", tabellone[alunno][materia]);
            }
            if(alunno!=this.tabellone.length-1)
                System.out.println();
        }
        System.out.println("\n*"+"-".repeat(63)+"*\n");
    }

    /**
     * calcola la somma di una riga cioè la somma di tutti i voti di un alunno
     * 
     * @param alunno
     * @return somma
     */
    public int sommaTabella(int alunno) {
        int somma = 0;
        // completare
        return somma;
    }

    /**
     * calcola il numero di insufficienze di una alunno per poter poi permettere
     * il calcolo della media
     * 
     * @param alunno
     * @return numero insuff.
     */
    public int numInsuffAlunno(int alunno) {
        int num_insuff = 0;
        // completare
        return num_insuff;
    }

    /**
     * assegna ad ogni elemento del vettore media_voti la media effettiva (float)
     * se l' alunno non ha insuff
     * 
     */
    public void calcolaMedieAlunni() {
        int somma;
        for (int i = 0; i < this.tabellone.length; i++) {
            somma = 0;
            for (int j = 0; j < this.tabellone[0].length; j++) {
                somma += this.tabellone[i][j];
            }
            media_voti[i] = (float) somma / this.tabellone[0].length;
        }
    }

    /**
     * Stampa le medie per ogni alunno
     * stampa 0 se l' alunno aveva insuff
     * 
     */
    public void stampaMedieTabella() {
        System.out.println("*-Medie" + "-".repeat(17) + "*");
        for (int i = 0; i < media_voti.length; i++)
            if(media_voti[i]<6)
                System.out.print(String.format("Alunno %-4s | Media: 0\n", (i + 1)));
            else
                System.out.print(String.format("Alunno %-4s | Media: %.2f\n", (i + 1), (media_voti[i])));

    }

    /**
     * @param media -> media dello studente
     * @param classe -> classe di appartenenza
     * @return int[] length=2, range di crediti.
     */
    public static int[] checkCrediti(float media,int classe) {
        int[] crediti = { 0, 0 };
            if (media < 6 && classe == 5) {
                crediti[0] = 7;
                crediti[1] = 8;
            } else if (media == 6) {
                //controllo per classe
                switch (classe) {
                    case 3:
                        crediti[0] = 7;
                        crediti[1] = 8;
                        break;
                    case 4:
                        crediti[0] = 8;
                        crediti[1] = 9;
                        break;
                    case 5:
                        crediti[0] = 9;
                        crediti[1] = 10;
                        break;

                    default:
                        break;
                }
            } else if (media > 6 && media <= 7) {
                //controllo per classe
                switch (classe) {
                    case 3:
                        crediti[0] = 8;
                        crediti[1] = 9;
                        break;
                    case 4:
                        crediti[0] = 9;
                        crediti[1] = 10;
                        break;
                    case 5:
                        crediti[0] = 10;
                        crediti[1] = 11;
                        break;

                    default:
                        break;
                }
            } else if (media> 7 && media<= 8) {
                //controllo per classe
                switch (classe) {
                    case 3:
                        crediti[0] = 9;
                        crediti[1] = 10;
                        break;
                    case 4:
                        crediti[0] = 10;
                        crediti[1] = 11;
                        break;
                    case 5:
                        crediti[0] = 11;
                        crediti[1] = 12;
                        break;

                    default:
                        break;
                }
            } else if (media > 8 && media <= 9) {
                //controllo per classe
                switch (classe) {
                    case 3:
                        crediti[0] = 10;
                        crediti[1] = 11;
                        break;
                    case 4:
                        crediti[0] = 11;
                        crediti[1] = 12;
                        break;
                    case 5:
                        crediti[0] = 12;
                        crediti[1] = 13;
                        break;

                    default:
                        break;
                }
            } else if (media > 9 && media <= 10) {
                //controllo per classe
                switch (classe) {
                    case 3:
                        crediti[0] = 11;
                        crediti[1] = 12;
                        break;
                    case 4:
                        crediti[0] = 12;
                        crediti[1] = 13;
                        break;
                    case 5:
                        crediti[0] = 13;
                        crediti[1] = 14;
                        break;

                    default:
                        break;
                }
            }
            ;
            return crediti;
    }

    /**
     * stampa i crediti di ciascun alunno (range)
     * @see <code>public static int[] Tabella.checkCrediti(float,int)</code>
     */
    public void stampaCrediti() {
        System.out.println("*-Crediti" + "-".repeat(17) + "*");
        for (int i = 0; i < this.media_voti.length; i++) {
            
            int[] crediti = checkCrediti(this.media_voti[i], classe);
            System.out.print(String.format("Alunno %-4s | Crediti: %s-%s\n", (i + 1), crediti[0], crediti[1]));
        }
    }
}