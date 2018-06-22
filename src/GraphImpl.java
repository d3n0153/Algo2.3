import java.util.*;
import java.util.List;

public class GraphImpl implements Graph{
	
	// Deklaration Variablen einer Objekts
	int anzKnoten;
	int[][] graph; // <-- !! evtl crasht es hier an der Stelle !!
	
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

	// gibt den Graph transponiert zurück
	public Graph transpose() {
		
		// Wird nachher der Graph der returned wird
		
		// erstelle ein Array aus Arraylists. Jeder Knoten bekommt eine Liste
		List<Integer>[] dummy = new ArrayList[anzKnoten];
		for(int i=0; i < anzKnoten; i++) {
			dummy[i] = new ArrayList<Integer>();	// Füllen des Arrays mit ArrayListen
		}
		
		// Transponieren, umdrehen aller Pfeile
		for(int i = 0; i < anzKnoten; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				int a = graph[i][j];		// Knoten auf den Knoten i zeigt
				dummy[a].add(i); 		// Knoten i wird nun in die List von Knoten a geschrieben 			
			}					
		}
		
		int[][] graphTrans = new int[anzKnoten][anzKnoten];
		// GraphTrans mit -1 füllen
		for(int i = 0; i < anzKnoten; i++) {
			for(int j = 0; j < anzKnoten; j++) {
				graphTrans[i][j] = -1;
			}
		}
		
		// 2D-Array graphTrans mit den Werten aus Dummy fuellen
		for(int index = 0; index < anzKnoten; index++) {
			for(int j = 0; j < dummy[index].size(); j++) {
				graphTrans[index][j] = dummy[index].get(j);
			}
		}
		
		return new GraphImpl(graphTrans);

	} // fertig
	
	public void print() {
	    for(int i = 0; i < anzKnoten; i++) {
	    		for(int j = 0; j < graph[i].length; j++) {
	    			System.out.println("graph[" + i + "][" + j + "] = " + graph[i][j]);
	    		}
	    }
	}
	
}
