# ![](https://github.com/zsdrahos/Java-HotPursuit/blob/master/image/Kép1.png)

# **Hot Pursuit - Dokumentáció**



**Feladat leírása**

A Hot Pursuit nevű játék a PacMan alapjaira épül. A játék egy előre meghatározott pályán játszódik (labirintus), ahol a játékos egy autóval van. A cél, hogy elmenekülj a rendőrök elől anélkül, hogy elkapnának és felszedje az összes csillagot a pályán. A játék úgy kezdődik, hogy egy megadott helyen éled fel a játékos és a rendőrautók pedig elkezdik üldözni egészen addig amig a fel nem szedte az összes csillagot a pályán vagy utol nem érték a rendőrautók. Amennyiben utolérik akkor a három életéből csökken egy és ha ez eléri a nullát akkor a játéknak vége. Minden játék végén kialakul egy pontszám, ami a felszedett csillagok alapján kerül kiszámításra és bekerül az eredménytáblába.

A rendőrök nem tudják felszedni a csillagokat azonban megállás nélkül automatikusan üldözik a menekülő autót

![](https://github.com/zsdrahos/Java-HotPursuit/blob/master/image/Kép4.png)![](https://github.com/zsdrahos/Java-HotPursuit/blob/master/image/Kép5.png)


**Use-Case**

A felhasználó a programban a következőket fogja tudni csinálni:

- Játszani (Play gomb)
- Lekérdezni az eredményeket
- Beállítani a nehézségi szintet.
- Kilépni a programból.

![](https://github.com/zsdrahos/Java-HotPursuit/blob/master/image/Kép2.png)

| **Nev** | Play |
| --- | --- |
| **Aktor** | Játékos |
| **Leírás** | A játékos elindítja a megfelelő gombbal a játékot a menüben |
| **Forgatókönyv** | Rányom a gombra ezáltál megváltozik a scene és megjelenik a pálya és a karakter, amit rögtön el lehet kezdeni irányítani.Vagy be lehet állítani a nehézséget. |

| **Nev** | Move Car |
| --- | --- |
| **Aktor** | Játékos |
| **Leírás** | A játékos irányítja a karaktert fel, le jobbra és balra |
| **Forgatókönyv** | Ezeket majd a nyilakkal tudja működtetni és irányítani amig falba nem ütközik, ahol pedig másik irányt kell választani. |

| **Nev** | SeeMap |
| --- | --- |
| **Aktor** | Játékos |
| **Leírás** | Játékosnak betölt a pálya és ezáltal megtudja tekinteni, hogy merre szeretne menni |
| **Forgatókönyv** | A játékos megtekinti a pálya felépítését |

| **Nev** | Control Police |
| --- | --- |
| **Aktor** | Program |
| **Leírás** | Rendőrök mozognak a pályán fel le jobbra vagy balra |
| **Forgatókönyv** | Játékos meghal, ha rendőrutóval ütközik |

**Vázlatos ismertetés**

A menüben lesz egy play gomb, ahol el lehet kezdeni a játékot tovább be lehet állítani, hogy milyen nehézségi szinten szeretne játszani a játékos. Továbbá lesz egy Scoreboard gomb, ahol pedig a meglehet tekinteni a pontokat, amiket elért eddig.

Az autót a billentyűzeten lévő nyilak segítségével lehet irányítani jobbra, balra fel és le a menüben pedig az egér segítségével lehet elérni dolgokat. A rendőrautókat pedig a program irányítja saját stratégiájuknak megfelelően

A programban pálya lesz generálva, ami egy n-es tömbben lesz eltárolva és az alapján lesz legenerálva grafikus formában. A pályán lesznek „falak&quot; amiken ha a játékos neki megy akkor nem tud tovább menni, ekkor kénytelen irányt változtatni. A pálya minden [i]. cellájában van egy csillag (ahol nincs fal), ezek a csillagok eltűnnek miután a játékos át ment rajtuk.

A játék során eltárolom az x és az y koordinátát tovább az irányokat h melyik irányba megy az autó. Erre azért van szükség, hogy majd a megfelelő játékos ikon jelenjen meg amikor valamilyen irányba megy.

A scoreboard adatait fájlban lesznek eltárolva, ahonnan mindig beolvassa az előzőleg elért pontokat és meg megjeleníti a játékban. Minden egyes játék után bekerül egy új sor a .txt fájlba azonban nem biztos, hogy a játékban meg fog jelenni mert csak a legjobb 10 pont lesz megjelenítve.

A grafikus megjelenítésért a Swing és a Java AWT fog felelni melyek segítségével fogom létrehozni a pályát a falat meg a karaktereket is.



**Dokumentáció**

A program egy pacmanhez hasonló játékot valósít meg. A különbség, hogy a hagyományos pacmanhez képest nincsnek benne bónusz golyók és a „szellemekből&quot; is csak egy féle van. A program használ alapvető java importokat. A feladatot 3 osztály segítségével valósítottam meg. Az osztályok végleges függvényei az objektum terv fülnél látható. A JUnit teszt pedig a Test1 osztályban jött létre.

![](RackMultipart20220518-1-ur1chi_html_95251a5f804fdb57.png)A program lényege, hogy a játékos összeszedjen minél több pontot a táblán és ezáltal felkerüljön az eredménytáblára. A játékot a nyilak, space, escape és az 1-3 gombok segítségével lehet vezérelni. A játék a space gomb lenyomásával tud elindulni, azonban még előtte a 1-3 gombok segítségével lehet nehézségi szintet beállítani. Ha ezt nem teszi meg a játékos akkor automatikusan a legelső nehézségi szintet állítja be. Miután elindult a játék, a felhasználó a nyilak segítségével tudja irányítani a karakterét jobbra, balra, fel és le. Továbbá, ha esetleg megunta volna a játékot akkor az ESC billentyűzet segítségével visszatérhet a főmenübe. A játék addig tart amig a játékos el nem veszíti mind a három életét. Ha esetleg összegyűjtötte az össze pontot a pályán akkor a pálya újra kezdődik, de a pontok megmaradnék tovább gyűjtögetheti a pontokat amig meg nem hal. Amint a játéknak vége a pontok kiíródnak az eredménytáblára (csak az első 10) és kezdheti előröl a játékot.

A ![](RackMultipart20220518-1-ur1chi_html_7aac42ec8926d06.png) programban van fájlba írás és olvasás, melyek a highScore.txt fájlt használják. Itt tárolja el a pontokat. A fájlban az adatok sortöréssel vannak elválasztva és csak számok találhatóak meg benne.

![](RackMultipart20220518-1-ur1chi_html_3172717f47336b6c.png)

A Game osztályban található maga a játék logikája melyben létrejön mapgenerálás és tulajdonképpen a többi osztály meghívása is.

A Draw osztályban történik a kirajzolás és a Move függvények meghívása.

Character osztály felel a megfelelő mozgatható objektumok megjelenítésért (Player/Policeok), egy közös ős a Player és a Polcienak.

A Player osztály a játékos karakteréért felelős. Ez az osztály határozza meg a mozgását, eredeti pozícióját és az ikonjának kirámolását is.

Police osztály pedig a „szellemek&quot; megvalósításáért felelős. Az irányítás és a pozíció meghatározás egyaránt ide tartozik.

Start osztály csak átláthatóság szempontjából került bele, itt található a Main függvény.

A maze generálás 2 szám segítségével jön létre. A 16 szám a csillagot jelenti a maze-en míg a 17-es pedig a falat, amint a player egy olyan mezőre lép ahol van 16os szám (van csillag) akkor azt a mező értékét a tömbben 0-rá változtatva ezáltal tudatva hogy ott felvette a csillagot. Minden egyes újraindításánál a maze alaphelyzetbe áll.

A játékban egy kocka 24\*24 pixel, ezt takarja a 24-es szám a program kódban, továbbá a maze egy 20\*20-as tömb melyben található csillag és fal is.

![](https://github.com/zsdrahos/Java-HotPursuit/blob/master/image/Kép3.png)
