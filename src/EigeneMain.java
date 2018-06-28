// Testprogramm fÃ¼r Graphalgorithmen.
class EigeneMain {
	// Testgraphen.


	public static void add(int i) {
		i = i + 1;
	}
	
	public static int addInt(int i) {
		i = i + 1;
		return i;
	}
	
	public static void main (String [] args) {
		
		Graph heilo = new GraphImpl(new int [] [] { // zyklisch
		    { 1, 2},	// Knoten 0 hat als Nachfolger Knoten 1 und 2.
		    {},	// Knoten 1 hat keine Nachfolger.
		    {2}, // Knoten 2 hat als Nachfolger sich selbst.
		});
		
		Graph heiloAzykl = new GraphImpl(new int [] [] { // azyklisch
		    { 1, 2},	// Knoten 0 hat als Nachfolger Knoten 1 und 2.
		    {},	// Knoten 1 hat keine Nachfolger.
		    {}, // Knoten 2 hat als Nachfolger sich selbst.
		});
		
		Graph test = new GraphImpl(new int[][] {
			{1, 2},
			{2},
			{3},
			{}
		});
		
		Graph dfsTest = new GraphImpl(new int[][] { 
			{1},
			{},
			{0, 3},
			{}
		});
		
		Graph dfsTest2 = new GraphImpl(new int[][] {
			{1},
			{2},
			{0, 3},
			{}
		});
		
		Graph dfsTest3 = new GraphImpl(new int[][] { // zyklisch
			{1, 3, 4},
			{5},
			{},
			{4},
			{5, 6, 7},
			{2, 8},
			{3},
			{6},
			{}
		});
		
		Graph dfsTest4 = new GraphImpl(new int[][] { // azyklisch
			{1, 3, 4},
			{5},
			{},
			{4},
			{5},
			{2, 8},
			{3},
			{6},
			{}
		});
		
	    BFS bfs = new BFSImpl();
	    bfs.search(heilo, 0);
	    for (int v = 0; v < 3; v++) {
	    		System.out.println(v + " dist " + bfs.dist(v) + " pred " + bfs.pred(v));
	    }
	    
	    //heilo.print();
	    
	    heilo = heilo.transpose();
	    System.out.println("__________________");
	    //heilo.print();
	    System.out.println("__________________");
	    heilo = heilo.transpose();
	    //heilo.print();
	    
	    int[][] graph = {{1, 2},{0, 2},{3},{1, 3}};
	    double[][] weightsToGraph = {{2, 4}, {-1.5, 7}, {11}, {1, 8}};
	    
	    Graph wg = new WeightedGraphImpl(graph, weightsToGraph);
	    
	    System.out.println("__________________");
	    System.out.println("__________________");
	    //wg.print();
	    System.out.println("__________________");
	    wg = wg.transpose();
	    //wg.print();
	    
	    // BFS TEST
	    System.out.println("________BFS_TEST__________");	    
	    BFS bubbie = new BFSImpl();
	    bubbie.search(test, 0);
	    int a0 = bubbie.dist(3);
	    int a1 = bubbie.pred(3);
	    System.out.println("dist: " + a0);
	    System.out.println("pred: " + a1);
	    System.out.println("________BFS_TEST_ENDE_____");	 
	    
	    int zahl = 5;
	    add(zahl);
	    System.out.println(zahl);
	    zahl = addInt(zahl);
	    System.out.println(zahl);
	    
	    int [] hadde = null;
	    if (hadde == null) {
	    		System.out.println("hadde war null");
	    }
	    hadde = new int[3];
	    hadde[0] = 1;
	    hadde[1] = 2;
	    hadde[2] = 3;
	    if (hadde != null) {
	    		System.out.println("hadde wurde beschrieben");
	    }
	    hadde = null;
	    if (hadde == null) {
	    		System.out.println("hadde war null");
	    }
	    hadde = new int[7];
	    for(int i = 0; i < 7; i++) {
	    		hadde[i] = i;
	    		System.out.println(hadde[i]);
	    }
	     
	     System.out.println("________DFS_TEST__________");	
	     
	     DFS dede = new DFSImpl();
	     
	     dede.search(heiloAzykl);
	     dede.sort(heiloAzykl);
	     
	     int dt2 = dede.det(0);
	     System.out.println(dt2);
	     
	     int ft2 = dede.fin(0);
	     System.out.println(ft2);
	     
	     dede.search(heiloAzykl, dede);
	     
	     int dt3 = dede.det(0);
	     System.out.println(dt3);
	     
	     int ft3 = dede.fin(0);
	     System.out.println(ft3);
	     System.out.println("________DFS_TEST_ENDE_____");
	     System.out.println("________MST_TEST__________");
	     
	     WeightedGraph muschi = new WeightedGraphImpl(new int [][] {
	    	 {1,2},
	    	 {0,2},
	    	 {0,1}
	     }, new double [][] {
	    	 	{10,20},	
	    	 	{50,10},
	    	 	{20,33},
	     });
	     
	     WeightedGraph penis = new WeightedGraphImpl(new int [] [] {
	    		 {1,2},
	    		 {3,4},	
	    		 {3,4},
	    		 {4,5},
	    		 {5},
	    		 {}
	     }, new double [] [] {
	    		 {10,20},	
	    		 {50,10},
	    		 {20,33},
	    		 {-20,-2},
	    		 {1},
	    		 {}
	     });
	     System.out.println(penis.succ(1, 0));
	     MST mst = new MSTImpl();
	     mst.compute(muschi, 1);
	     for (int i = 0; i < muschi.size(); i++) {
	    	 System.out.println(mst.pred(i));
		}

			
		//Positiver Kreis
		new WeightedGraphImpl(new int [] [] {
		                 {1}, //a
		                 {2}, //b	
		                 {4}, //c
		                 {1}, //d
		                 {3,5},//e
							{} //f
		         }, new double [] [] {
		                 {10},	
		                 {10},
		                 {7},
		                 {5},
		                 {5,15},
							{}
		         });
		
		//Negativer Kreis
		new WeightedGraphImpl(new int [] [] {
		                 {1}, //a
		                 {2}, //b	
		                 {4}, //c
		                 {1}, //d
		                 {3,5},//e
							{} //f
		         }, new double [] [] {
		                 {10},	
		                 {1},
		                 {3},
		                 {4},
		                 {-10,22},
							{}
		         });
		
		//Gro�st�dte Europas
		
		new WeightedGraphImpl(new int [] [] {
		                 {5,7,8}, //a 0
		                 {5,6,7,9}, //b	1
		                 {4,5}, //c 2
		                 {6,9}, //d 3
		                 {2,5,9},//e  4
							{0,1,2,4}, //f 5
							{1,3,7}, //g 6
		                 {0,1,6}, //h 7 
		                 {0}, //i 8
							{1,3,4} //j 9
		         }, new double [] [] {
		                 {343,1435,464},	
		                 {879,954,811,524},
		                 {1364,1054},
		                 {433,1053},
		                 {1364,1106,766},
							{343,879,1054,1106},
							{954,433,837},
		                 {1435,811,837},
		                 {464},
							{524,1053,766}
		         });
		https://www-m9.ma.tum.de/graph-algorithms/spp-dijkstra/index_de.html
		//Standartbeispiel
		new WeightedGraphImpl(new int [] [] {
		                 {1,2},
		                 {3,4},	
		                 {3,4},
		                 {4,5},
		                 {5},
							{}
		         }, new double [] [] {
		                 {10,20},	
		                 {50,10},
		                 {20,33},
		                 {20,2},
		                 {1},
							{}
		         });
					
		//Kreis
		new WeightedGraphImpl(new int [] [] {
		                 {1}, //a
		                 {2}, //b	
		                 {4}, //c
		                 {1}, //d
		                 {3,5},//e
							{} //f
		         }, new double [] [] {
		                 {10},	
		                 {1},
		                 {3},
		                 {4},
		                 {10,22},
							{}
		         });
					
		//Gro�st�dte Europas
		
		new WeightedGraphImpl(new int [] [] {
		                 {5,7,8}, //a 0
		                 {5,6,7,9}, //b	1
		                 {4,5}, //c 2
		                 {6,9}, //d 3
		                 {2,5,9},//e  4
							{0,1,2,4}, //f 5
							{1,3,7}, //g 6
		                 {0,1,6}, //h 7 
		                 {0}, //i 8
							{1,3,4} //j 9
		         }, new double [] [] {
		                 {343,1435,464},	
		                 {879,954,811,524},
		                 {1364,1054},
		                 {433,1053},
		                 {1364,1106,766},
							{343,879,1054,1106},
							{954,433,837},
		                 {1435,811,837},
		                 {464},
							{524,1053,766}
		         });
	     
	     
	}

}