package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02DrawCircleView extends View {

    Paint paint1, paint2, paint3, paint4;

    public Practice02DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice02DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice02DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);// 开启抗锯齿 ANTI_ALIAS_FLAG
        paint2 = new Paint();
        paint3 = new Paint();
        paint4 = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        paint1.setColor(Color.YELLOW);
        canvas.drawCircle(328, 180, 164, paint1);

        paint2.setStyle(Paint.Style.STROKE);// 画线模式
        paint2.setColor(Color.CYAN);
        paint2.setStrokeWidth(3);// 线条宽度为 3 像素
        canvas.drawCircle(720, 180, 164, paint2);

        paint3.setStyle(Paint.Style.FILL);// 填充模式
        paint3.setColor(Color.RED);
        canvas.drawCircle(328, 560, 164, paint3);

        paint4.setStyle(Paint.Style.STROKE);
        paint4.setColor(Color.DKGRAY);
        paint4.setStrokeWidth(70);
        paint4.setAntiAlias(true);// 动态开启抗锯齿
        canvas.drawCircle(720, 560, 164, paint4);

    }
}
