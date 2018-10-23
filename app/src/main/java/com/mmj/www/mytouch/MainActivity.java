package com.mmj.www.mytouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View{
    int key;
    String str;
    int x = 100, y=100;
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.GREEN);


    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        x=(int)event.getX();
//        y=(int)event.getY();
//        invalidate();//invalidate()메서드는 객체를 메모리에서 삭제할수는 없지만 객체를 무효화 시켜버린다!!따라서 참조당할 수 없으며, getId() 메서드이외에는 메서드호출 또한 불가하다.
//        return super.onTouchEvent(event);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();

        if(event.getAction()==MotionEvent.ACTION_DOWN)
            str = "액션다운";
        if(event.getAction()==MotionEvent.ACTION_MOVE)
            str = "액션무브";
        if(event.getAction()==MotionEvent.ACTION_UP)
            str = "액션업";


        invalidate();//invalidate()메서드는 객체를 메모리에서 삭제할수는 없지만 객체를 무효화 시켜버린다!!따라서 참조당할 수 없으며, getId() 메서드이외에는 메서드호출 또한 불가하다.
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(100);
        canvas.drawCircle(x,y,100, paint);
        canvas.drawText("("+x+","+y+")액션종류: " +str,2,100, paint);
        super.onDraw(canvas);
    }//화면을 임의로 언제든 불러올 수 있도록 하는 구문
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
