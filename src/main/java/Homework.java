import org.testng.annotations.Test;

public class Homework {
    @Test
    public void findWay() {
        MyGraph graph = new MyGraph(10);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 7);
        graph.addEdge(2, 8);
        graph.addEdge(3, 9);
        graph.addEdge(3, 6);
        graph.addEdge(3, 5);
        graph.addEdge(4, 1);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(5, 2);

        BreadthFirstPath bfs = new BreadthFirstPath(graph, 0);
        assert bfs.hasPathTo(9);
        System.out.println("Кратчайший путь: "+ bfs.pathTo(9));
    }
}
