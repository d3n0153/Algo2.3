// Starke Zusammenhangskomponenten.
interface SCC {
    // Starke Zusammenhangskomponenten des Graphen g bestimmen.
    void compute (Graph g);

    // Vom Algorithmus ermittelte Information:

    // Eindeutige Nummer der Zusammenhangskomponente,
    // zu der der Knoten v gehoert.
    // Das heisst: component(u) muss genau dann gleich component(v) sein,
    // wenn u und v zur gleichen Zusammenhangskomponente gehoeren.
    // Abgesehen davon, koennen die Nummern beliebig sein.
    int component (int v);
}