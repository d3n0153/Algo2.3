
public class SCCImpl implements SCC{

	@Override
	public void compute(Graph g) {
		DFSImpl dfs = new DFSImpl();
		dfs.search(g);
		g = g.transpose();
		dfs.search(g);
	}

	@Override
	public int component(int v) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
