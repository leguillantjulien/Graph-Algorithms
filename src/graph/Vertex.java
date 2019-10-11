package graph;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class Vertex {

    private final int value;

    public Vertex(int value)
    {
        this.value = value;
    }

    public int getValueVortex()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return ""+value;
    }

}
