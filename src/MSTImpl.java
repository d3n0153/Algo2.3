import com.sun.jndi.ldap.EntryChangeResponseControl;

public class MSTImpl implements MST{
	
	BinHeap<Double, Integer> heap = new BinHeap<>();
	int vorgaenger[];
	
	@Override
	public boolean compute(WeightedGraph g, int s) {
		
		vorgaenger = new int[g.size()];
		
		// 1 Fuege alle Knoten außer s mit Prio UNENDLICH in eine minVorrangWarteschlange ein
		for(int i = 0; i < g.size(); i++) {
			if(i != s) {
				heap.insert(Double.POSITIVE_INFINITY, i);
			}
		}
		
		// 2 setze u = s
		int u = s;
		
		// 3 solange Warteschlange nicht leer ist
		while(!heap.isEmpty()) {
			
			// 1 Für jeden Nachfolger von u:
			for(int j = 0; j < g.deg(j); j++) {
				int v = g.succ(u, j);
				
				double gewichtKanteUV = g.weight(j, v);
				
				BinHeap.Entry<Double, Integer> vAsEntry = new BinHeap.Entry<Double, Integer>(gewichtKanteUV, v);
				// brauchen Entry vom Knoten
				
				// Wenn sich v in der Warteschlange befindet
				// und das Gewicht w der Kante { u , v } kleiner als die 
				// momentane Priorität von v ist:
				if(heap.contains(vAsEntry) && g.weight(v, j) < vAsEntry.prio().intValue()) {
					
					// setze Vorgänger pi(v) auf u und
					vorgaenger[v] = u; // vllt meint der aber auch in der heap den Vorgänger
					// erniedrige das die Prio von v auf g.weigth(j, v)
					// vAsEntry.changePrio(g.weigth(j, v) als Integer)
				}
				
				// 2 Entnehme einen Knoten u mit minimaler Priorität
				BinHeap.Entry<Double, Integer> e = heap.extractMin();
				
				// 3 Wenn Priorität von e == INF: Abbruch! Graph ist nicht zusammenhängend
				if(e.prio().intValue() == Double.POSITIVE_INFINITY) {
					return false;					
				}
			}
		}
		
		return true;
	}

	@Override
	public int pred(int v) {
		return vorgaenger[v];
	}

}
