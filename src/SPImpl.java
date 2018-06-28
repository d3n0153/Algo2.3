public class SPImpl implements SP{
	// delta = Gewicht
	double[] delta;
	// pi = Vorgaenger
	int[] pi;

	// TODO Es wird davon ausgegangen, dass delta tab[][0] und phi tab [][1] ist
	// Es passt aber nicht mit der Implementierung von WeightedGraph zusammen 
	
	// Tabelle Spalten = anzahl der Knoten; Zeile 0: delta; Zeile 1: pi
	// tab[x][0] = Distanz zum Startknoten
	// tab[x][1] = Vorg√§ngerKnoten
	public boolean bellmanFord(WeightedGraph g, int s) {
		delta = new double[g.size()];
		pi  = new int[g.size()];
		for (int i = 0; i < g.size(); i++) {
				delta[i] = INF;
				pi[i] = NIL;				
		}
		delta[s] = 0;
		// v ist Nachfolger Knoten
		for (int u = 0; u < g.size()-1; u++) {
			/** F¸r jede Kante (u, v ) aus E: Verwerte die Kante (vgl. ß 5.6.3).*/
			int v = g.succ(u, 0);
			double wv = g.weight(u, v);
			int dv = (int) ((SPImpl) g).dist(v);
			if (tab[u][0] + wv < dv){
				
			}
		}
		/**
			F¸r jede Kante (u, v) aus E:
			Wenn d(u) + r(u, v) < d(v):
				Abbruch, weil der Graph einen von s aus 
				erreichbaren negativen Zyklus enth‰lt.
		*/
		
		return false;
	}

	public void dijkstra(WeightedGraph g, int s) {
		// Keine negativen Kanten
		// wird vom Algorithmus nicht ueberprueft
		// also muss man nix abfangen?
		tab = new int[g.size()][2];
		for (int i = 0; i < tab.length; i++) {
				tab[i][0] = -1;
				tab[i][1] = -1;				
		}
		tab[s][0] = 0;
		BinHeap<Integer, Integer> heap = new BinHeap<>();
//		BinHeap.Entry<Integer, Integer>[] entrys = new BinHeap.Entry[tab.length];
		for (int v = 0; v < tab.length; v++) {
			heap.insert(tab[v][1], tab[v][0]);
		}
		while (!heap.isEmpty()){
			BinHeap.Entry<Integer, Integer> e = heap.extractMin();
			int u = e.data();
			for(BinHeap.Entry<Integer, Integer> i = heap.extractMin(); 
					i != null; i = heap.extractMin()){
				int v = i.data();
				/**
				 	1 Verwerte die Kante (u, v ) (vgl. ß 5.6.3).
					2 Wenn d(v) dadurch erniedrigt wurde:
						Erniedrige die Priorit‰t von v entsprechend
				 */
			}
		}
	}

	public double dist(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int pred(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
