package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class Foulkes {

    protected Graph graph;
    protected List<Vertex> NE;
    protected List<Vertex> cfc;

    public Foulkes (Graph graph){
        this.graph = graph;
        NE = new ArrayList<>(graph.getVertex());
    }



    public void start() {
        for (Vertex i : graph.getVertex()) {
            cfc = new ArrayList<>();
            if(NE.contains(i)){
                NE.remove(i);
                cfc.add(i);
                if(graph.isExistArc(i,i)){
                    for (Vertex j : graph.getVertex()) {
                        if(graph.isExistArc(i,j) && graph.isExistArc(j,i) && !cfc.contains(j)){
                            cfc.add(j);
                            NE.remove(j);
                        }
                    }
                }
                System.out.println("CFC of "+i.getValueVortex() + " = "+cfc);
            }
        }
    }

}
