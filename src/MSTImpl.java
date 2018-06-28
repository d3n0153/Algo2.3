public class MSTImpl implements MST{
	
	BinHeap<Double, Integer> heap = new BinHeap<>();
	int vorgaenger[];
	
	public boolean compute(WeightedGraph g, int s) {
		
		vorgaenger = new int[g.size()];
		BinHeap.Entry<Double, Integer>[] entrys = new BinHeap.Entry[g.size()];
		
		// 1 Fuege alle Knoten außer s mit Prio UNENDLICH in eine minVorrangWarteschlange ein
		for(int i = 0; i < g.size(); i++) {
			if(i != s) {
				entrys[i] = heap.insert(Double.POSITIVE_INFINITY, i);
			}
		}
		
		// 2 setze u = s
		BinHeap.Entry<Double, Integer> u = entrys[s];
		int uAsInt = s;
		
		// 3 solange Warteschlange nicht leer ist
		while(!heap.isEmpty()) {
			
			if(u != null) {
				uAsInt = u.data().intValue();
			}
			
			// 1 Für jeden Nachfolger von u:
			for(int j = 0; j < g.deg(uAsInt); j++) {
				
				int v = g.succ(uAsInt, j);
				double w = g.weight(uAsInt, j);
				// Wenn sich v in der Warteschlange befindet
				// und das Gewicht w der Kante { u , v } kleiner als die 
				// momentane Priorität von v ist:
				if(heap.contains(entrys[v]) && w < entrys[v].prio().intValue()) {
					
					// setze Vorgänger pi(v) auf u und
					vorgaenger[v] = uAsInt; // vllt meint der aber auch in der heap den Vorgänger
					
					// erniedrige das die Prio von v auf g.weigth(j, v)
					heap.changePrio(entrys[v], new Double(w));
					// vAsEntry.changePrio(g.weigth(j, v) als Integer)
				}
				
				// 2 Entnehme einen Knoten u mit minimaler Priorität
				u = heap.extractMin();
				
				
				// 3 Wenn Priorität von u == INF: Abbruch! Graph ist nicht zusammenhängend
				if(u.prio() == Double.POSITIVE_INFINITY) {
					return false;					
				}
			}
		}
		
		return true;
	}

	public int pred(int v) {
		return vorgaenger[v];
	}

}
