import java.util.ArrayList;
import java.util.List;

public class DFSImpl implements DFS{

	int[][] dfs; 
	int timestamp;
	public List<Integer> topoSortList = new ArrayList();
	Graph graph;
	public boolean ruekwaertskanteGefunden = false;
	
	
	private void nachfolgerDurchsuchen(int i) {
		
		// Falls noch nicht entdeckt, färbe grau und stempel detectionTime
		if(dfs[i][0] == 0) { 
			dfs[i][2] = timestamp++;
			dfs[i][0] = 1;
		}
		
		for(int j = 0; j < graph.deg(i); j++) {
			int v = graph.succ(i, j);
			//pruefen auf Rueckwaertskante
			if(dfs[v][0] == 1) {
				ruekwaertskanteGefunden = true;
			}
			if(dfs[v][0] == 0) {
				dfs[v][1] = i;
				nachfolgerDurchsuchen(v);	// Rekursiver Aufruf
			}
		}
		
		if(dfs[i][0] != 2) {
			dfs[i][3] = timestamp++;
			dfs[i][0] = 2;
			topoSortList.add(i);
		}
	}
	
	
	public void search(Graph g) {
		timestamp = 1;
		graph = g;
		dfs = new int[g.size()][4];
		// [][0] = farbe		(0 = weiß; 	1 = grau; 	2 = schwarz)
		// [][1] = Vorgaenger
		// [][2] = Entdeckungszeit
		// [][3] = Abschlusszeit
		
		for(int i = 0; i < g.size(); i++) {
			if (dfs[i][0] == 0) {
				dfs[i][1] = -1;
			}
			nachfolgerDurchsuchen(i);
		}
	}
	

	@Override
	public void search(Graph g, DFS d) {
		timestamp = 1;
		graph = g;
		dfs = new int[g.size()][4];
		// [][0] = farbe		(0 = weiß; 	1 = grau; 	2 = schwarz)
		// [][1] = Vorgaenger
		// [][2] = Entdeckungszeit
		// [][3] = Abschlusszeit
		
		for(int i = (g.size() - 1); i >= 0;  i--) {
			
			int slk = d.sort(i);
			
			if (dfs[slk][0] == 0) {
				dfs[slk][1] = -1;
			}
			nachfolgerDurchsuchen(slk);
		}
	}

	// sortiert die Knoten topologisch 
	public boolean sort(Graph g) {
		
		search(g);
		
		if(ruekwaertskanteGefunden) {
//			System.out.println("false");
			return false;
		} else {
//			for(int n = 0; n < topoSortList.size(); n++) {
//				System.out.print(topoSortList.get(n));
//			}
//			System.out.println("\n--");
			return true;
		}
	}

	public int det(int v) {
		return dfs[v][2];
	}

	public int fin(int v) {
		return dfs[v][3];
	}

	public int sort(int i) {
		return topoSortList.get(i);
	}

}
