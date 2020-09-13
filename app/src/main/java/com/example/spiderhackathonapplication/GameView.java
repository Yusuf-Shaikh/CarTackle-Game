package com.example.spiderhackathonapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class GameView extends View {
    public static Path path = new Path();
    Paint brush = new Paint(),obstacle = new Paint(),finish = new Paint();

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        brush.setAntiAlias(true);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(20f);

        finish.setColor(Color.MAGENTA);

    }


    protected void onDraw(Canvas canvas){
        float width = getWidth();
        float height = getHeight();
        canvas.drawPath(path,brush);
        canvas.drawRect(0,height-100,100,height,finish);
        canvas.drawRect(width-100,0,width,100,finish);
    }

    public boolean onTouchEvent(MotionEvent event){
        float pointX = event.getX();
        float pointY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.reset();
                path.moveTo(pointX,pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX,pointY);
                break;
            default:
                return false;
        }
        return false;
    }

}
