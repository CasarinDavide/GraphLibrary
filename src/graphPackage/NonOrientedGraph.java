package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Edge.NonOrientedEdge;
import graphPackage.Node.Node;

import java.util.*;

public class NonOrientedGraph<NODE_VALUE_T,EDGE_VALUE_T> extends Graph<NODE_VALUE_T,EDGE_VALUE_T, NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>>{

    public NonOrientedGraph() {
        super();
    }

    public NonOrientedGraph(List<Node<NODE_VALUE_T>> nodes, List<NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T>> edges) {
        super(nodes, edges);
    }

    public NonOrientedGraph(List<Node<NODE_VALUE_T>> nodes) {
        super(nodes);
    }


    @Override
    public double graphDensity() {
        return (double) this.edgesList.size() * 2 / this.nodesList.size() * this.nodesList.size() - this.nodesList.size() ;
    }


    public NonOrientedGraph<NODE_VALUE_T, EDGE_VALUE_T> kruskalAlgorithm(Comparator<NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> comparator) {

        // assume that is given connected graph
        DisjointSetTree<Node<NODE_VALUE_T>> disjointSet = new DisjointSetTree<>();

        for (Node<NODE_VALUE_T> node: this.nodesList) {
            disjointSet.makeSet(node);
        }

        NonOrientedGraph<NODE_VALUE_T, EDGE_VALUE_T> minimumSpanningTree = new NonOrientedGraph<>(this.nodesList);

        // Sorting
        List<NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T>> sortedEdges = Edge.sortEdge(this.edgesList, comparator);

        for (NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T> edge : sortedEdges) {
            if (disjointSet.findSet(edge.getNode1()) != disjointSet.findSet(edge.getNode2()))
            {
                disjointSet.unionSet(edge.getNode1(),edge.getNode2());
                minimumSpanningTree.addEdge(edge);
            }
        }

        return minimumSpanningTree;
    }


    public PredecessorGraph<NODE_VALUE_T,NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> primAlgorithm(Comparator<NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> comparator)
    {
        // assume that is given connected graph

        PredecessorGraph<NODE_VALUE_T,NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> predecessorGraph = new PredecessorGraph<>(this.nodesList,this.nodesList.get(0),comparator);
        // utilizzo coda di priorità minima
        PriorityQueue<PredecessorNode<NODE_VALUE_T,NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>>> queue;
        queue = new PriorityQueue<>();
        queue.addAll(predecessorGraph.getNodeList());

        // creating a hashmap for storing already visited Edge
        // since java doesnt re-sort queue after modyfing queue's element's value

        Map<PredecessorNode<NODE_VALUE_T,NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>>,Boolean> visitedProdecessorNode = new HashMap<>();

        while (!queue.isEmpty())
        {
            PredecessorNode<NODE_VALUE_T,NonOrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>> predecessorNode = queue.poll();

            if (visitedProdecessorNode.get(predecessorNode) == null)
            {
                visitedProdecessorNode.put(predecessorNode,true);

                Node<NODE_VALUE_T> node = predecessorNode.getNode();
                for (NonOrientedEdge<EDGE_VALUE_T, NODE_VALUE_T> adj_edge: this.getAllAdjacentEdge(node)) {

                    Node<NODE_VALUE_T> adj_node = adj_edge.getToDestination(node);

                    if (predecessorGraph.getPredecessorNode(adj_node).compareTo(adj_edge) > 0)
                    {
                        predecessorGraph.setNodePredecessor(adj_node,node);
                        predecessorGraph.setNodeKey(adj_node,adj_edge);

                        // re add to queue for forcing re sorting without delete the older edge since i can sore which edge i have already visited
                        queue.add(predecessorGraph.getMappedPredecessorNode(adj_node));
                    }

                }
            }
        }

        return predecessorGraph;

    }




}
