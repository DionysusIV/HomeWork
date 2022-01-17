import java.util.LinkedList;

public class MyGraph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjLists;

    MyGraph(int vertexCount) {
        if (vertexCount < 0) {
            throw new IllegalArgumentException();
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 > vertexCount - 1 || v2 > vertexCount - 1) {
            throw new IllegalArgumentException("Номер вершины не может быть отрицательный");
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
        edgeCount++;
    }

    LinkedList<Integer> adjList(int v) {
        if (vertexCount < 0 || v > vertexCount - 1) {
            throw new IllegalArgumentException("Номер вершины не может быть отрицательный");
        }
        return adjLists[v];
    }
}
