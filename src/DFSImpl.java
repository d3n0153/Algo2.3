import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSImpl implements DFS{

	int[] topoSort;
	int[][] dfs; 
	int timestamp = 1;
	Stack graueKn = new Stack();
	
	@Override
	public void search(Graph g) {
		dfs = new int[g.size()][4];
		// [][0] = farbe		(0 = weiß; 	1 = grau; 	2 = schwarz)
		// [][1] = Vorgaenger
		// [][2] = Entdeckungszeit
		// [][3] = Abschlusszeit
		
		
		dfs[0][0] = 1;
		dfs[0][2] = timestamp;
		graueKn.add(0);
		if (g.deg(0) == 0) {
			timestamp++;
		}
	}

	@Override
	public void search(Graph g, DFS d) {
		// TODO Auto-generated method stub
		
	}

	// sortiert die Knoten topologisch 
	public boolean sort(Graph g) {
		
		// Deklarieren 
		topoSort = new int[g.size()];
		List<Integer> topoSortList = new ArrayList();		
		
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
		
//		// Testausgabe Vorgänger nach dem erstellen des Vorgängerarrays
//		for(int x = 0; x < g.size(); x++) {
//			System.out.println(graphWithPres[x]);
//		}
		
		for(int x = 0; x < g.size(); x++) {
			for(int i = 0; i < g.size(); i++) {				
				if (graphWithPres[i] == 0) {
					topoSortList.add(0, i); 	// aktuellen Knoten vorne in Liste einfügen
					graphWithPres[i]--;		// akt Knoten (der 0 Vorgänger hatte) auf -1 setzen
					for(int j = 0; j < g.deg(i); j++) {	
						// Anz der vorgänger der direkten Nachfolger von i um 1 verringern
						graphWithPres[g.succ(i, j)]--;
					}
					break;
				}
			}
		}
		
//		// Testausgabe vorgaenger
//		for(int x = 0; x < g.size(); x++) {
//			System.out.println(graphWithPres[x]);
//		}
		
		//List in Array schreiben 
		if (topoSortList.size() > 0) { // falls 0 kann nicht auf get zugegriffen werden (OutOfBounds)
			for(int x = 0; x < topoSortList.size(); x++) {
				topoSort[x] = topoSortList.get(x);
			}
		}
		
//		// Testausgabe sortierte Knoten
//		for(int x = 0; x < g.size(); x++) {
//			System.out.print(topoSort[x]);
//		}
		
		if (topoSortList.size() != g.size()) {
			//System.out.println("false");
			return false;
		} else {
			//System.out.println("true");
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
