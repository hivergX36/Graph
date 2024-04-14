
class Edge{
    public:

    int pred, succ;
};



class Succ{

    public: 

    int succ, weight;
};


struct list_adjacence{

    public:
    int V;
    std::vector<Succ>*l;


    list_adjacence(int Nbsommet){
        
         V = Nbsommet;
         l = new std::vector<Succ>[Nbsommet];
     
    };
   

    void add_edges(int x, int y, int w){

        l[x].push_back({y,w});

    };

    void display_graph(){

        for(int i = 0; i < V; i ++){
            std::cout << i  << " --> " << " " ;
            for (Succ el : l[i])
            {
                std::cout << "succ: "<< el.succ << " "  << "weight: " << el.weight << " " ;
            
            };

            std::cout << std::endl;
        };


    };




    void breadthFistSearch(list_adjacence graph){
    int  prec; 
    int  Distsucc;
    int  distance;
    int  Lenght;
    int Nodes[V];
    int chemin[V];
    int dist[V];
    bool visit[V];
    int orderVisit[V];
    std::queue<int>QNbNode;

    for(int i = 0; i < V + 1; i++){
        Nodes[i] = i;
        visit[V] = 0; 

    } 
    
  
    QNbNode.push(Nodes[0]);
    Lenght = QNbNode.size();
    
    while (Lenght > 0)
    {
    prec = QNbNode.front();
    std::cout << "Le predecesseur est: " << prec << " " << std::endl;
    QNbNode.pop();

    for (Succ el : graph.l[prec])
    {
        if(visit[el.succ < 1]){
        std::cout << "le successeur est: " << el.succ << std::endl;


            chemin[el.succ] = prec;
            QNbNode.push(el.succ);
            visit[el.succ] = 1;

        }
        
        };
    Lenght = QNbNode.size();
    std::cout << "La longueur de la pile est: " << Lenght << std::endl;
    }

    for(int i = 0; i < V + 1; i++){
        std::cout << chemin[i] << " ";
    }
 
    

};




    void display_circuit(std::vector<int> circuit){
    for(int i = 0; i < circuit.size(); i++){
    std::cout << circuit[i] << " ";
    }
    std::cout<< std::endl;
};

};