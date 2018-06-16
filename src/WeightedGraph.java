// Gerichteter gewichteter Graph.
// (Ein ungerichteter gewichteter Graph kann als gerichteter gewichteter
// Graph reprÃ¤sentiert werden, bei dem jede Kante in beiden Richtungen
// mit dem gleichen Gewicht vorhanden ist.)
interface WeightedGraph extends Graph {
    // Gewicht der Kante von v zu seinem i-ten direkten Nachfolger.
    // i muss im selben Bereich wie bei der Methode succ liegen.
    // (Dies muss nicht Ã¼berprÃ¼ft werden.)
    double weight (int v, int i);

    // Achtung:
    // Wenn man fÃ¼r einen gewichteten Graphen transpose() aufruft,
    // erhÃ¤lt man einen Graphen des Typs Graph ohne Gewichte.
}