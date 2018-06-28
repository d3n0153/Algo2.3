public class SPImpl implements SP{
	int[][] tab;

	// TODO Es wird davon ausgegangen, dass delta tab[][0] und phi tab [][1] ist
	// Es passt aber nicht mit der Implementierung von WeightedGraph zusammen 
	
	public boolean bellmanFord(WeightedGraph g, int s) {
		tab = new int[g.size()][2];
		for (int i = 0; i < tab.length; i++) {
				tab[i][0] = -1;
				tab[i][1] = -1;				
		}
		tab[s][0] = 0;
		// v ist Nachfolger Knoten
		for (int i = 0; i < tab.length-1; i++) {
			/** Für jede Kante (u, v ) aus E: Verwer te die Kante (vgl. § 5.6.3).*/
			int v = g.succ(i, 0);
			double wv = g.weight(i, v);
			int dv = (int) ((SPImpl) g).dist(v);
			if (tab[i][0] + wv < dv){
				
			}
		}
		/**
			Für jede Kante (u, v) aus E:
			Wenn d(u) + r(u, v) < d(v):
				Abbruch, weil der Graph einen von s aus 
				erreichbaren negativen Zyklus enthält.
		*/
		
		return false;
	}

	@Override
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
				 	1 Verwerte die Kante (u, v ) (vgl. § 5.6.3).
					2 Wenn d(v) dadurch erniedrigt wurde:
						Erniedrige die Priorität von v entsprechend
				 */
			}
		}
	}

	@Override
	public double dist(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pred(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
