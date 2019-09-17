package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice08DrawArcView extends View {

    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    RectF rectF = new RectF();

    // 弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度）
    int startAngle1, startAngle2, startAngle3;
    // 弧形划过的角度
    int sweepAngle1, sweepAngle2, sweepAngle3;
    // 是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
    boolean useCenter1, useCenter2, useCenter3;

    public Practice08DrawArcView(Context context) {
        super(context);
    }

    public Practice08DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        rectF.set(360, 200, 740, 460);

        // 弧线
        paint1.setStyle(Paint.Style.STROKE);
        startAngle1 = 180;
        sweepAngle1 = 60;
        useCenter1 = false;

        // 扇形（连圆心）
        paint2.setStyle(Paint.Style.FILL);
        startAngle2 = -110;
        sweepAngle2 = 100;
        useCenter2 = true;

        // 扇形（直线，不连圆心）
        paint3.setStyle(Paint.Style.FILL);
        startAngle3 = 20;
        sweepAngle3 = 140;
        useCenter3 = false;

        canvas.drawArc(rectF, startAngle1, sweepAngle1, useCenter1, paint1);
        canvas.drawArc(rectF, startAngle2, sweepAngle2, useCenter2, paint2);
        canvas.drawArc(rectF, startAngle3, sweepAngle3, useCenter3, paint3);

    }
}
