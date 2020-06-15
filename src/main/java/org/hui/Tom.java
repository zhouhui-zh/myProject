package org.hui;

public class Tom implements  Student
{
    public void answer(CallBack callback, String question) {
        System.out.println("Tom正在思考！"+question);
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String answer = "2" ;
        System.out.println("Tom回答！" +answer);
        callback.answerCallback(answer);
    }
}
