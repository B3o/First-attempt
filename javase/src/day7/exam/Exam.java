package day7.exam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/19 16:14
 */
public class Exam {
    static String resultPath = "F:\\practiceIO\\examResult";
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("******欢迎进入考试系统******");
        System.out.print("请输入账号：");
        String un = sc.next();
        System.out.print("请输入密码：");
        String pw = sc.next();
        if ("admin".equals(un) && "123".equals(pw)) {
            start();
        } else {
            System.out.println("请重新输入");
            main(null); // 递归实现重复输入
        }
    }
    public static void start() {
        int rightNum = 0, questionNum;
        System.out.println("欢迎您！瘪三同学，请选择考试卷");
        for (int i = 0; i < Init.listPaper.size(); ++i) {
            System.out.println("试卷编号\t\t试卷名称");
            System.out.println((i + 1) + "\t\t\t" + Init.listPaper.get(i).getName());
        }

        System.out.print("请选择：");
        int choice = sc.nextInt();
        TestPaper nowPaper = Init.listPaper.get(choice - 1);
        List<Question> questionList = nowPaper.getList();
        questionNum = questionList.size();
        //创建ExamRecord时就已经记录了考试开始时间
        ExamRecord examRecord = new ExamRecord(new File(resultPath + File.separator +
                nowPaper.getName() + ".txt"));
        for (int i = 0; i < questionList.size(); ++i) {
            Question nowQuestion = questionList.get(i);
            System.out.println(nowQuestion.getId() + "." + nowQuestion.getName());
            System.out.println(nowQuestion.getAnswerA());
            System.out.println(nowQuestion.getAnswerB());
            System.out.println(nowQuestion.getAnswerC());
            System.out.println(nowQuestion.getAnswerD());
            System.out.print("请作答:");
            String userAnswer = sc.next().toUpperCase();
            nowQuestion.setUserAnswer(userAnswer);
            questionList.set(i, nowQuestion);
            //设置question的userAnswer属性 然后放回去
            if (nowQuestion.judgeAnswer()) {
                examRecord.setRightNum(examRecord.getRightNum() + 1);
            }
        }
        examRecord.setEndTime(System.currentTimeMillis());
        //考完试记录结束时间
        examRecord.setQuestionList(questionList);
        //传入questionList列表
        try {
            examRecord.writeResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("正确回答数量：" + rightNum);
//        System.out.println("总回答数量：" + questionNum);
    }
}
