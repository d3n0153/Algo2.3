
public class SCCImpl implements SCC{

	private Graph g;
	@Override
	public void compute(Graph g) {
		DFSImpl dfs = new DFSImpl();
		dfs.search(g);
		g = g.transpose();
		dfs.search(g);
		this.g = g;
	}

	@Override
	public int component(int v) {
		int r = g.succ(v, 0);
		for (int i = 1; r != 0; i++) {
			r = g.succ(v, i);
		}
		// WAS SOLL ZURUECK GEGEBEN WERDEN ?????
		return 0;
	}
	
}
