import java.util.ArrayList;

/**
 * Project Name - MinimalSpanningTree
 * File Name - GraphArray
 * Created by Amelia Kawasaki on 2/24/2017.
 * <p>
 * [Description goes here]
 * <p>
 * All Rights Reserved.
 * This work is protected by copyright laws and international treaties.
 * Copyright (C) Formaltech, Inc. 2017
 */
public class GraphArray {
    int size;
    int[][] weightArray;
    int[][] smallestSpanning;
    int[][] weightArrayCopy;

    int calcTotalWeight(){
        int total = 0;
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                total = total + smallestSpanning[i][k];
            }
        }
        return total;
    }

    void printGrid (int[][] array){
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                System.out.print(array[i][k]);
            }
            System.out.println("");
        }
    }

    void fillConnection (int end1, int end2, int weight, boolean weightCheck, boolean smallestCheck, boolean copy){
        if (weightCheck){
            //fill in weightArray
            if (weightArray[end1][end2] < weight) {
                weightArray[end1][end2] = weight;
                weightArray[end2][end1] = weight;
            }
        }
        if (smallestCheck){
            //fill in smallestSpanning
            if (end1 > end2){
                smallestSpanning[end2][end1] = weight;
            }
            else {
                smallestSpanning[end1][end2] = weight;
            }
        }
        if (copy) {
            weightArrayCopy[end1][end2] = 0;
            weightArrayCopy[end2][end1] = 0;
        }

    }

    public void findMinSpan (){
        weightArrayCopy = weightArray;
        ArrayList<Integer> visitedNode = new ArrayList<Integer>();
        int highestvalue = 0;

        //find highest value
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++ ){
                if (weightArray[i][j] > highestvalue){
                    highestvalue = weightArray[i][j];
                }
            }
        }

        visitedNode.add(0);

        while (visitedNode.size() != size) {
            LocationSave nextLoc = new LocationSave(-1, -1, highestvalue);
            /*
            System.out.println();
            for (int i = 0; i < visitedNode.size(); i++){
                System.out.print(visitedNode.get(i));
            }
            System.out.println();
            */
            for (int j = 0; j < visitedNode.size(); j++) { //looks at the visited nodes
                for (int i = 0; i < (size); i++) {
                    if (weightArrayCopy[visitedNode.get(j)][i] != 0) {
                        if (i != visitedNode.get(j)) {
                            if (nextLoc.value >= weightArrayCopy[visitedNode.get(j)][i]) {
                                if ((visitedNode.indexOf(i) == -1) ){
                                    nextLoc.firstLocation = visitedNode.get(j);
                                    nextLoc.secondLocation = i;
                                    nextLoc.value = weightArrayCopy[visitedNode.get(j)][i];
                                }
                            }
                        }
                    }
                }

            }

            //System.out.println("The coordinates are (" + nextLoc.firstLocation + ", " + nextLoc.secondLocation + ") and the value is " + nextLoc.value);
            fillConnection(nextLoc.firstLocation, nextLoc.secondLocation, nextLoc.value, false, true, true);
            visitedNode.add(nextLoc.secondLocation);
            //printGrid(smallestSpanning);
            //System.out.println("");
            //printGrid(weightArrayCopy);
            //System.out.println("");
        }

        /*
        for (int i = 0; i < visitedNode.size(); i++){
            System.out.print(visitedNode.get(i));
        }
        */

    }

    GraphArray (int s){
        size = s;
        weightArray = new int[s][s];
        smallestSpanning = new int[s][s];
        /*
        fillConnection(0, 1, 5, true, false, false);
        fillConnection(0, 3, 3, true, false, false);
        fillConnection(0, 4, 4, true, false, false);
        fillConnection(1, 3, 3, true, false, false);
        fillConnection(1, 5, 2, true, false, false);
        fillConnection(1, 9, 4, true, false, false);
        fillConnection(1, 2, 3, true, false, false);
        fillConnection(2, 9, 2, true, false, false);
        fillConnection(3, 4, 5, true, false, false);
        fillConnection(3, 5, 3, true, false, false);
        fillConnection(3, 6, 4, true, false, false);
        fillConnection(4, 6, 4, true, false, false);
        fillConnection(4, 7, 2, true, false, false);
        fillConnection(5, 6, 4, true, false, false);
        fillConnection(5, 8, 3, true, false, false);
        fillConnection(5, 9, 3, true, false, false);
        fillConnection(6, 7, 3, true, false, false);
        fillConnection(6, 8, 2, true, false, false);
        fillConnection(7, 8, 3, true, false, false);
        fillConnection(8, 9, 4, true, false, false);
        printGrid(weightArray);
        */
    }

}
