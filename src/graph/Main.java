package graph;

/**
 * Created by julienleguillant on 15/11/2017.
 */
public class Main {

    private static Vertex A = new Vertex(1);
    private static Vertex B = new Vertex(2);
    private static Vertex C = new Vertex(3);
    private static Vertex D = new Vertex(4);
    private static Vertex E = new Vertex(5);
    private static Vertex F = new Vertex(6);
    private static Vertex G = new Vertex(7);
    private static Vertex H = new Vertex(8);
    private static Vertex I = new Vertex(9);
    private static Vertex J = new Vertex(10);
    private static Vertex K = new Vertex(11);
    private static Vertex L = new Vertex(12);

    public static void main(String[]argvs){

        testFoulkes();
        //testWarshall();
        //testWarshall2();
    }

    public static void testFoulkes(){
        // Test n°1 Exemple cours
        System.out.println("\nFoulkes : ");
        Graph graph = new GraphImpl(true);
        //1
        graph.addArc(A,L);
        //2
        graph.addArc(B,A);
        graph.addArc(B,C);
        //3
        graph.addArc(C,J);
        //4
        graph.addArc(D,E);
        graph.addArc(D,F);
        //5
        graph.addArc(E,D);
        graph.addArc(E,F);
        //6
        graph.addArc(F,C);
        graph.addArc(F,I);
        //7
        graph.addArc(G,H);
        graph.addArc(G,I);
        //8
        graph.addArc(H,G);
        //9
        graph.addArc(I,J);
        //10
        graph.addArc(J,I);
        //11
        graph.addArc(K,J);
        //12
        graph.addArc(L,B);
        graph.addArc(L,C);

        Warshall w = new Warshall(graph);
        Graph graphW = w.start();

        Foulkes f = new Foulkes(graphW);
        f.start();
    }


    public static void testWarshall(){
        // Test n°2 Exemple cours
        System.out.println("\nWarshall : ");
        Graph graph = new GraphImpl(true);
        graph.addArc(A, D);
        graph.addArc(A, B);

        graph.addArc(B, C);
        graph.addArc(B, E);

        graph.addArc(C, E);

        graph.addArc(D, C);

        graph.addArc(E, D);

        graph.addArc(F, C);

        Warshall w = new Warshall(graph);
        w.start();
        //w.displayWarshall();
    }

    public static void testWarshall2(){
        // Test n°3 Exemple report
        System.out.println("\nWarshall : ");
        Graph graph = new GraphImpl(true);
        graph.addArc(F, A);
        graph.addArc(E, F);
        graph.addArc(A, C);
        graph.addArc(B, C);
        graph.addArc(B, D);
        graph.addArc(D, B);
        Warshall w = new Warshall(graph);
        w.start();
        //w.displayWarshall();
    }
}

