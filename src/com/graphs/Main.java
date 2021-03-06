package com.graphs;

public class Main {

    public static void main(String[] args) {
        ScreenGraph screenGraph = new ScreenGraph();
        Graph graph;
        if (screenGraph.isTest()) {
            graph = new Graph(6);
            Node mockNode = new Node();
            graph.adjacencyList[0] = mockNode.addNode(1);
            graph.adjacencyList[0] = mockNode.addNode(2);
            graph.adjacencyList[0] = mockNode.addNode(3);
            mockNode = new Node();
            graph.adjacencyList[1] = mockNode.addNode(2);
            graph.adjacencyList[1] = mockNode.addNode(4);
            mockNode = new Node();
            graph.adjacencyList[2] = mockNode.addNode(4);
            graph.adjacencyList[2] = mockNode.addNode(5);
            mockNode = new Node();
            graph.adjacencyList[5] = mockNode.addNode(3);
            graph.edges = 8;
        }else {
            Integer numberOfVertices = screenGraph.showNodeScreen();
            graph = new Graph(numberOfVertices);
            Edge possibleEdges = new Edge().buildPossibleEdges(graph.vertice);

            for (int index = 0; index < graph.adjacencyList.length; index++) {
                Node mainNode = new Node();
                do {
                    Integer edgeSelected = screenGraph.showEdgeScreen(index, possibleEdges);
                    graph.adjacencyList[index] = mainNode.addNode(edgeSelected);
                    possibleEdges.deletePossibleNode(edgeSelected);
                    graph.edges++;
                } while (screenGraph.isFinish(index));
                possibleEdges.buildPossibleEdges(graph.vertice);
            }
        }
        StringBuilder graphPrint = screenGraph.showGraph(graph);
        String algorithm = screenGraph.showAlgorithmScreen(graphPrint);
        StringBuilder log = new StringBuilder();
        switch (algorithm){
            case "deph-first-search":
                DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
                log = depthFirstSearch.search();
                break;
            case "breath-first-search":
                BreathFirstSearch breathFirstSearch = new BreathFirstSearch(graph);
                if (breathFirstSearch.search(0, 6)) {
                    log.append("Vertice found ! \n\n");
                }else{
                    log.append("Vertice not found ! \n\n");
                }
        }
        log.append(graphPrint);
        screenGraph.showResultAlgorthm(log);
    }
}
