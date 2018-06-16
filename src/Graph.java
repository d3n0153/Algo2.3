// Gerichteter Graph.
// (Ein ungerichteter Graph kann als gerichteter Graph reprÃ¤sentiert
// werden, bei dem jede Kante in beiden Richtungen vorhanden ist.)

interface Graph {
    // GrÃ¶ÃŸe des Graphen, d. h. Anzahl seiner Knoten.
    // Die Knoten werden direkt durch Nummern zwischen 0 einschlieÃŸlich
    // und size() ausschlieÃŸlich reprÃ¤sentiert, das heiÃŸt:
    // Alle Parameter von Methoden dieser und anderer Schnittstellen,
    // die Knoten bezeichnen (z. B. v), mÃ¼ssen Werte in diesem Bereich
    // besitzen. (Dies muss nicht jedesmal Ã¼berprÃ¼ft werden.)
    // Methoden, die Knoten als Resultat liefern (z. B. succ), mÃ¼ssen
    // Werte in diesem Bereich liefern.
    int size ();

    // Grad des Knotens v, d. h. Anzahl seiner ausgehenden Kanten
    // bzw. direkten Nachfolger.
    int deg (int v);

    // i-ter direkter Nachfolger des Knotens v.
    // i muss zwischen 0 einschlieÃŸlich und deg(v) ausschlieÃŸlich
    // liegen. (Dies muss nicht Ã¼berprÃ¼ft werden.)
    int succ (int v, int i);

    // Transponierter Graph, d. h. ein neuer Graph mit denselben Knoten
    // wie der aktuelle Graph, der fÃ¼r jede Kante (u, v) des aktuellen
    // Graphen die entgegengesetzte Kante (v, u) enthÃ¤lt.
    Graph transpose ();
}