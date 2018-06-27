import java.util.*;

public class BFSImpl implements BFS{

	// Gesucht werden alle Knoten, die vom Startpunkt s aus erreichbar sind.
	// S.133, delta(u, v) = Distanz des kürzesten Weges vom Knoten u zum Knoten v
	// pi(V) = Vorgänger
	
	int[][] tab;
	
	public void search(Graph g, int s) {
		
		// Tabelle Spalten = anzahl der Knoten; Zeile 0: delta; Zeile 1: pi
		// tab[x][0] = Distanz zum Startknoten
		// tab[x][1] = VorgängerKnoten
		tab = new int[g.size()][2];
		for (int i = 0; i < tab.length; i++) {
				tab[i][0] = INF;
				tab[i][1] = NIL;				
		}
		tab[s][0] = 0;
		
		LinkedList<Integer> fifo = new LinkedList<Integer>();
		fifo.add(new Integer(s));
		
		while(!fifo.isEmpty()) {
			
			int u = (fifo.removeFirst().intValue());
			
			for(int i = 0; i < g.deg(u); i++) {
				
				int v = g.succ(u, i);
				
				if(tab[v][0] == INF) {
					tab[v][0] = tab[u][0] + 1;
					tab[v][1] = u;
					
					fifo.addLast(new Integer(v));
				}
			}
		}
	}

	@Override
	public int dist(int v) {
		return tab[v][0];
	}

	@Override
	public int pred(int v) {
		return tab[v][1];
	}
}
