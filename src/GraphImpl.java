
public class GraphImpl implements Graph{
	
	// Deklaration Variablen einer Objekts
	int anzKnoten;
	int[][] graph = new int[anzKnoten][anzKnoten]; // <-- !! evtl crasht es hier an der Stelle !!
	
	// Konstruktor Graphimpl bekommt ein zweidimensionales Array (Adjazenzmatrix des Graphen)
	public GraphImpl(int[][] g) {
		anzKnoten = g.length;
		graph = g;
	} // fertig

	// Es soll die Anzahl der Knoten zurück gegeben werden = groesse des Graphen
	public int size() {
		return anzKnoten;		
	} // fertig

	// Es soll die Anzahl der ausgehenden Kanten eines Knotens ausgegeben werden
	// gibt für Eingabe v = 0...(n-1)
	// Wenn nur Zahlen von 1 - n eingegeben werden können, muss im Knotenaufruf graph[v -1] stehen.
	public int deg(int v) {
		return graph[v].length;	// TODO: abklären
	} // fertig
	
	// Gibt den i-ten direkten Nachfolger des Knotens v aus
	public int succ(int v, int i) {
		return graph[v][i];
	} // fertig

	public Graph transpose() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
