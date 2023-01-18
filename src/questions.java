
public class questions {
	 private Integer difficulty;
	 private String question;
	 private String[] options;
	 private String answer;

	 public questions(Integer diffculty, String question, String[] options, String answer) {
		 this.difficulty = diffculty;
		 this.question = question;
		 this.options = options;
		 this.setAnswer(answer);
	 }
	 
	 public boolean checks(questions qs){
		questions anotherQ = (questions)qs;
		if(this.question.equals(anotherQ.question)){
			return true;
		}
		 return false;
	 }

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String[] getOptions() {
		return options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}