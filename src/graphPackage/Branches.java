package graphPackage;
import java.lang.Object;
public class Branches <U extends Node> implements BranchesInterface{

    protected Pair<U,U> branch;

    public Branches(U u,U v)
    {
        branch = new Pair<>(u,v);
    }

    public Pair<U, U> getBranch() {
        return branch;
    }
}
