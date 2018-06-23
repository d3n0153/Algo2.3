// Testprogramm fÃ¼r Graphalgorithmen.
class EigeneMain {
	// Testgraphen.


	public static void main (String [] args) {
		
		Graph heilo = new GraphImpl(new int [] [] {
		    { 1, 2},	// Knoten 0 hat als Nachfolger Knoten 1 und 2.
		    {},	// Knoten 1 hat keine Nachfolger.
		    {2}, // Knoten 2 hat als Nachfolger sich selbst.
		});
		
		Graph test = new GraphImpl(new int[][] {
			{1, 2},
			{2},
			{3},
			{}
		});
		
	    BFS bfs = new BFSImpl();
	    bfs.search(heilo, 0);
	    for (int v = 0; v < 3; v++) {
	    		System.out.println(v + " dist " + bfs.dist(v) + " pred " + bfs.pred(v));
	    }
	    
	    heilo.print();
	    
	    heilo = heilo.transpose();
	    System.out.println("__________________");
	    heilo.print();
	    System.out.println("__________________");
	    heilo = heilo.transpose();
	    heilo.print();
	    
	    int[][] graph = {{1, 2},{0, 2},{3},{1, 3}};
	    double[][] weightsToGraph = {{2, 4}, {-1.5, 7}, {11}, {1, 8}};
	    
	    Graph wg = new WeightedGraphImpl(graph, weightsToGraph);
	    
	    System.out.println("__________________");
	    System.out.println("__________________");
	    wg.print();
	    System.out.println("__________________");
	    wg = wg.transpose();
	    wg.print();
	    
	    System.out.println("________BFS_TEST__________");
	    
	    BFS bubbie = new BFSImpl();
	    bubbie.search(test, 0);
	    int a0 = bubbie.dist(3);
	    int a1 = bubbie.pred(3);
	    System.out.println("dist: " + a0);
	    System.out.println("pred: " + a1);
	}

}