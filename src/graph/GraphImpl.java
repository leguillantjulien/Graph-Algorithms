package graph;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class GraphImpl implements Graph {

    private final Adjacent<Vertex> adjacent;
    private final boolean oriente;

    @Override
    public boolean isOriented()
    {
        return oriente;
    }

    public GraphImpl(boolean oriente)
    {
        this.oriente = oriente;
        this.adjacent = new Adjacent<>();
    }

    @Override
    public Adjacent<Vertex> getAdjacent()
    {
        return adjacent;
    }

    @Override
    public boolean isExistArc(Vertex source, Vertex dest)
    {
        return adjacent.isAdjacent(source, dest);
    }

    @Override
    public void addArc(Vertex source, Vertex dest, Vertex pred)
    {
        addVertex(source);
        addVertex(dest);
        if(pred != null) System.out.println("Add arc : "+source + " --> " + pred + " --> " + dest); //routage
        else System.out.println("Add arc : "+source + " --> " + dest);         // case of no routage

        adjacent.getList().get(source).put(dest, pred);
        if (!isOriented() ) {
            adjacent.getList().get(dest).put(source, pred);
        }
    }

    @Override
    public void addArc(Vertex source, Vertex dest)
    {
        addArc(source, dest, null);
    }

    @Override
    public Set<Vertex> getVertex()
    {
        return adjacent.getList().keySet();
    }

    @Override
    public Set<Vertex> getAdjacentVertex(Vertex source)
    {
        return adjacent.getList().get(source).keySet();
    }

    public boolean isAdjacentVertexExist(Vertex source, Vertex i){
        if(adjacent.getList().get(source).keySet().contains(i)){
            return true;
        }else   return false;
    }

    @Override
    public void addVertex(Vertex Vertex)
    {
        if ( !adjacent.getList().containsKey(Vertex) ) {
            adjacent.getList().put(Vertex, new HashMap<Vertex, Vertex>());
        }
    }

    @Override
    public boolean isExistVertex(Vertex Vertex)
    {
        return getVertex().contains(Vertex);
    }

    @Override
    public void removeVertex(Vertex Vertex)
    {
        adjacent.getList().remove(Vertex, new HashMap<Vertex, Vertex>());
    }

    @Override
    public Set<Vertex> getFollowing(Vertex s)
    {
        return adjacent.getList().get(s).keySet();
    }

    @Override
    public Set<Vertex> getPrevious(Vertex s)
    {
        return adjacent.getList().get(s).keySet();
    }

    @Override
    public void removeArc(Vertex source, Vertex destination)
    {
        adjacent.getList().remove(source,destination);
    }

    @Override
    public boolean isValued() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        boolean b = true;
        for(Vertex v : getVertex()){
            for(Vertex k : getVertex()) {
                if(isExistArc(v,k) || isExistArc(k,v)){
                    b = false;
                }
            }
        }
        return b;
    }

    public boolean contains (Object object) {
        if(adjacent.getList().containsValue(object)){
            return true;
        }else return false;
    }

    public int size(){
        return adjacent.getList().size();
    }

}
