import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import java.util.Set;

import javax.swing.JDialog;




public class quiz extends JDialog{
    private Set<questions> questionRepo1 = new HashSet<>();
    private Set<questions> questionRepo2 = new HashSet<>();
    private Set<questions> questionRepo3 = new HashSet<>();
    
    {
    	questionRepo1.add(new questions(1,"A simple Question", new String[]{"Option1","Option2"},"Option2"));
    	questionRepo2.add(new questions(2,"A mid-level Question", new String[]{"Option1","Option2"},"Option2"));
    	questionRepo3.add(new questions(3,"A hard Question", new String[]{"Option1","Option2"},"Option2"));

    }
    
    public boolean addQuestion(Integer difficulty, String questions,String[] options,String answer){
        questions question = new questions(difficulty, questions,options,answer);
        switch(question.getDifficulty()){
        case 1:
            return this.questionRepo1.add(question);
        case 2:
            return this.questionRepo2.add(question);
        case 3:
            return this.questionRepo3.add(question);
        }
        return false;
    }
    public ArrayList<questions> generateQuiz(int difficulty){
    	HashSet<questions> qList = new HashSet<>();
    	while(qList.size() != 3) {
	    	switch (difficulty) {
	    	case 1:
	            ArrayList<questions> questionRepo1 = new ArrayList<>(this.questionRepo1);
	            questions question1 = questionRepo1.get(new Random().nextInt(questionRepo1.size()));
	            qList.add(question1);
	
	    	case 2:
	            ArrayList<questions> questionRepo2 = new ArrayList<>(this.questionRepo2);
	            questions question2 = questionRepo2.get(new Random().nextInt(questionRepo2.size()));
	            qList.add(question2);
	
	    	case 3:
	            ArrayList<questions> questionRepo3 = new ArrayList<>(this.questionRepo3);
	            questions question3 = questionRepo3.get(new Random().nextInt(questionRepo3.size()));
	            qList.add(question3);
	
	    	}
    	}
        ArrayList<questions> newQList = new ArrayList<>(qList);
    	return newQList;
    }
}
