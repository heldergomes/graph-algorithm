package com.graphs;

import java.util.List;

public class Graph {
    public Integer vertice;
    public Integer edges;
    public Node[] adjacencyList;

    public Graph (Integer vertice) {
        this.vertice = vertice;
        adjacencyList = new Node[vertice];
        this.edges = 0;
    }

    public StringBuilder showString(){
        StringBuilder formatGraph = new StringBuilder();
        int indexArcs = 0;
        for (int index = 0; index < adjacencyList.length; index++) {
            if (adjacencyList[index] != null) {
                formatGraph.append("Node: " + index + " - Arcs");
                List<Integer> listNodes = adjacencyList[index].readAllNodes(adjacencyList[index]);
                listNodes.stream().forEach(x -> formatGraph.append(" - " + x));
                formatGraph.append('\n');
            }
        }
        formatGraph.append('\n');
        return formatGraph;
    }
}
