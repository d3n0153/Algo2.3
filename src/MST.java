// Minimale SpannbÃ¤ume.
interface MST {
    // Minimalen Spannbaum des Graphen g mit dem Algorithmus von Prim
    // mit Startknoten s berechnen.
    // Resultatwert true, wenn dies mÃ¶glich ist (zusammenhÃ¤ngender
    // Graph), andernfalls false.
    // Der Graph muss ungerichtet sein, d. h. jede Kante muss
    // in beiden Richtungen mit dem gleichen Gewicht vorhanden sein.
    // (Dies muss nicht Ã¼berprÃ¼ft werden.)
    boolean compute (WeightedGraph g, int s);

    // Vom Algorithmus ermittelte Information:

    // VorgÃ¤ngerknoten des Knotens v im Spannbaum
    // (bzw. NIL, wenn es keinen VorgÃ¤nger gibt).
    int NIL = -1;
    int pred (int v);
}