package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Edge.OrientedEdge;
import graphPackage.Node.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class OrientedGraph<NODE_VALUE_T,EDGE_VALUE_T> extends Graph<NODE_VALUE_T,EDGE_VALUE_T,OrientedEdge<EDGE_VALUE_T,NODE_VALUE_T>>{


    public OrientedGraph()
    {
        super();
    }

    public OrientedGraph(List<Node<NODE_VALUE_T>> nodes, List<OrientedEdge<EDGE_VALUE_T, NODE_VALUE_T>> edges) {
        super(nodes, edges);
    }

    @Override
    public double graphDensity() {
        return (double) this.edgesList.size() / this.nodesList.size() * this.nodesList.size();
    }

    public static<NODE_VALUE_FROM,NODE_VALUE_TO,EDGE_VALUE extends OrientedEdge<EDGE_VALUE, NODE_VALUE_FROM>> OrientedGraph<NODE_VALUE_TO, EDGE_VALUE> createsIsomorphism(OrientedGraph<NODE_VALUE_FROM, EDGE_VALUE> g1, Function<Node<NODE_VALUE_FROM>,Node<NODE_VALUE_TO>> nodeFunction) {

        OrientedGraph<NODE_VALUE_TO, EDGE_VALUE> isoGraph = new OrientedGraph<>();

        Map<Node<NODE_VALUE_FROM>,Node<NODE_VALUE_TO>> map = new HashMap<>();

        for (Node<NODE_VALUE_FROM> tmp : g1.nodesList) {
            Node<NODE_VALUE_TO> isoNode = nodeFunction.apply(tmp);
            isoGraph.nodesList.add(isoNode);
            map.put(tmp,isoNode);
        }

        for (OrientedEdge<EDGE_VALUE,NODE_VALUE_FROM> edge : g1.edgesList) {
            isoGraph.addEdge(new OrientedEdge<>(edge.getValue(),map.get(edge.getNode1()),map.get(edge.getNode2())));
        }

        return isoGraph;
    }

    public static List<Boolean> computeOrientedGraph(OrientedGraph<?, ?> graph, List<Node<Integer>> path)
    {
        List<Boolean> proprieties = new ArrayList<>();

        boolean isPath = true;
        boolean isSimplePath = true;
        boolean isClosedPath = true;
        boolean isCycle = true;

        for(int i = 0; i < path.size() - 1;i++)
        {
            OrientedEdge edge = new OrientedEdge(null,path.get(i),path.get(i+1));
            if (!graph.containsEdge(edge))
            {
                isPath = false;
                isSimplePath = false;
                isCycle = false;
                isClosedPath = false;

                proprieties.add(isPath);
                proprieties.add(isSimplePath);
                proprieties.add(isClosedPath);
                proprieties.add(isCycle);

                return proprieties;
            }
        }

        for (int i = 0; i < path.size()-1;i++)
        {
            for(int j = i+1; j < path.size();j++)
            {
                if (path.get(i).equals(path.get(j)))
                {
                    isSimplePath = false;
                }
            }
        }


        if (!path.get(0).equals(path.get(path.size()-1)))
        {
            isClosedPath = false;
        }

        if (!isClosedPath || !isSimplePath )
            isCycle = false;

        proprieties.add(isPath);
        proprieties.add(isSimplePath);
        proprieties.add(isClosedPath);
        proprieties.add(isCycle);

        return proprieties;

    }


}
