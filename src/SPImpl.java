
public class SPImpl implements SP{
	int[][] tab;

	@Override
	public boolean bellmanFord(WeightedGraph g, int s) {
		tab = new int[g.size()][2];
		for (int i = 0; i < tab.length; i++) {
				tab[i][0] = -1;
				tab[i][1] = -1;				
		}
		tab[s][0] = 0;
		// v ist Nachfolger Knoten
		for (int i = 0; i < tab.length; i++) {
			int v = g.succ(i, 0);
			double wv = g.weight(i, v);
			int dv = (int) ((SPImpl) g).dist(v);
			if (tab[i][0] + wv < dv){
				
			}
			
		}
		
		
		
		
		
		return false;
	}

	@Override
	public void dijkstra(WeightedGraph g, int s) {
		// TODO Auto-generated method stub
		
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
