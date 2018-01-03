package com.brainmentors.helper;

import java.util.Arrays;

public class Question {
	private int id;
	private String name;
	private String answers[] = new String[4];
	private int score;
	private String rightAnswer;
	private String yourAnswer;
	@Override
	public int hashCode(){
		return name.trim().length();
	}
	@Override
	public boolean equals(Object object){
		if(object instanceof Question){
			if(this==object){
				return true;
			}
			Question question = (Question) object;
			if(question.name.equalsIgnoreCase(this.name)){
				return true;
			}
		}
		return false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	public String getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(String yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", answers=" + Arrays.toString(answers) + ", score=" + score
				+ ", rightAnswer=" + rightAnswer + ", yourAnswer=" + yourAnswer + "]";
	}
	

}
