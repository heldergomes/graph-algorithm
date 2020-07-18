package com.graphs;

public class Main {

    public static void main(String[] args) {
        ScreenGraph screenGraph = new ScreenGraph();
        Integer numberOfVertices = screenGraph.showNodeScreen();
        Graph graph = new Graph(numberOfVertices);
        Edge possibleEdges = new Edge().buildPossibleEdges(graph.vertice);

        for (int index = 0; index < graph.adjacencyList.length; index++) {
            Node mainNode = new Node();
            do {
                Integer edgeSelected = screenGraph.showEdgeScreen(index, possibleEdges);
                graph.adjacencyList[index] = mainNode.addNode(edgeSelected);
                possibleEdges.deletePossibleNode(edgeSelected);
            } while (screenGraph.isFinish(index));
            possibleEdges.buildPossibleEdges(graph.vertice);
        }
        screenGraph.showGraph(graph);
    }
}
