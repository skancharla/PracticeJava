package org.lookout.interview.graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstTraversal {
     MazeCell[][] mazeInput;
     MazeCell startPoint;
     int rowLength;
     int columnLength;
     public BreadthFirstTraversal(MazeCell[][] mazeInput , MazeCell startPoint){
    	     this.mazeInput=mazeInput;
    	     this.startPoint=startPoint;
    	     this.rowLength=mazeInput.length-1;
    	     this.columnLength=mazeInput[0].length-1;
     }
     public void runBFS(){
    	  //define a queue to run BFS
    	 LinkedList<MazeCell> queue=new LinkedList<MazeCell>();
    	 queue.add(startPoint);
    	 while(!queue.isEmpty()){
    		 MazeCell currentCell=queue.remove();
    		 if(currentCell.symbol=='F'){
    			 printBFSpath(currentCell);
    			 return;
    		 }
    		 for (int i = 0; i < 4; i++) {
				MazeCell adjCell=getAdj(currentCell);
				if(adjCell!=null){
					adjCell.color='g';
					adjCell.parent=currentCell;
					queue.add(adjCell);
				}
				else{
					break;
				}
			}
    		 currentCell.color='b';
    	 }//end of while
    	 
    	 System.out.println("path doesn't exist");
     }
     //auxilary methods
     public boolean isValid(int x , int y){
		  if(x<0 || x>rowLength)
			  return false;
		  if(y<0 || y>columnLength)
			  return false;
		  return true;
	 }
	 public MazeCell getAdj(MazeCell currentCell){
		 MazeCell adjCell=null; 
		 for (int i = 1; i <= 4; i++) {
			 if(i==1 && isValid(currentCell.x-1,currentCell.y)){
				 adjCell=mazeInput[currentCell.x-1][currentCell.y];
				 if(adjCell.color=='w' && (adjCell.symbol=='-'|| adjCell.symbol=='F')){
					
					 return adjCell;
				 }
			 }
			  if(i==2 && isValid(currentCell.x+1,currentCell.y)){
				 //System.out.println(currentCell.x+1+" "+currentCell.y);
				  adjCell=mazeInput[currentCell.x+1][currentCell.y];
				 if(adjCell.color=='w' && (adjCell.symbol=='-'|| adjCell.symbol=='F')){
					 
					 return adjCell;
				 }
			 }
			  if(i==3 && isValid(currentCell.x,currentCell.y-1)){
				  adjCell=mazeInput[currentCell.x][currentCell.y-1];
				 if(adjCell.color=='w'  && (adjCell.symbol=='-'|| adjCell.symbol=='F')){
					 
					 return adjCell;
				 }
			 }
				 if(i==4 && isValid(currentCell.x,currentCell.y+1)){
					 adjCell=mazeInput[currentCell.x][currentCell.y+1];
					 if(adjCell.color=='w' && (adjCell.symbol=='-'|| adjCell.symbol=='F')){
						 
						 return adjCell;
					 }
				 }
			 
			 
		}
		 return null;
	 }
	 
	 public void printBFSpath(MazeCell currentCell){
		 ArrayList<String> pathList=new ArrayList<String>();
		 while(currentCell!=null){
			 pathList.add(currentCell.toString());
			 currentCell=currentCell.parent;
		 }
		 System.out.println("shortest path from start to finish is: ");
		 for (int i = pathList.size()-1; i>=0; i--) {
			System.out.print(pathList.get(i)+" ");
		}
	 }
	
	public static void main(String[] args) {
		int rowLength=0;
		int columnLength=0;
		FileReader fReader=null;
		MazeCell[][] mazeInput=new MazeCell[4][4];
		try {
		   fReader=new FileReader("inputs\\maze_input3.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		BufferedReader bReader=new BufferedReader(fReader);
		
       String str=null;
       int i=0;
       try {
		while((str=bReader.readLine())!=null){
			int j=0;
			while(j<str.length()){
				MazeCell currentCell=new MazeCell(); 
				currentCell.symbol=str.charAt(j);
				 currentCell.x=i;
				 currentCell.y=j;
				 currentCell.color='w';
				 currentCell.parent=null;
				 mazeInput[i][j]=currentCell;
				 System.out.print(currentCell.symbol);
				 j++;
			 }
			System.out.println();
			   i++;
		   }
	} catch (IOException e) {
		
		e.printStackTrace();
	}
       MazeCell startPoint=null;
      for (int j = 0; j < mazeInput.length; j++) {
		for (int j2 = 0; j2 < mazeInput[j].length; j2++) {
			 if(mazeInput[j][j2].symbol=='S'){
				startPoint=mazeInput[j][j2];
			 }
		}
	} 
     
    BreadthFirstTraversal bfs=new BreadthFirstTraversal(mazeInput,startPoint);
    bfs.runBFS();
	}//end of main function

}
