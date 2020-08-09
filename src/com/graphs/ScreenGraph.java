package com.graphs;

import javax.swing.*;

public class ScreenGraph {

    String numberNodes;

    public Integer showNodeScreen(){
        this.numberNodes = JOptionPane.showInputDialog("How many nodes your graph have ? ");
        return Integer.valueOf(this.numberNodes);
    }

    public Integer showEdgeScreen(Integer node, Edge possibleEdges){
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select a edge for a node: " + node, "Edges of node: " + node,
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleEdges.nodes, possibleEdges.nodes[0]);
        return Integer.valueOf(selectedValue.toString());
    }

    public boolean isFinish(Integer vertice) {
        Integer decision = JOptionPane.showConfirmDialog(null,
                "Do you like input more edges for the node " + vertice + " ?",
          "More edges ?",JOptionPane.YES_NO_OPTION);
        switch (decision){
            case 0:
                return true;
            case 1:
                return false;
        }
        return false;
    }

    public boolean isTest() {
        Integer decision = JOptionPane.showConfirmDialog(null,
                "Are you testing ?",
                "Testing ?",JOptionPane.YES_NO_OPTION);
        switch (decision){
            case 0:
                return true;
            case 1:
                return false;
        }
        return false;
    }

    public StringBuilder showGraph(Graph graph) {
        Object[] options = {"OK"};
        StringBuilder response = graph.showString();
        JOptionPane.showOptionDialog(null, response, "Graph",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        return response;
    }

    public void showResultAlgorthm(StringBuilder result) {
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null, result, "Result Algorithm",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

    public String showAlgorithmScreen(StringBuilder graphPrint){
        String[] algorithm = {"deph-first-search", "breath-first-search"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                graphPrint + "Select algorithm: ", "Algorithms",
                JOptionPane.INFORMATION_MESSAGE, null,
                algorithm, algorithm[0]);
        return String.valueOf(selectedValue);
    }
}
