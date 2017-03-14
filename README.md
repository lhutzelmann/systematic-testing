# systematic-testing

**Für den Kurs bitte die Dateien im Package *sut* nicht lesen oder analysieren!**

## Themen

* Äquivalenzklassen (equivalence partitioning classes)
* Grenzwertanalyse (boundary value analysis)
* Entscheidungstabellen (decision tables)
* Zustandsdiagramme und -tabellen (state diagrams and tables)

## Zu testende Software

*Alle Programme enthalten noch Fehler*, die es durch geeignetes Testen zu finden gilt.

### LoginManager

Eine einfache Simulation eines Login-Vorgangs.

Besitzt folgende Methoden:

    boolean login(String user, String password)
    void logOff()

### Application

Ein kleines Zahlenratespiel. Die App wählt eine Zahl zwischen 1 und 10,
die vom Spieler erraten werden muss.

Das Spiel kann über die Klasse *Cli* gestartet werden.

Die Application-Klasse verwendet interne Zustände und Übergangsmethoden,
die von außen zugänglich sind, um sie gezielt testen zu können.

Hier ist es sinnvoll, zuerst ein Zustandsdiagramm/-tabelle zu erarbeiten.

### SessionManager

Eine einfache Simulation eines Session-Handlings.

Besitzt folgende Methoden:

    String startSession()
    boolean validateSession(String sessionId)
    void wait(int millis)
    boolean killSession(String sessionId)