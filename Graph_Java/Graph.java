import java.util.*;
import java.io.*;


public class Graph  {

     int NbVertices;
     int NbEdges;
     List<Integer> Vertices; 
     List<List<Integer>> Edges;
     Random random = new Random();
 //    Map<Integer,List<List<Integer>>> AdjacencyList; 
     int [][] AdjacencyMatrix;


     Graph(String name){  
        
        File input = new File(name);

        List<List<Integer>> edges =  new  ArrayList<List<Integer>>();

        try{
         


            Scanner reader = new Scanner(input);

                while (reader.hasNextLine()) {

                    


                 String[] nums = reader.nextLine().split(",");

                 if(nums.length < 3){
                 this.NbVertices = Integer.parseInt(nums[0]);
                  this.NbEdges = Integer.parseInt(nums[1]);
                  this.AdjacencyMatrix = new int[this.NbVertices][this.NbVertices];
                  this.Vertices = new ArrayList<Integer>();

                  for(int i = 0; i < NbVertices; i++){
                    this.Vertices.add(i);
                  }

                 }else{



        
                edges.add(Arrays.asList(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]),  Integer.parseInt(nums[2])));
                 }
               }

               this.Edges = edges; 

              for(List<Integer> elem: edges){
            
                this.AdjacencyMatrix[elem.get(0)][elem.get(1)] = elem.get(2);
        
             }
            
            

            reader.close();
            
    
    
          

        }catch (IOException e) {
            System.out.println("no file");
           }

        }


     

  

      public void randomGraph(int nbvertices, int nbEdges, boolean oriented){

        int u = 0;
        int v = 0;
        int p = 0;
        List<Integer> vertices = new ArrayList<Integer>(); 
        List<List<Integer>> edges =  new  ArrayList<List<Integer>>();
        int [][] adjacencyMatrix = new int[nbvertices][nbvertices];
   //     Map<Integer,List<List<Integer>>> adjacencyList = new HashMap<>(nbvertices);





           
        for(int i = 0; i < nbvertices  ; i++)
        {
            vertices.add(i);


        }

        for(int i = 0; i < nbEdges; i++){

            u = (int)(Math.random() * (nbvertices));
            v = (int)(Math.random() * (nbvertices));
            p = (int)(Math.random() * (10));
            
            if (oriented == true && u > v){
                 edges.add(Arrays.asList(v,u,p));

            }else{

            edges.add(Arrays.asList(u,v,p));


            }
        }

         for(List<Integer> elem: edges){
            
            adjacencyMatrix[elem.get(0)][elem.get(1)] = elem.get(2);
        
        }




    
        
        
        this.NbVertices = nbvertices;
        this.NbEdges = nbEdges;
        this.Vertices = vertices;
        this.Edges = edges; 
        this.AdjacencyMatrix = adjacencyMatrix;
  //      this.AdjacencyList = adjacencyList;
    
    }


    public void addEdge(int prec, int succ, int pounds){

        Edges.add(Arrays.asList(prec,succ,pounds));
        AdjacencyMatrix[prec][succ] = 1;
    }



        
      



public void displayGraph(){

        System.out.println("Le nombre de sommets est: " + NbVertices);
        System.out.println("Le nombre d'arrêtes est: " + NbEdges);
        System.out.println("La liste des sommet est: " + Vertices);
        System.out.println("la liste des arrêtes est: " + Edges);
        System.out.println("la matrice d'adjacence est: " );
        for (int r = 0; r < AdjacencyMatrix.length; r++) {
			for (int c = 0; c < AdjacencyMatrix[0].length; c++) {
				System.out.print(AdjacencyMatrix[r][c] + "\t");
			}
			System.out.println();
		}


  

    //    for(int r = 0; r < AdjacencyList.size(); r++){

      //      	System.out.print(AdjacencyList.get(r)+ "\t");



       // }





    
}
}





    

