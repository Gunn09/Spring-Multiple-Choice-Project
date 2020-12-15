package spring.model;

public class Answer {

	private Long id;
	private Long question_id;
	private String answer;
	private Integer correct;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getCorrect() {
		return correct;
	}
	public void setCorrect(Integer correct) {
		this.correct = correct;
	}
	
//	private Question question;
//
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	
	public Answer() {
		
	}
	
//	public Answer(Long id, Question question, String answer, Integer correct) {
//		this.id = id;
//		this.question = question;
//		this.answer = answer;
//		this.correct = correct;
//	}
	
}
