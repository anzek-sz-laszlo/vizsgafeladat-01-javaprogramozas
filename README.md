Sziasztok. (február 12)

Nincs vizsgabeadási határidő!
----------------------------
Úgy tűnik nincs osztatlan sikere a vizsgának, 
- de mint mondtam az általatok elvárt képesítést nem csupán a pénzetekért adják, (hisz a munkáltatók is számonkérnek majd minden kiadott feladatot...)
- ezért, most nem szabok belső határidőt!
- ki, ki tegye mag önmaga, és tartsa magát ahhoz (felnőtt emberek vagytok).
- aki pedig úgy érzi nem áll még készen egy teljes "projektszemléletre" annak javaslom egyelőre tegye talonba a feladatot - de ne feledkezzen meg rőla, mert az ott tanultakat nemigen ismételjük többet!
- egyébként jelezhetitek is személyesen ha konkrétan megfogalmazható problémával szembesültetek, vagy más, akárszemléletbeli akadályok adódtak, stb. (laszlo.zoltan.szobonya@gmail.com), mert szívesen segítek privát módon is...

Fontos:
Lesz még egy vizsgafeldat (amely az SQL/JPA-JQL illetőleg a backend-springes restfull feladat lesz), és ami most indult el, a február 10.-ei napon).
- ez ugyan picivel komplexebb problémakör lesz, de nem terjedelmesebb feladat, és a tanfolyam vége előtt egy héttel lesz a végső beadható határidő!
- ennek jelenlegi )január 27.-ei) feladatnak is ekkorra lesz a lehetséges legutolsó beadási határideje (addig még sokat fog javulni majd a projektszemléletetek)
- a terv pedig az. hogy utolső héten kiértékeljük a megoldásokat.  

Sziasztok.
A január 27.-i videóban részletesen bemutattam az egyes feladatokat és a program szerkezetét illetve az elvársaimat.
-------------------------------------------------------------------------------------------------------------------
Ez a feladat a nyers változata.
Hogyan jön le GIT -ről? 
ez a  repó linkje (de hiszen már itt vagy, ki olvashatod onnan is): 
"https://github.com/anzek-sz-laszlo/vizsgafeladat-01-javaprogramozas.git"
---------------------------------------------------------------------------------------------------------------
Kérnék mindenkit, hogy saját branch -et hozzon létre!
Az erre szolgáló paancs a :

$ git checkout -b <sajat_nick>

azért, hogy ne írkáljuk egymásét felül....
azután, hogy létrehoztad a barnch-ed, és "beváltott" (ezt a "git status" mutatja meg) ki kell adnod az alábbi parancsot (a pont is kell és ott, a szóköz is!)

$ git add .

majd ezután dolgozhatsz és amikor megvagy, akkor 
FONTOS! -> commitolni kell
ha a git status nem a saját branched mutatja, akkor ki kell adnod:
    $ git checkout <sajat_nick>
    ... és az add . -is majd eztuán csak:
    
git commit -m "mit csináltam, és miért, meg ki is vagyok és kivagyok, stb..."

ezután így kell feltölned a githubra:

$ git push -u origin <sajat_nick>
-----------------------------------------------------------------------------------------------------
AZ 1. sz. VIZSGAFELADAT BEMUTATÁSA:
Verzió 1.2 (RELEASE 2024-01-27)
A vizsgafeladat támakörei:
- konzol alkalmazások
- szövefájlok olvasása, írása
- java alapok, változók, osztályok, interészek, metódusok
- alap- és fejlett ciklusok, elágazások
- java kollekciók
- java lambda kifejezések
- kivételkezés, önálló hibakezelő osztály
- JUnit tesztek
mindez egy komplex projekt keretein belül, az OOP alapjai támakörben.

Sziasztok.
Kérném implementáljátok az alábbi projektet, annak minden elemét!
*******************************
* A bemenet a "partner.txt"
*******************************
123456;+36(12)345678;Cég1;1;HumanEroforas;Budapest
789012;+36(23)456789;Cég2;8;Termeles es Kereskedelem;Pécs
345678;+36(34)567890;Cég3;8;Kereskedelem es Termeles;Debrecen
123321;+36(12)345678;Cég4;9;Kereskedelem es Termeles es Humaneroforras;Eger
789321;+36(23)456789;Cég5;5;Kereskedelem;Gyongyos
345321;+36(34)567894;Cég6;4;Termelés es Humaneroforras;Balatonszemes
456123;+36(12)345678;Cég7;1;HumanEroforas;Budapest
012789;+36(23)456789;Cég8;8;Termeles es Kereskedelem;Sorpon
678345;+36(34)567896;Cég9;8;Kereskedelem es Termelés;Miskolc
321123;+36(12)345678;Cég10;3;Termelés;Kiskunhalas
321789;+36(23)456789;Cég11;6;HumenEroforras es Kereskedelem;Ozd
321345;+36(34)567896;Cég12;1;Humaneroforras;Nyiregyhaza

