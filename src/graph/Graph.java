package graph;
import java.util.Set;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public interface Graph {

    int size();

    void addArc(Vertex source, Vertex destination, Vertex predecesseur);

    void addArc(Vertex source, Vertex destination);

    Adjacent<Vertex> getAdjacent();

    boolean isOriented();

    boolean isValued();

    boolean isEmpty();

    Set<Vertex> getVertex();

    void addVertex(Vertex vertex);

    void removeVertex(Vertex vertex);

    //connected by an edge
    Set<Vertex> getAdjacentVertex(Vertex source);

    boolean isExistVertex(Vertex vertex);

    Set<Vertex> getFollowing(Vertex s);

    Set<Vertex> getPrevious(Vertex s);

    void removeArc(Vertex source, Vertex destination);

    boolean isExistArc(Vertex source, Vertex destination);

    boolean  contains (Object object);

    boolean isAdjacentVertexExist(Vertex source, Vertex i);

    }
