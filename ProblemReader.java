/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javapracticegame;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ProblemReader {

        //fields
        FileInputStream fstream;
        DataInputStream in;
        
        BufferedReader csvFile;
        
        List<Problem> levelOne = new ArrayList<Problem>();
        List<Problem> levelTwo = new ArrayList<Problem>();
        List<Problem> levelThree = new ArrayList<Problem>();
        List<Problem> currentProblems = new ArrayList<Problem>();
        
        String dataLine, storedAnswer, userAnswer;
        String[] lineContents = new String[3];
        String[] userAnswer = new String[10];
        
        int level;
        
        
        //ctor
        public ProblemReader (int i) {
                initializeFile();
                getCurrentProblemSet(i);

        }
        
        public String result(int i, String a) {
                userAnswer[i] = a;
                boolean result;
                
                storedAnswer = getCurrentAnswer(i);
                userAnswer = a.trim();
                
        		if (storedAnswer.substring(0, storedAnswer.indexOf(' ',0)).equals
        				(userAnswer.substring(0, storedAnswer.indexOf(' ',0)))) {
        			if (userAnswer.indexOf("\" \"",0) > -1) {
        				if (storedAnswer.equals(userAnswer))
        					return true;
        			}
        		}
        		
        		if (storedAnswer.substring(0, storedAnswer.indexOf(' ',0)).equals
        				(userAnswer.substring(0, storedAnswer.indexOf(' ',0)))) {
        			storedAnswer = removeWhiteSpace(storedAnswer);
    				  userAnswer = removeWhiteSpace(userAnswer);
        				
        			 if (storedAnswer.equals(userAnswer))
        					return true;
        			}
        		
        		return false;
        }
        

        //methods
        private void initializeFile() {
			try {
				fstream = new FileInputStream(
						".//Problems.csv");
				in = new DataInputStream(fstream);
				csvFile = new BufferedReader(new InputStreamReader(in));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			readLine();
	
			while (dataLine != null) {
				lineContents = dataLine.split(",");
				if (lineContents[0].equals("one"))
					levelOne.add(new Problem(lineContents[1], lineContents[2]));
	
				else if (lineContents[0].equals("two"))
					levelTwo.add(new Problem(lineContents[1], lineContents[2]));
	
				else if (lineContents[0].equals("three"))
					levelThree.add(new Problem(lineContents[1], lineContents[2]));
	
				readLine();
			}// while
	
			try {
				csvFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }//initializeFile               

        private void readLine() {
                // TODO Auto-generated method stub
                try {
                        dataLine = csvFile.readLine();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }       
        
        public String getCurrentQuestion(int i) {
                String question = "";
                
                try {
                        question = currentProblems.get(i).getQuestion();
                }
                catch (IndexOutOfBoundsException e){
                        System.out.println("Index out of bounds");                      
                }
                return question;
        }
        
        public String getCurrentAnswer(int i) {
                String answer = "";
                
                try {
                        answer = currentProblems.get(i).getAnswer();
                }
                catch (IndexOutOfBoundsException e){
                        System.out.println("Index out of bounds");                      
                }
                return answer;
        }

        //shuffle and create copy of first 10
        private void getCurrentProblemSet(int l) {
                
                switch (l) {
                case 1: 
                        Collections.shuffle(levelOne);
                        currentProblems = levelOne.subList(0, 9);
                        break;
                case 2: 
                        Collections.shuffle(levelTwo);
                        currentProblems = levelTwo.subList(0, 9);
                        break;
                case 3: 
                        Collections.shuffle(levelThree);
                        currentProblems = levelThree.subList(0, 9);
                        break;
                default:
                        break;
                        
                }
        }
        
}//class