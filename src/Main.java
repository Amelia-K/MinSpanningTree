import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Project Name - MinimalSpanningTree
 * File Name - Main
 * Created by Amelia Kawasaki on 2/24/2017.
 * <p>
 * [Description goes here]
 * <p>
 * All Rights Reserved.
 * This work is protected by copyright laws and international treaties.
 * Copyright (C) Formaltech, Inc. 2017
 */
public class Main {
    /*
    static ArrayList<Integer> findSize (){
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        boolean endoffile = false;
        int i,j, value;
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("bingraph800-"))) {
            while (!endoffile){
                try  {
                    i=dataIn.readInt();
                    j=dataIn.readInt();
                    value=dataIn.readInt();
                    if (nodeList.indexOf(i) == -1){
                        nodeList.add(i);
                    }
                    if (nodeList.indexOf(j) == -1){
                        nodeList.add(j);
                    }
                    //System.out.println("i is " + i + ", j is " + j + ", value is " + value );
                }catch (EOFException exc){
                    System.out.println("Endoffile");
                    endoffile=true;

                }
            }
            return nodeList;
        }
        catch (IOException exc) {
            System.out.println("Read error.");
            return nodeList;
        }
    }
    */
    static void enterFileConnections (GraphArray myGraph){
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        boolean endoffile = false;
        int i,j, value;
        try (DataInputStream dataIn = new DataInputStream(new FileInputStream("bingraph800-"))) {
            while (!endoffile){
                try  {
                    i=dataIn.readInt();
                    j=dataIn.readInt();
                    value=dataIn.readInt();
                    myGraph.fillConnection(i,j, value, true, false, false);
                }
                catch (EOFException exc){
                    System.out.println("Endoffile");
                    endoffile=true;

                }
            }
        }
        catch (IOException exc) {
            System.out.println("Read error.");
            return;
        }
    }
    public static void main (String args[]){
        //ArrayList<Integer> nodeList = findSize();

        /*
        int temp;
        int temp2;
        for (int j = nodeList.size(); j >= 0; j--) {
            for (int i = 0; i < nodeList.size() - 1; i++) {
                if (nodeList.get(i) > nodeList.get(i + 1)) {
                    temp = nodeList.get(i);
                    temp2 = nodeList.get(i + 1);
                    nodeList.set(i, temp2);
                    nodeList.set(i + 1, temp);
                }
            }
        }


        for(int i = 0; i < nodeList.size(); i++){
            System.out.println(nodeList.get(i));
        }
        */

        GraphArray myGraphArray = new GraphArray(800);
        enterFileConnections(myGraphArray);
        myGraphArray.findMinSpan();
        int total = myGraphArray.calcTotalWeight();
        System.out.println();
        System.out.println(total);

    }
}
