public class MSTImpl implements MST{

	BinHeap<Integer, Double> heap = new BinHeap<>();
	
	@Override
	public boolean compute(WeightedGraph g, int s) {
		
		// 1 Fuege alle Knoten außer s mit Prio UNENDLICH in eine minVorrangWarteschlange ein
		for(int i = 0; i < g.size(); i++) {
			if(i != s) {
				heap.insert(i, Double.POSITIVE_INFINITY);
			}
		}
		
		// 2 setze u = s
		int u = s;
		
		// 3 solange Warteschlange nicht leer ist
		while(!heap.isEmpty()) {
			
			// 1 Für jeden Nachfolger von u:
			for(int j = 0; j < g.deg(u); j++) {
				int v = g.succ(u, j);
				BinHeap.Entry<Integer, Double> e = new BinHeap.Entry(v, v);
				
				// Wenn sich v in der Warteschlange befindet
				// und das Gewicht w der Kante { u , v } kleiner als die 
				// momentane Priorität von v ist:
				if(heap.contains(e) && g.weight(v, j) < heap.minimum().prio()) {
				}
		}
		
		return false;
	}

	@Override
	public int pred(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

}
