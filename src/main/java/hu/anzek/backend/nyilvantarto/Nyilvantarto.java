/**
 * "laszlo.zoltan.szobonya@gmail.com"
 */

package hu.anzek.backend.nyilvantarto;

import java.io.*;
import java.util.*;

/**
 * Nyilvántartó vizsgafeladat<br>
 * @author User
 */
public class Nyilvantarto {

    // a partnertörzsadatok fájlneve konstansa:
    public static final String FILE_PATH = "partnerek.txt";
    // a kigyűjtött adataink fájlnevének konstansa:
    public static final String OUTPUT_FILE_PATH = "kapcsolatok.txt";
    // a kigyűjtendő (adatbevitelből származő) adatok adattároló kollekciója:
    // a kulcs a szakértelem_azonosító: A lehetséges változatok: 1,3,4,5,6,8,9
    public static final Map<Integer, List<Partner>> sajatListamMap = new HashMap<>();
    // a beolvasott törzsadatok lista kollekciója:
    public static List<Partner> partnerek = new ArrayList<>();
    // egy olyan osztálytagváltozó (mező) amely azért szükséges, mert a lambda kifejezésben fogjuk használni
    // azonban mivel a lambda kifejezés mindig fuitásidőben értékelődik ki, azokban csak olyan változókat használhatunk
    // amelyek:
    // - vagy a lambda függvényen belül lettek deklarálva
    // - vagy az az magában foglló osztályváltozója (vagyis a lambdafüggvény számára kvázi public láthatósága van)...    
    private static int szakteruletKod;
    /**
     * a partner "törzs" entitásunk<br>
     */
    public static class Partner implements Comparable<Partner> {
        // publikus tagváltozók, konstruktor és a felülírt metódusok:
        String glnKod;
        String telefonszam;            
        String megnevezes;
        int szakterulet_kapcsolati_kod;
        String szakertelemMegnevezes;
        String cim;
	String kapcsolat;

        public Partner() {
        }  
        
        /**
         * implementáljuk a Comparable<T> generikus interfész<br>
         * compareTo() absztrakt metódusát<br>
         * itt adjuk meg, hogy:<br>
         * - az aktuális példány melyik nevű tagváltozó pillanatnyi értékét hasonlítsuk össze<br> 
         * - a paraméterben átadott másik példány értékével<br>
         * ami a vissztérő értket illeti -1, ha az aktuélis (this) kisebb, 0, ha egyenlő, és 1, ha nagyobb!<br>
         * @param other az összehasonlításra váró partner ntitás<br>
         */
        @Override
        public int compareTo(Partner other) {
            return this.glnKod.compareTo(other.glnKod); // -1, 0, 1
        }        
        
        @Override
        public String toString(){            
            return "Partner( " + this.glnKod.trim()+ " - " + this.megnevezes.trim() + "\n" 
                               + "\t\t - " + this.telefonszam.trim() + "\n" 
                               + "\t\t - " + this.cim.trim() + "\n" 
                               + "\t\t - " + this.szakterulet_kapcsolati_kod + " -> " + this.szakertelemMegnevezes.trim() + "\n" 
			       + "\t\t [" + this.kapcsolat +"] )";                    
        }
    }
    
    /**
     * Egy saját hibakezelő osztály<br>
     */
    public static class SajatHibakezelo extends Exception{

        private static final long serialVersionUID = 35235531L;
        private static String hibaUzenet;

        public SajatHibakezelo(String hibaUzenet) {
            
            super(hibaUzenet + "\n");
            this.hibaUzenet = hibaUzenet;            
        }
        
        /**
         * kiolvassuk a hibaüzenetet, hogy ki tudjuk íratni a konzolra!<br>
         * @return visszadaja a hibaüzenetet (amit mi magunk generáltunk)<br>
         */
        public String getHibaUzenet(){
            return this.hibaUzenet;
        } 
    }
    
    /**
     * A listázó funkcionális interfászünk<br>
     * @param <T> a bemenő kollekció (ami itt majd lehet a sajatLista, de lehet a Partner-ek listája is<br>
     */
    @FunctionalInterface
    public interface Listazo <T>{    
        void lista(T pLista);
    }
    
