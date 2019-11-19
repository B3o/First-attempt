package day7.exam;

/**
 * @author Bmo
 * @date 2019/11/19 15:55
 */
public class Question {
    private Integer id;
    private String name;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answer;
    private String userAnswer;

    public Question() {
    }
    public Question(Integer id, String name, String answerA, String answerB, String answerC, String answerD, String answer) {
        this.id = id;
        this.name = name;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
    public boolean judgeAnswer() {
        if (this.answer.equals(userAnswer)) {
            return true;
        }else {
            return false;
        }
    }
}
