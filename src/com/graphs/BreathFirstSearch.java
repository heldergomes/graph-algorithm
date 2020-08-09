package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

    Queue<Integer> queue;
    boolean[] visited;
    Graph graph;

    public BreathFirstSearch(Graph graph){
        this.queue = new LinkedList<Integer>();
        this.graph = graph;
        this.visited = new boolean[graph.vertice];
        for (int i = 0; i < graph.vertice-1; i++)
            this.visited[i] = false;
    }

    boolean search(int init, int goal){
        queue.add(init);
        while (!queue.isEmpty()){
            int vertice = queue.remove();
            visited[vertice] = true;
            for (;graph.adjacencyList[vertice] != null ;graph.adjacencyList[vertice] = graph.adjacencyList[vertice].nextNode){
                if (visited[graph.adjacencyList[vertice].vertice] == false) {
                    if (validSearch(graph.adjacencyList[vertice].vertice, goal))
                        return true;
                    queue.add(graph.adjacencyList[vertice].vertice);
                }
            }
        }
        return false;
    }

    private boolean validSearch(int vertice, int goal) {
        if(vertice == goal)
            return true;
        return false;
    }
}
