package org.lookout.interview.graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class MazeTraversal {
      int rowLength;
      int columnLength;
      MazeCell[][] mazeInput;
      MazeCell startPoint;
      //MazeCell endPoint;
      
      public MazeTraversal(MazeCell[][] mazeInput,MazeCell startPoint){
    	  this.mazeInput=mazeInput;
    	  this.startPoint=startPoint;
      }
	 public void printPath(){
		   rowLength=mazeInput.length-1;
		   columnLength=mazeInput[0].length-1;
		   Stack<MazeCell> stack =new Stack<MazeCell>();
		   stack.push(startPoint);
		   while(!stack.isEmpty()){
			   MazeCell currentCell=stack.peek();
			   MazeCell adjCell=getAdj(currentCell);
			   if(currentCell.symbol=='F'){
				   trackPath(currentCell);
				   return;
			   }
			   if(adjCell!=null){
				   adjCell.color='g';
				   adjCell.parent=currentCell;
				   stack.push(adjCell);
			   }
			   else{
				   currentCell.color='b';
				   stack.pop();
			   }
			   
		   }//end of while
		   System.out.println("there is no path from start point to end point");
	 }
	 
	 public void trackPath(MazeCell currentCell){
		 ArrayList<String> pathList=new ArrayList<String>();
		 while(currentCell!=null){
			 pathList.add(currentCell.toString());
			 currentCell=currentCell.parent;
		 }
		 System.out.println("path from start to finish is: ");
		 for (int i = pathList.size()-1; i>=0; i--) {
			System.out.print(pathList.get(i)+" ");
		}
	 }
	 
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
	 
	public static void main(String[] args) {
		int rowLength=0;
		int columnLength=0;
		FileReader fReader=null;
		MazeCell[][] mazeInput=new MazeCell[9][9];
		try {
		   fReader=new FileReader("E:\\maze_input.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		BufferedReader bReader=new BufferedReader(fReader);
		//BufferedReader bReader1=bReader;
		//count the rowlength and column length
		/*String str1=null;
		try{
			while((str1=bReader.readLine())!=null){
				columnLength=str1.length();
				rowLength++;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		MazeCell[][] mazeInput=new MazeCell[rowLength][columnLength];*/
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
     MazeTraversal maze=new MazeTraversal(mazeInput,startPoint);
     maze.printPath();
	} // end of main function

}
