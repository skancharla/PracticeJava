package org.lookout.interview.graphs;

public class MazeCell {
 public int x;
 public int y;
 public char symbol;
 public char color;
 public MazeCell parent;
 
 public String toString(){
	 return "a"+x+y;
 }
}
