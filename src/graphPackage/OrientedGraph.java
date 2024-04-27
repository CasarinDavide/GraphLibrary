package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.ArrayList;
import java.util.List;

public class OrientedGraph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE extends OrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> extends Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE>{


    /*

        - Dato un grafo orientato g, data una sequenza di nodi n1,…,ni computare se
            - è un cammino (esiste un arco tra un nodo e il successivo)
            - è un cammino semplice (non ci sono nodi ripetuti)
            - è un cammino chiuso (n1 == ni)
            - è un un ciclo (cammino semplice e chiuso)
     */


    static List<Boolean> computeOrientedGraph(OrientedGraph<?,?,?> graph,List<Node<?>> path)
    {
        List<Boolean> proprieties = new ArrayList<>();




        return proprieties;

    }

}
