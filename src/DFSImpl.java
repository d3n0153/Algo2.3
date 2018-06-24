import java.util.ArrayList;
import java.util.List;

public class DFSImpl implements DFS{

	int[] topSort;
	
	@Override
	public void search(Graph g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Graph g, DFS d) {
		// TODO Auto-generated method stub
		
	}

	// sortiert die Knoten topologisch 
	public boolean sort(Graph g) {
		
		// Deklarieren 
		topSort = new int[g.size()];
		List<Integer> topSortList = new ArrayList();		
		
		// die anzahl der Vorgänger mit 0en überschreiben. Jeder hat jetzt 0 Vorgänger
		int [] graphWithPres = new int[g.size()];
		for(int i = 0; i < g.size(); i++) {
			graphWithPres[i] = 0;
		}
		
		// die Anzahl der Vorgänger in das graphWithPres schreiben
		for(int i = 0; i < g.size(); i++) {
			for(int j = 0; j < g.deg(i); j++) {
				graphWithPres[g.succ(i, j)]++;
			}
		}
		
		// Testausgabe
		for(int x = 0; x < g.size(); x++) {
			System.out.println(graphWithPres[x]);
		}
		
		for(int x = 0; x < g.size(); x++) {
			for(int i = 0; i < g.size(); i++) {				
				if (graphWithPres[i] == 0) {
					topSortList.add(0, i); 	// aktuellen Knoten vorne in Liste einfügen
					graphWithPres[i]--;		// akt Knoten (der 0 Vorgänger hatte) auf -1 setzen
					for(int j = 0; j < g.deg(i); j++) {	
						// Anz der vorgänger der direkten Nachfolger von i um 1 verringern
						graphWithPres[g.succ(i, j)]--;
					}
					break;
				}
			}
		}
		
		// Testausgabe
		for(int x = 0; x < g.size(); x++) {
			System.out.println(graphWithPres[x]);
		}
		
		//List in Array schreiben 
		if (topSortList.size() > 0) {
			for(int x = 0; x < topSortList.size(); x++) {
				topSort[x] = topSortList.get(x);
			}
		}
		
		// Testausgabe sortierte Knoten
		for(int x = 0; x < g.size(); x++) {
			System.out.print(topSort[x]);
		}
		
		if (topSortList.size() != g.size()) {
			System.out.println("Graph ist zyklisch");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int det(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fin(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sort(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
