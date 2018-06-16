// KÃ¼rzeste Wege.
interface SP {
    // Algorithmus von Bellman-Ford auf dem Graphen g mit Startknoten s
    // ausfÃ¼hren.
    // Resultatwert true genau dann, wenn es im Graphen keinen vom
    // Startknoten aus erreichbaren Zyklus mit negativem Gewicht gibt.
    boolean bellmanFord (WeightedGraph g, int s);

    // Algorithmus von Dijkstra auf dem Graphen g mit Startknoten s
    // ausfÃ¼hren.
    // Die Kanten des Graphen dÃ¼rfen keine negativen Gewichte besitzen.
    // (Dies muss nicht Ã¼berprÃ¼ft werden.)
    void dijkstra (WeightedGraph g, int s);

    // Von den Algorithmen ermittelte Information:

    // Abstand des Knotens v zum Startknoten s (ggf. INF).
    double INF = Double.POSITIVE_INFINITY;
    double dist (int v);

    // VorgÃ¤ngerknoten des Knotens v auf dem kÃ¼rzesten Weg zum
    // Startknoten (bzw. NIL, wenn es keinen VorgÃ¤nger gibt).
    int NIL = -1;
    int pred (int v);
}