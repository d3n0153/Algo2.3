import java.util.ArrayList;
import java.util.List;

public class WeightedGraphImpl implements WeightedGraph{
	
	int anzKnoten;
	int[][] graph = new int[anzKnoten][anzKnoten];
	double[][] weights = new double[anzKnoten][anzKnoten];
	
	// Konstruktor bekommt ein 2D Array (Adjazentmatrix des Graphen) und 2D Array der gewichteten Kanten
	public WeightedGraphImpl(int[][] g, double[][] we) {
		
		anzKnoten = g.length;
		graph = g;
		weights = we;
	}

	public int size() {
		return anzKnoten;
	}

	public int deg(int v) {
		return graph[v].length;	
	}

	public int succ(int v, int i) {
		return graph[v][i];
	}

	@Override
	public Graph transpose() {
		
		// 1. Wird nachher der Graph der returned wird
		int[][] graphTrans = new int[anzKnoten][];
		double[][] weightTrans = new double[anzKnoten][];
		
		// erstelle ein Array aus Arraylists. Jeder Knoten bekommt eine Liste
		List<Integer>[] dummyGraph = new ArrayList[anzKnoten];
		for(int i=0; i < anzKnoten; i++) {
			dummyGraph[i] = new ArrayList<Integer>();	// Füllen des Arrays mit ArrayListen
		}
		
		List<Double>[] dummyWeights = new ArrayList[anzKnoten];
		for(int i=0; i < anzKnoten; i++) {
			dummyWeights[i] = new ArrayList<Double>();	// Füllen des Arrays mit ArrayListen
		}
		
		// Transponieren, umdrehen aller Pfeile
		for(int i = 0; i < anzKnoten; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				int a = graph[i][j];			// Knoten auf den Knoten i zeigt
				double b = weights[i][j];	// Gewicht der Kante i nach v
				dummyGraph[a].add(i); 		// Knoten i wird nun in die List von Knoten a geschrieben
				dummyWeights[a].add(b);		// man schreibt für den Knoten auf den der Knoten i zeigt, 
											// das Gewicht in die jeweilige Liste
			}					
		}
		
		// 2D-Array graphTrans mit den Werten aus Dummy fuellen
		for(int i = 0; i < anzKnoten; i++) {
			graphTrans[i] = new int[dummyGraph[i].size()];
			weightTrans[i] = new double[dummyWeights[i].size()];
			for(int j = 0; j < dummyGraph[i].size(); j++) {
				graphTrans[i][j] = dummyGraph[i].get(j);
				weightTrans[i][j] = dummyWeights[i].get(j);
			}
		}
		return new WeightedGraphImpl(graphTrans, weightTrans);
	}

	public double weight(int v, int i) {
		return weights[v][i];
	}
	
	public void print() {
		 for(int i = 0; i < anzKnoten; i++) {
	    		for(int j = 0; j < graph[i].length; j++) {
	    			System.out.println("graph[" + i + "][" + j + "] = " + graph[i][j]);
	    			System.out.println("weights[" + i + "][" + j + "] = " + weights[i][j]);
	    		}
	    }
	}
}
