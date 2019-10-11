package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by julienleguillant on 15/11/2017.
 */
    public class Adjacent<T>
    {
        private final HashMap<Vertex, HashMap<Vertex, T>> listAdjancence;

        public Adjacent()
        {
            this.listAdjancence = new HashMap<>();
        }

        public HashMap<Vertex, HashMap<Vertex, T>> getList()
        {
            return listAdjancence;
        }
        
        public boolean isAdjacent(Vertex src, Vertex dest)
        {
            if ( listAdjancence.containsKey(src) ) {
                if ( listAdjancence.get(src).containsKey(dest) ) {
                    return true;
                }
            }
            return false;
        }

        public boolean isSameArcs(Adjacent<T> other)
        {
            if ( !listAdjancence.keySet().equals(other.listAdjancence.keySet()) ) {
                return false;
            }

            for ( Map.Entry<Vertex, HashMap<Vertex, T>> item : listAdjancence.entrySet() ) {
                Vertex src = item.getKey();
                HashMap<Vertex, T> link = item.getValue();
                HashMap<Vertex, T> otherLink = other.listAdjancence.get(src);
                if ( !link.keySet().equals(otherLink.keySet()) ) {
                    return false;
                }
            }

            return true;
        }
    }

