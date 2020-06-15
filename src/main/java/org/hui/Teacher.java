package org.hui;

public class Teacher implements CallBack {
    Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void question() throws InterruptedException {

        new Thread(new Runnable() {
            public void run() {
                String question  = "1+1=?";
                System.out.printf("教室提问！"+question);
                student.answer(Teacher.this,question);
            }
        }).start();
        Thread.sleep(1000l);
        System.out.println("教师继续去干别的事情");
    }


    public void answerCallback(String answer) {
        System.out.println("教师得到回答！答案是："+answer +" 教师可以打分了");
    }
}
