package graph;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class Warshall {

    protected final Graph graph;

    public Warshall(Graph graph) {
        this.graph = graph;
    }

    public Graph start() {
        for (Vertex k : graph.getVertex()) {
            for (Vertex i : graph.getVertex()) {
                if (graph.isExistArc(i, k)) {
                    for (Vertex j : graph.getVertex()) {
                        if (graph.isExistArc(k, j)) {
                            if (!graph.isExistArc(i, j)) {
                                graph.addArc(i, j, k);
                            }
                        }
                    }
                }
            }
        }


        System.out.println("All successors accessible by these points : ");

        for (Vertex v : graph.getVertex()) {
            System.out.println(v +" = "+ graph.getAdjacentVertex(v));
        }

        return this.graph;
    }
}


