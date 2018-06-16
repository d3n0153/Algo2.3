// Starke Zusammenhangskomponenten.
interface SCC {
    // Starke Zusammenhangskomponenten des Graphen g bestimmen.
    void compute (Graph g);

    // Vom Algorithmus ermittelte Information:

    // Eindeutige Nummer der Zusammenhangskomponente,
    // zu der der Knoten v gehÃ¶rt.
    // Das heiÃŸt: component(u) muss genau dann gleich component(v) sein,
    // wenn u und v zur gleichen Zusammenhangskomponente gehÃ¶ren.
    // Abgesehen davon, kÃ¶nnen die Nummern beliebig sein.
    int component (int v);
}