   /**
     * a "Listazo" interfész absztrakt metódusának "partner.txt" listázási impelemtációja<br>
     */
    public static final Listazo<List<Partner>> partnerLista = (pLista) -> {
        // implementáld a partnerek.txt -ből létrehozott listakollkciódat (a "partnerek" ez a listakollekciód)
    };
    
    /**
     * a "Listazo" interfész absztrakt metódusnak<br> 
     * az adatbevitellel összegyűjtött adataink listázása impelemtációja<br>
     */
    public static final Listazo<Map<Integer, List<Partner>>> sajatLista = pLista -> {
        // implementáld "b" pontban összeszedett partneradatokból létrehozott listakollkciódat (a "sajatListamMap" ez a Map-kollekciód)
    };
    
    public static void main(String[] args) throws SajatHibakezelo{
        
        // 1. kiolvasni a "partnerek.txt"
        partnerek = beolvasPartnerek(FILE_PATH);

        try{
            if (partnerek.isEmpty()) {
                throw new SajatHibakezelo("Nincs ilyen adat! -> hianyoznak a partner.txt adatai");  
            }     
            
            // átrendezés a GLN kódok szerint
            // (ezt implemntáltu a Partner.compareTo() metódusban!
            Collections.sort(partnerek);       

            Scanner szkenner = new Scanner(System.in);
            char menuValasztas;
            boolean menuMehet = true;
            
            // 2. hozzuk létre a menüt (amely ciklusban fusson) while(){}while()
            // javaslom do{.. menü és a kiválasztás lekezélse => "b".pont  ..}while(mehet);
            // kezeld le egy switch() szelekcióval a kiválasztás eredményét. (try..catch -ben a sját hibakezelőnk kezeljes le a nem vár billentyűt...
            // a cikluson belül
                    menuValasztas = szkenner.next().charAt(0); 
                    szkenner.nextLine();
            //      try{
            //          case 'a' : ...
            //          case 'b' :
            //                  adatbevitel(szkenner);
            //                  break;
            //          case 'c' : ....
            //      catch(saját... e){system.out...(e.getHibaUzenet()}
            // ciklusvég: while(mehet);
        }catch(SajatHibakezelo e){
            System.out.println(e.getHibaUzenet());
        }            
    }

    // "b" pont  - adatbevitel
    public static void adatbevitel(Scanner scanner) throws SajatHibakezelo {
        Partner partner = new Partner();
        // try{
            System.out.print("A kapcsolat létrejöttének a dátuma (ÉÉÉÉHHNN formában): ");
            String datum = scanner.next();
            // ez egy úgynevezett REGULÁRIS KIFEJEZÉS:
            // a JAVA-ban a reguláris kifejezéseket "\\" jelekkel vezetjük be.
            // a Java-fordító tudja értelmezni a reguláris kifejezések minden formáját 
            // (ahogy egyébként a legtöbb magasszintű nyelv ford>tója is)
            // jelentése 
            // "d"-> digit, azaz számjegyet vár
            // {nHosszan} a kapcsos zárójelek közötti nHosszan számérték pedig, hogy mennyi karakteben várjuk el            
            if ( ! datum.matches("\\d{8}")) {
                throw new SajatHibakezelo("Hibás adat/adatformátum : "  + "dátumformátum (a helyes formátum: ÉÉÉÉHHNN elválasztó jelek nélkül!)");
            }

            // Itt a GLN -kódot lehet tárolni a partner objektumban.
            System.out.print("GLN-kód (ügyfél kódja): ");
            String glnKod = scanner.next();
            
            // vizsgáld le a GLN kód szintaxis helyességét (6 karakter de csak szám lehet szóközök nélkül)
            // - vizsgáld meg létezike-e ilyen GLN kód?
            // if( ! glnkodIsTrue(glnKod)){ dobsz egy kivétet: "Nincs ilyen adat! " + " (hibás GLN -kód)" }      
            //     if( ! p.glnKod.equels(glnKod) ){ ->> throw sajathiba...}
        //  catch(saját... e){system.out...(e.getHibaUzenet()}
    }

