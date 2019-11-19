package day7.exam;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

/**
 * @author Bmo
 * @date 2019/11/19 16:43
 */
public class ExamRecord {
    private long startTime;
    private long endTime;
    private int rightNum;
    private File file;
    private List<Question> questionList;

    public ExamRecord(File file) {
        this.file = file;
        this.startTime = System.currentTimeMillis();
        this.rightNum = 0;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void writeResult() throws IOException {
        if (!this.file.exists()) {
            file.createNewFile();
        } else {
            System.out.println(file.getName());
            String name = file.getName();
            String fileName[] = name.split("\\.");
            File newFile = new File(file.getParentFile() + File.separator + fileName[0] + "_time" +
                     "." + fileName[1]);
            newFile.createNewFile();
            file = newFile;
        }
        FileWriter fw = new FileWriter(file, true);
        System.out.println("-----------------------------------------");
        fw.write("共" + questionList.size() + "道题目，您一共用时：" + (endTime - startTime) / 1000 + "秒\r\n");
        for (int i = 0; i < questionList.size(); ++i) {
            Question now = questionList.get(i);
            fw.write("第" + (i + 1) + "题正确答案" + now.getAnswer() +
                    "     您的答案：" + now.getUserAnswer() + "\r\n");
        }
        fw.write("您的正确率为：" + getPercent(rightNum, questionList.size()));
        fw.close();
        System.out.println("考试成绩打印成功，请与设置好的目录查看！");
    }
    public static String getPercent(int a, int b) {
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到整数位
        numberFormat.setMaximumFractionDigits(-1);
        String result = numberFormat.format((float) a / (float) b /5*100)+ "%";
        return result;
    }



}