*********************************
* (A) Kritériumok, Követelmények:
*********************************
(azaz, a kód feleljen meg az alábbi elvárásoknak):
1, A kód magyar változónevekkel és partnerek-adatokkal készüljön.
2, A "partnerek.txt" -ből olvassuk ki az adatokat (az adatok: soronként vannak a rekordok és ";" az adatmezők elválasztására használt jel).
3, A kód tartalmazzon minimálisan egy funkcionális interfészt, de akár többet is.
4, A kód szövegfájlba írja ki az eredményeket  (az adatok: soronként vannak a rekordok és ";" az adatmezők elválasztására használt jel) 
-Az eredményfájl neve: "kapcsolatok.txt".
5, A kód fejlett forciklusokat használjon (ahol szükséges).
6, A kód használjon lambda kifejezéseket mindenhol, ahol kell, vagy lehet.
7, A kód használjon try-catch kivételkezelést és legyenek benne saját hibakezelő osztályok a problémák kezelésére: 
Használja az alábbi figyelmeztető üzeneteket (csakis ezek közül választhat üzenetet, kódolja a specifikációs kód szerint, pl 7/1 -> 71):
(célszerű külön metódust, vagy osztályt alkotni számukra).
7/1, "A fájl nem található a magadott helyen!"
7/2, "Nincs több, vagy nincs ilyen listázható adat!"
7/3, "Nincs ilyen adat! " (+ "-> ha úgy érezzük szükséges lehet, akkor írjuk utána, hogy milyen adat nem található!")
7/4, "Hibás adatot adott meg (számok helyett betűket)!"
7/5, "Ez a funkció nem létezik! Kérem a menü lehetőségeiből szíveskedjen választani!"
7/6, "Hiba történt a fájl írása közben! " 
7/7, "Hibás adat/adatformátum : " + "írjuk utána melyik adat formátuma hibás!"	 	 

******************
* (B) Specifikáció
******************
Vagyis a feladat a következő (a fenti Kritériumok betartása) mellett:

1, adott egy vállalat három szakterülete: 
	a 1 -> HR-Csoport, a 3 -> TermelésiOsztály,  az 5 -> KereskedelmiOsztály (szakterület_kapcsolati_kód -> SzakterületMegnevezése).
	A "szakterület_kapcsolati_kód" azért 1,3,5 mert így ezek összeget képező kombinációja is alkalmazható egy számként (1+3=4, 1+5=6, 3+5=8, 1+3+5=9)!

2, van egy közös partner-kapcsolati nyilvántartó, amely mindhárom osztályt kiszolgálja.
2/1, Ez a Nyilvántartás, egy ügyfél- és beszállítói nyilvántartás, amely minden partnerről 6 fajta adatot tart nyilván: 
	 az alábbi az egytlen amely valamiféle entitás -rekord (de nem szükséges rekordtípust léterhozni számára)
		Partner(
				GLN-kod, 
				telefonszam [+Országhívó,(körzet),telefonszám formában], 
				ceg_megnevezes, 
				a szakterulet_kapcsolati_kod,
				szakertelem_megnevezes [a szakterület_kapcsolati_kódhoz], 
				cimadat 
			   )
				
3, A feladat olvassuk be a "partner.txt" -ből az ügyfél- és beszállítói nyilvántartást, és töltsük azt egy lista kollekcióba!
3/1, Majd rendezzük át a GLN kódjuk szerint egy rendezett listába.
3/2, írjunk hozzá egy JUnit tesztet, amely ellenőrzi nem üres-e a lista és ellenőriz egy konkrét ügyfél mondjuk GLN kódját.
	 Azt, hogy melyk ügyfél legyen, az a "partner.txt" -ben lévő valahanyadik sor szerint nézük meg, 
	 hiszen egy "sima" List<T> kollekció megőrzi a betöltési sorrendet... 
	 (fontos: de csak egészen a rendezésig!)
	