    /**
     * spec-7.<br>
     * Menü - "c" funbkkcio<br>
     * az adatbevitellel felgyűjtött Map-listánk listázása<br>
     * ha nincs listázható adat (ez a 72-es hibakód) akkor kivételt dob, kilép a metódusból és folytatja a munkát<br>
     * @throws hu.anzek.backend.nyilvantarto.Nyilvantarto.SajatHibakezelo a saját hibakezelőd<br>
     */
    public static void listazzSajatListat() throws SajatHibakezelo {
        try{
            if (sajatListamMap.isEmpty()) {
                throw new SajatHibakezelo("Nincs több, vagy nincs ilyen listázható adat!");
            }        
            sajatLista.lista(sajatListamMap);                
        }catch(SajatHibakezelo e){
            System.out.println(e.getHibaUzenet());
        }        
    }
    
    public static List<Partner> beolvasPartnerek(String filePath) throws SajatHibakezelo {
        List<Partner> plist = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            
            // 1/a, Írd meg a textfájlt beolvasó while ciklust.
            // 1/b, add hozzá a listakollekcióhoz...
        }catch(FileNotFoundException e){
            throw new SajatHibakezelo("A fájl nem található a magadott helyen!");
        }
        return plist;
    }    
    
    public static void kiirFajlba(){
        try{
            if (sajatListamMap.isEmpty()) {
               throw new SajatHibakezelo("Nincs több, vagy nincs ilyen listázható adat!");
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE_PATH))) {
                //                
                // Map<K,V> -> K = Integer, V = List<Partner>
                //
                //:1,{ "123456;+36(12)345678;Cég1;1;HumanEroforas;Budapest",
                //     "345321;+36(34)567890;Cég6;4;Termelés es Humaneroforras;Balatonszemes",
                //     "456123;+36(12)345678;Cég7;1;HumanEroforas;Budapest",
                //     "321789;+36(23)456789;Cég11;6;HumenEroforras es Kereskedelem;Ozd"
                //   }
                //:8,{ "789012;+36(23)456789;Cég2;8;Termeles es Kereskedelem;Pécs",
                //     "012789;+36(23)456789;Cég8;8;Termeles es Kereskedelem;Sorpon",
                //     "678345;+36(34)567890;Cég9;8;Kereskedelem es Termelés;Miskolc" 
                //    }
                    //*******************************
                    //* A kimenet a "kapcsolatok.txt"
                    //********************************
                    //Szakterület: 1
                    //	Partner( 789012 - Cég2
                    //		 - +36(23)456789
                    //           - Pécs
                    //		 - 8 -> Termeles es Kereskedelem 
                    //		 [ninc adat])
                    // Partner( 789012 - Cég2
                    //		 - +36(23)456789
                    //           - Pécs
                    //		 - 8 -> Termeles es Kereskedelem 
                    //		 [ninc adat])                    
                    //Szakterület: 8
                    //	Partner( 789321 - Cég5
                    //		 - +36(23)456789
                    //           - Gyongyos
                    //		 - 5 -> Kereskedelem )
                    //		 [ninc adat])     
                    //	Partner( 789321 - Cég5
                    //		 - +36(23)456789
                    //           - Gyongyos
                    //		 - 5 -> Kereskedelem )
                    //		 [ninc adat]) 
                    //	Partner( 789321 - Cég5
                    //		 - +36(23)456789
                    //           - Gyongyos
                    //		 - 5 -> Kereskedelem )
                    //		 [ninc adat]) 
                sajatListamMap.forEach( (szakiKod, pList) -> {
                                                                writer.println("Szakterület: " + szakiKod);
                                                                pList.forEach( (p) -> {writer.println("\t" + p.toString());});
                                                                boolean igazHamis = false;
                                                                for(int i=0; i < pList.size(); i++ ){
                                                                    Partner p = pList.get(i);
                                                                    System.out.println("\t" + p.toString() );                                                                    
                                                                }
                                                              }
                                      );
                System.out.println("Adatok sikeresen kiírva a kapcsolatok.txt fájlba!");
            } catch (IOException e) {
                throw new SajatHibakezelo("Hiba történt a fájl írása közben! " + e.getMessage());
            }            
        }catch(SajatHibakezelo e){
            System.out.println(e.getHibaUzenet());
        }            
    }
}