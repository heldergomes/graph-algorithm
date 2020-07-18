package com.graphs;

public class Edge {

    Object[] nodes;

    public Edge buildPossibleEdges (Integer numberOfNodes) {
        nodes = new Object[numberOfNodes];
        for (Integer index = 0; index < numberOfNodes; index++)
            nodes[index] = index;
        return this;
    }

    public void deletePossibleNode(Integer edgeSelected) {
        Object auxNode[] = new Object[nodes.length - 1];
        int indexAuxNode = 0;
        for (int index = 0; index <= auxNode.length; index++) {
            if (nodes[index] != edgeSelected){
                auxNode[indexAuxNode] = nodes[index];
                indexAuxNode++;
            }
        }
        nodes = new Object[nodes.length - 1];
        for (int index = 0; index < nodes.length; index++) {
            nodes[index] = auxNode[index];
        }
    }
}
