package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public Integer vertice;
    public Node nextNode;

    Node(){}

    Node(Integer vertice){
        this.vertice = vertice;
    }

    public Node addNode(Integer vertice){
        Node newNode = new Node(vertice);
        newNode.nextNode = this.nextNode;
        this.nextNode = newNode;
        return newNode;
    }

    public List<Integer> readAllNodes(Node firstNode){
        List<Integer> listNodes = new ArrayList<>();
        for (Node auxNode = firstNode; auxNode != null; auxNode = auxNode.nextNode)
            listNodes.add(auxNode.vertice);
        return listNodes;
    }

}
