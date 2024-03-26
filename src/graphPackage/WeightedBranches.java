package graphPackage;

public class WeightedBranches<U extends Node> extends Branches<U>{

    int _weight;
    public WeightedBranches(U u, U v, int weight)
    {
        super(u,v);
        this._weight = weight;
    }

}
