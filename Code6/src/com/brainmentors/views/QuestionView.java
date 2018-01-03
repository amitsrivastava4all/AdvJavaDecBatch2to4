package com.brainmentors.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.helper.Question;
import com.brainmentors.helper.QuestionOperation;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionView extends JFrame {

	private JPanel contentPane;
	private int totalQuestions;
	private int index = 0;
	Object o ;
	private void printQuestion(int index){
		Question currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
		System.out.println(currentQuestion.hashCode());
		System.out.println(System.identityHashCode(currentQuestion));
		StringBuilder question = new StringBuilder();
		question.append("Q").append(index+1).append(" ").append(currentQuestion.getName()); 
		questionlbl.setText(question.toString());
		
		ans1rb.setText(currentQuestion.getAnswers()[0]);
		ans2rb.setText(currentQuestion.getAnswers()[1]);
		ans3rb.setText(currentQuestion.getAnswers()[2]);
		ans4rb.setText(currentQuestion.getAnswers()[3]);
		if(!(currentQuestion.getYourAnswer()!=null && currentQuestion.getYourAnswer().trim().length()>0)){
			clearAnswers();
		}
		else{
			switch(currentQuestion.getYourAnswer()){
			case "a":
				ans1rb.setSelected(true);
			break;	
			case "b":
				ans2rb.setSelected(true);
			break;
			case "c":
				ans3rb.setSelected(true);
			break;
			case "d":
				ans4rb.setSelected(true);
			break;
			}
		}
		}
	
	private void clearAnswers(){
		bg.clearSelection();
	}
	
	private void updateAns(ActionEvent e){
		Question currentQuestion = QuestionOperation.getInstance().getQuestionByIndex(index);
		if(e.getSource()==ans1rb){
			currentQuestion.setYourAnswer("a");
		}
		else
		if(e.getSource()==ans2rb){
			currentQuestion.setYourAnswer("b");
		}
		else
		if(e.getSource()==ans3rb){
			currentQuestion.setYourAnswer("c");
		}
		else
		if(e.getSource()==ans4rb){
			currentQuestion.setYourAnswer("d");
		}
		System.out.println("Update... "+currentQuestion.getYourAnswer());
	}
	private void loadQuestions(){
		QuestionOperation questionOperation = QuestionOperation.getInstance();
		Question question  = new Question();
		question.setId(1);
		question.setName("JVM Stands For");
		String answers [] = {"Java Vital Machine","Java Virtual Machine","Both","None of these"};
		question.setAnswers(answers);
		question.setRightAnswer("b");
		question.setScore(5);
		questionOperation.addQuestion(question);
		
		 question  = new Question();
		question.setId(1);
		question.setName("JVM Stands For");
		String answers0 [] = {"Java Vital Machine","Java Virtual Machine","Both","None of these"};
		question.setAnswers(answers0);
		question.setRightAnswer("b");
		question.setScore(5);
		questionOperation.addQuestion(question);
		
		question  = new Question();
		question.setId(2);
		question.setName("JRE Stands For");
		 String answers1 [] = {"Java Read Env","Java Real Env","Java Runtime Env","None of these"};
		question.setAnswers(answers1);
		question.setRightAnswer("c");
		question.setScore(5);
		questionOperation.addQuestion(question);

		question  = new Question();
		question.setId(3);
		question.setName("Java is Developed By");
		 String answers2 [] = {"Sun MicroSystem","Oracle","Microsoft","None of these"};
		question.setAnswers(answers2);
		question.setRightAnswer("a");
		question.setScore(5);
		questionOperation.addQuestion(question);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionView frame = new QuestionView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JLabel questionlbl = new JLabel("");
	JRadioButton ans1rb = new JRadioButton("");
	JRadioButton ans2rb = new JRadioButton("");
	JRadioButton ans3rb = new JRadioButton("");
	JRadioButton ans4rb = new JRadioButton("");
	public QuestionView() {
		
		setTitle("Quiz App -2018");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		questionlbl.setBounds(26, 26, 501, 125);
		contentPane.add(questionlbl);
		
		
		ans1rb.setBounds(26, 186, 414, 23);
		contentPane.add(ans1rb);
		
		
		ans2rb.setBounds(26, 236, 414, 23);
		contentPane.add(ans2rb);
		
		
		ans3rb.setBounds(26, 284, 414, 23);
		contentPane.add(ans3rb);
		
		
		ans4rb.setBounds(26, 339, 414, 23);
		contentPane.add(ans4rb);
		
		
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			prev();
			}
		});
		btnPrev.setBounds(0, 374, 117, 29);
		contentPane.add(btnPrev);
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			next();
			}
		});
		btnNext.setBounds(410, 374, 117, 29);
		contentPane.add(btnNext);
		loadQuestions();
		printQuestion(this.index);
		enableDisable();
		makeGroup();
		this.totalQuestions = QuestionOperation.getInstance().getQuestions().size();
		ans1rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateAns(e);
			}
		});
		ans2rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateAns(e);
			}
		});
		ans3rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateAns(e);
			}
		});
		ans4rb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			updateAns(e);
			}
		});
	}
	JButton btnPrev = new JButton("Prev");
	JButton btnNext = new JButton("Next");
	private void prev(){
		
		 if(index>0){
			index--;
			btnPrev.setEnabled(true);
		}
		 printQuestion(index);
		 enableDisable();
	}
	
	private void enableDisable(){
		btnPrev.setEnabled(index==0?false:true);
		btnNext.setEnabled(index==totalQuestions-1?false:true);
	}
	
	private void  next(){
		if(index<totalQuestions){
			index++;
		}
		enableDisable();
		printQuestion(index);
	}
	ButtonGroup bg = new ButtonGroup();
	private void makeGroup(){
		
		bg.add(ans1rb);
		bg.add(ans2rb);
		bg.add(ans3rb);
		bg.add(ans4rb);
	}
	
	
}
