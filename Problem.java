/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//Testing commit issues by Trevor

package javapracticegame;


public class Problem {
	
	private String question, answer;
	
	public Problem (String q, String a) {
		this.question = q;
		this.answer = a;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Question: " + this.question + "\nAnswer: " + this.answer;
	}
}