package graphPackage;

// sono passato da classe ad interfaccia
public interface AdjacencyMatrixInterface<V extends Node,E extends Branches<V>> {

    // mi rappresenta la struttura dati di una matrice di adiacenza, poichè non voglio avere l'indice posizionale ma voglio che dato un due
    // istanze mi ritorna se esiste o meno l'arco / il peso dell arco.
    // NB potrei anche usare gli id dei nodi però non mi piace molto, voglio una univocità robusta e anche la garanzia di non poterla perdere

    // la mia idea sarebbe quella di tenermi una lista interna dove mi salvo tutti i nodi dove mappo nodo con un indice intero
    // e una matrice posizionale dove accedo con l indice intero

    void addNodeToList(V node);
    void addBranchToAdjMatrix(E branch);
    Integer getNodeIndex();
    E getBranch(V node1,V node2);




}
