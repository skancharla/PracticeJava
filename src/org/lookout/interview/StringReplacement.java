package org.lookout.interview;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
*
* @author sri
*
*/
public class StringReplacement {
static Map<Integer,Integer> covered = new HashMap<Integer,Integer>();
static StringBuilder inputString = null;
public static void main(String[] args) {
   long timeStart=System.currentTimeMillis();
	if (args[0].length() == 0) {
	System.out.println("in sufficient arguments");
     System.exit(1);
}
try {
FileInputStream fStream = new FileInputStream(args[0]);
DataInputStream dataInput = new DataInputStream(fStream);
BufferedReader bReader = new BufferedReader(
new InputStreamReader(dataInput));
String line = null;
List auxInputs = new LinkedList();
while ((line = bReader.readLine()) != null) {
// Parse the line, call a function to start search, print output
// for current line
String originalString = null;
String[] input1 = line.split(";");
if (input1.length > 1)
originalString = input1[0];
else {
	System.out.println("Please provide proper input, original input is missing");
    System.exit(1);
}
String[] input2 = line.split(",");
if (input2.length > 1) {
int count = 0;
for (String pattern : input2) {
if (count == 0) {
String[] temp = pattern.split(";");
if (temp.length < 2) {
System.exit(1);
}
auxInputs.add(temp[1]);
count++;
} else
auxInputs.add(pattern);
}
} else {
System.exit(1);
}
inputString = new StringBuilder(originalString);
System.out.println(searchAndReplace(auxInputs));
auxInputs.clear();
covered.clear();
}
bReader.close();
} catch (Exception ex) {
ex.printStackTrace();
}
long timeEnd=System.currentTimeMillis();
System.out.println("program run time is: "+ (timeEnd-timeStart)/1000);
}
/**
*
* @param List of Search and Replace pairs.
* @return modified String Builder object.
*/
private static StringBuilder searchAndReplace(List searchReplace) {
// Iterate all search, replace pairs
int searchIndex = 0;
String searchFor = null;
String replaceString = null;
int index = 0; // To track first iteration of the loop.
for (int count = 0; count < searchReplace.size() - 1; count++) {
try {
searchFor = (String)searchReplace.get(count);
searchIndex = inputString.indexOf(searchFor, 0);
count += 1;
replaceString = (String)searchReplace.get(count);
} catch (Exception ex) {
continue;
}
if (index == 0 || !covered.containsKey(searchIndex)) {
inputString = inputString.replace(searchIndex, searchIndex + replaceString.length(), replaceString);
if(searchFor.length() > replaceString.length())
{
int diffToDelete = searchFor.length()-replaceString.length();
int deleteStartPosition = searchIndex + 1;
inputString.delete(deleteStartPosition, deleteStartPosition + diffToDelete);
}
//System.out.println(orig_string);
covered.put(searchIndex, searchIndex + replaceString.length()- 1);
index += 1;
}
else {
// Use advanced search and replace.
// If null is returned for a pair, move to next pair with
// original String
if (advancedSearchAndReplace(searchFor, replaceString, searchIndex) == null)
continue;
}
}
return inputString;
}
/**
*
* @param searchFor
* @param replaceWith
* @param currentIndex
* @return modified StringBuilder object.
*/
private static StringBuilder advancedSearchAndReplace(String searchFor, String replaceWith, int currentIndex) {
while (inputString.length() -(currentIndex) >= replaceWith.length()) {
int index = 0;
try {
// if we find exact position which is not shaded, replace it,
// return Stringbuilder
index = inputString.indexOf(searchFor, currentIndex + 1);
if (covered.containsKey(index)) {
// update the currentIndex and continue the loop.
currentIndex =  covered.get(index) + 1;
} else {

inputString = inputString.replace(index, index + replaceWith.length(),replaceWith);
if(searchFor.length() > replaceWith.length())
{
int diffToDelete = searchFor.length() -replaceWith.length();
int deleteStartPosition = index + 1;
inputString.delete(deleteStartPosition, deleteStartPosition + diffToDelete);
}
//System.out.println(orig_string);
covered.put(index, index + replaceWith.length() - 1);
return inputString;
}
} catch (NullPointerException ex) {
return null;
}
}
return null;
}
}