4, írjunk saját hibakezelő osztályt, minden lehetséges - és nekünk fontos - probléma kezelésre 
	(de a rendszerhibákat nem szükséges lekezelnünk)! 
	
5, Írjunk egy adatbeviteli osztályt/metódust, amely a konzolról kéri be az alábbi adatokat úgy, 
	hogy minden adatbevitel után kiírja az alábbi kis menüt:

NYILVANTARTÓ-MENÜ
-------------------
a -ügyféllista
b -adatbevitel
c -a saját listám 
d -kilépés - adatmentéssel
e -kilépés - adatmentés nélkül
(kérem nyomja le a megfelelő a/b/c/d/e billentyűket)
 	
5/1, Ha a "b" -lett lenyomva, induljon egy adatbevitel!
	Ezeket kérje be (ezt a három adatot):
5/2, A kapcsolat létrejöttének a dátuma: 
	-ÉÉÉÉHHNN formában (20240127)
	-CSAKIS sztring-ként, de vizsgálja le azt, hogy csakis számokat írtunk be! 
	-A dátum helyessége most nem kritérium!)
5/3, GLN-kód (vagyis a kiválasztott ügyfél kódja.)
	- ellenőrizzük csak számokat írtak-e be és ha nem, akkor a saját hibakezelő fusson le a Követelmények 7/3. hibaüzenettel!
	- ellenőrizzük létező adat-e? 
	Ha nem létezik (mert pl elírták) akkor a saját hibakezelőnk és a Követelmények 7/2. üzenettel fusson!
5/4, A vállalat szakterületeit kiszolgáló kód: 
	(A lehetséges változatok: 1,3,4,5,6,8,9) 
	Vizsgáljuk le, hogy a számokat írtak-e be, és ha nem, akkor a saját hibakezelő fusson le a Követelmények 7/3. hibaüzenettel!
	-illetve azt, hogy a megfelelő számok közül választottak-e?
5/5, majd ezeket feldolgozva eltárolja azokat egy Map-ben! 
	Így dolgozzuk fel a bevitt adatokat:
5/5/1, Még a projekt indításakor (a partnerek.txt beolvasása után) hozzunk létre egy map kollekciót (csak Map-et, nem kell sem Linked- sem Tree-sem). 
	- a Map- kulcsok a vállalati szakterület azonosítói legyenek!
	- az adatok pedig egy- egy Listakollekciók legyenek, amelyekbe a bevitelből nyert adatokat tároljuk le.
5/5/2, A bevitt adatokat a vállalat szakterületeit kiszolgáló kód alapján adjuk hozzá az egyes listákhoz. 
	- Ügyeljünk, hogy pl ha 4 szakterületeit kiszolgáló kód, akkor tudható róla, hogy az 1 és 3 -as szakterületet is egyaránt kiszolgálhatja, 
	   vagyis mindkét helyhez hozzá kell adnunk!
	
6, Ha az "a" menupont lett indítva, akkor listázza ki a "partner.txt"  -ből kiolvasott tartalmat!
	Ha nem a/b/c/d/e lett leütve fusson a saját hibakezelőnk a Követelmények 7/4-es hibaüzenettel.   
	
7, Ha a menüből a "c" lett lenyomva, listázza ki az adatbevitellel felvett Map tartalmat 
	-Szövegesen jelenítse meg a vállalati szakterületet, és az ügyfél-adatokat is szövegesen!
	-Ha nincs még listázható adat, akkor fusson a saját hibakezelőnk a Követelmények 7/2. hibaüzenetével!
	
8, Ha a menüből a "d" lett lenyomva, akkor a 6.pontbeli listát egy szövegfájlba nyomtassa: a "kapcsolatok.txt" -be.
	-Ha volt már előtte ilyen fájl, akkor kérdés nélkül írja felül azt!
	-De ha nincs még listázható adat, akkor fusson a saját hibakezelőnk a Követelmények 7/2. hibaüzenetével!
	
9, ha az "e" lett lenyomva, és van bent már adatbevitelből lista adat, akkor kérdezze meg: 
	"Figyelem, volt adatbevitel!\nValóban ki szeretne lépni adatmentés nélkül? (i/n)"
9/1, ha ezt követően nem az "i" vagy az "n" lett lenyomva térjen vissza üzenet nélkül a menübe.
9/2, ha az "n" lett lenyomva, akkor is térjen vissza üzenet nélkül a menübe.
9/3, Ha az "i" lett lenyomva lépjen ki adatentés nélkül.
