package UnitTest;

import graph.Graph;
import graph.GraphImpl;
import graph.Vertex;
import graph.Warshall;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class TestWarshall
{
    private static Vertex A = new Vertex(1);
    private static Vertex B = new Vertex(2);
    private static Vertex C = new Vertex(3);
    private static Vertex D = new Vertex(4);
    private static Vertex E = new Vertex(5);

    @Test
    public void testSuccessfullCase()
    {
        Graph graph = new GraphImpl(true);
        graph.addArc(A, B);
        graph.addArc(B, C);
        graph.addArc(C, D);
        graph.addArc(E, D);

        Warshall w = new Warshall(graph);
        w.start();

        // Graph expected
        Graph expected = new GraphImpl(true);
        expected.addArc(A, B);
        expected.addArc(B, C);
        expected.addArc(C, D);
        expected.addArc(E, D);
        // must create by warshall algorithm
        expected.addArc(A, D);
        expected.addArc(A, C);
        expected.addArc(B, D);

        // check if same arcs
        Assert.assertTrue(graph.getAdjacent().isSameArcs(expected.getAdjacent()));
    }

    @Test
    public void testJoinAllPoints()
    {
        Graph graph = new GraphImpl(true);
        graph.addArc(C, C);
        graph.addArc(B, B);
        graph.addArc(A, A);
        graph.addArc(C, B);
        graph.addArc(C, A);
        graph.addArc(B, A);
        graph.addArc(B, C);
        graph.addArc(A, B);
        graph.addArc(A, C);

        // Expected
        Graph expected = new GraphImpl(true);
        expected.addArc(C, C);
        expected.addArc(B, B);
        expected.addArc(A, A);
        expected.addArc(C, B);
        expected.addArc(C, A);
        expected.addArc(B, A);
        expected.addArc(B, C);
        expected.addArc(A, B);
        expected.addArc(A, C);

        Warshall w = new Warshall(graph);
        w.start();

        Assert.assertTrue(graph.getAdjacent().isSameArcs(expected.getAdjacent()));
    }
}
