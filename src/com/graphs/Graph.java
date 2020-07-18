package com.graphs;

import java.util.List;

public class Graph {
    Integer vertice;
    Integer edges;
    Node[] adjacencyList;

    public Graph (Integer vertice) {
        this.vertice = vertice;
        adjacencyList = new Node[vertice];
    }

    public StringBuilder showString(){
        StringBuilder formatGraph = new StringBuilder();
        int indexArcs = 0;
        for (int index = 0; index < adjacencyList.length; index++) {
            formatGraph.append("Node: " + index + " - Arcs");
            List<Integer> listNodes = adjacencyList[index].readAllNodes(adjacencyList[index]);
            listNodes.stream().forEach(x -> formatGraph.append(" - " + x));
            formatGraph.append('\n');
        }
        return formatGraph;
    }
}
