package graphPackage;

public class LabeledBranches<U extends Node> extends Branches<U>{
    public String _label;

    public LabeledBranches(U u,U v, String label)
    {
        super(u,v);
        this._label = label;
    }

}
