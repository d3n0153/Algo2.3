// Testprogramm fÃ¼r Graphalgorithmen.
class EigeneMain {
	// Testgraphen.


	public static void main (String [] args) {
		
		GraphImpl heilo = new GraphImpl(new int [] [] {
		    { 1, 2, 3 },	// Knoten 0 hat als Nachfolger Knoten 1 und 2.
		    { 0, 3 },	// Knoten 1 hat keine Nachfolger.
		    { 2, 1 },
		    { 0 }// Knoten 2 hat als Nachfolger sich selbst.
		});
		
	    BFS bfs = new BFSImpl();
	    bfs.search(heilo, 0);
	    for (int v = 0; v < 3; v++) {
	    		System.out.println(v + " dist " + bfs.dist(v) + " pred " + bfs.pred(v));
	    }
	    
	    heilo.print();
	    
	    heilo = (GraphImpl) heilo.transpose();
	    System.out.println("__________________");
	    heilo.print();
	 
	    
	    int[][] lilo = {{2, 3, 4},{1}};
	    lilo[0] = 
	    
	    int lk = lilo[1][2];
	    System.out.println(lk);
	    
	}

}