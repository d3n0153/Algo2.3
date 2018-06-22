// Gerichteter Graph.
// (Ein ungerichteter Graph kann als gerichteter Graph repraesentiert
// werden, bei dem jede Kante in beiden Richtungen vorhanden ist.)

interface Graph {
    // Groesse des Graphen, d. h. Anzahl seiner Knoten.
    // Die Knoten werden direkt durch Nummern zwischen 0 einschliesslich
    // und size() ausschliesslich repraesentiert, das heisst:
    // Alle Parameter von Methoden dieser und anderer Schnittstellen,
    // die Knoten bezeichnen (z. B. v), muessen Werte in diesem Bereich
    // besitzen. (Dies muss nicht jedesmal ueberprueft werden.)
    // Methoden, die Knoten als Resultat liefern (z. B. succ), muessen
    // Werte in diesem Bereich liefern.
    int size ();

    // Grad des Knotens v, d. h. Anzahl seiner ausgehenden Kanten
    // bzw. direkten Nachfolger.
    int deg (int v);

    // i-ter direkter Nachfolger des Knotens v.
    // i muss zwischen 0 einschliesslich und deg(v) ausschliesslich
    // liegen. (Dies muss nicht ueberprueft werden.)
    int succ (int v, int i);

    // Transponierter Graph, d. h. ein neuer Graph mit denselben Knoten
    // wie der aktuelle Graph, der fuer jede Kante (u, v) des aktuellen
    // Graphen die entgegengesetzte Kante (v, u) enthaelt.
    Graph transpose ();
    
    void print();
}

/*
 * Anmerkungen zu allen Algorithmen:
 *
 * Der uebergebene Graph g darf nicht null sein.
 * Dies muss nicht ueberprueft werden.
 *
 * Die Nachfolger eines Knotens u muessen immer in der Reihenfolge
 * g.succ(u, 0) bis g.succ(u, g.deg(u) - 1) durchlaufen werden.
 */

/*
 * Algorithmen auf ungewichteten Graphen
 */
