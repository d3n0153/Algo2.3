// Tiefensuche und topologische Sortierung.
interface DFS {
    // Tiefensuche im Graphen g durchfÃ¼hren.
    // In der Hauptschleife des Algorithmus werden die Knoten in der
    // Reihenfolge 0 bis g.size() - 1 durchlaufen.
    void search (Graph g);

    // Tiefensuche im Graphen g durchfÃ¼hren.
    // In der Hauptschleife des Algorithmus werden die Knoten in der
    // Reihenfolge d.sort(g.size() - 1) bis d.sort(0) durchlaufen.
    void search (Graph g, DFS d);

    // Topologische Sortierung des Graphen g durchfÃ¼hren.
    // Resultatwert true, wenn dies mÃ¶glich ist,
    // false, wenn der Graph einen Zyklus enthÃ¤lt.
    boolean sort (Graph g);

    // Von den Algorithmen ermittelte Information:

    // Entdeckungs- bzw. Abschlusszeit des Knotens v,
    // jeweils zwischen 1 und 2 * g.size().
    int det (int v);
    int fin (int v);

    // FÃ¼r i von 0 bis g.size() - 1 liefert sort(i) die Knoten
    // des Graphen g sortiert nach aufsteigenden Abschlusszeiten.
    // Das heiÃŸt: sort(0) ist der Knoten mit der kleinsten
    // Abschlusszeit, sort(g.size() - 1) der mit der grÃ¶ÃŸten.
    int sort (int i);
}