package com.example.spiderhackathonapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class CarView extends View {

    public static Boolean run;
    Path path = new Path();
    Paint cursor = new Paint(),text = new Paint();
    int keyframes = 0;

    public CarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        cursor.setColor(Color.RED);
        text.setColor(Color.RED);
        text.setTextSize(120);
        text.setFakeBoldText(true);

    }


    protected void onDraw(Canvas canvas){
        float width = getWidth();
        float height = getHeight();
        path = GameView.path;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float totalkeyframes = pathMeasure.getLength() / 100;
        float point[] = {0f, 0f};

        run=true;
        if (keyframes <= 100) {
            pathMeasure.getPosTan(totalkeyframes * keyframes, point, null);
            if(point[0]>width-100&&point[0]<width&&point[1]>0&&point[1]<100){
                float winmsg = text.measureText("YOU WON!!");
                canvas.drawText("YOU WON",(width/2-winmsg/2),height/2,text);
                run=false;
            }
            if (run)
            {
                canvas.drawCircle(point[0],point[1],20,cursor);
                keyframes++;
                invalidate();
            }
        } else {
            float losemsg = text.measureText("GAMEOVER!!");
            canvas.drawText("GAMEOVER!!",(width/2-losemsg/2),height/2,text);
            keyframes = 0;
        };
    }

}

