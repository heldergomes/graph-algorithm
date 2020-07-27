package com.graphs;

public class DepthFirstSearch {

    Graph graph;
    int root;
    Status[] status;
    Stack stack = new Stack(1000);
    StringBuilder log = new StringBuilder();

    public DepthFirstSearch(Graph graph, int root){
        this.graph = graph;
        this.root = root;
        this.status = new Status[graph.vertice];
        prepareStatus(this.status);
    }

    private void prepareStatus(Status[] status) {
        for (int index = 0; index < status.length; index++)
            status[index] = Status.FREE;
    }

    public StringBuilder search(){
        int index = root;
        int auxIndex = 0;

        do {

            switch (status[index]){
                case FREE:
                    if (graph.adjacencyList[index] != null){

                        treatNodePending(index, Status.PENDING);

                        do { // READING EDGES
                            Integer edge = graph.adjacencyList[index].vertice;
                            if (status[edge] == Status.FREE){
                                stack.pushElement(edge);
                            }
                            if (graph.adjacencyList[index].nextNode != null) {
                                graph.adjacencyList[index] = graph.adjacencyList[index].nextNode;
                            } else {
                                if (status[edge] == Status.FREE) {
                                    auxIndex = graph.adjacencyList[index].vertice;
                                }else {
                                    auxIndex = stack.popElement();
                                }
                                graph.adjacencyList[index] = null;
                            }
                        } while (graph.adjacencyList[index] != null);
                        index = auxIndex;

                    } else { // is a leaf
                        index = treatNodeValidated(index, Status.VALIDATED);
                    }
                    break;
                case PENDING:
                    index = treatNodeValidated(index, Status.VALIDATED);
                    break;
                case VALIDATED:
                    index = stack.popElement();
                    break;
            }

        }while (!stack.isEmpty());
        formatTreatNode(index, Status.VALIDATED);
        log.append('\n');
        return log;
    }

    private Integer treatNodeValidated(Integer node, Status statusNode){
        formatTreatNode(node, statusNode);
        return stack.popElement();
    }

    private void treatNodePending(Integer node, Status statusNode){
        stack.pushElement(node);
        formatTreatNode(node, statusNode);
    }

    private void formatTreatNode(Integer node, Status statusNode){
        status[node] = statusNode;
        log.append(node + " " + status[node] + '\n');
    }

    private enum Status {
        FREE,
        PENDING,
        VALIDATED
    }

}
