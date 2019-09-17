package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice04DrawPointView extends View {

    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();

    public Practice04DrawPointView(Context context) {
        super(context);
    }

    public Practice04DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        // 设置点的大小
        paint1.setStrokeWidth(80);
        paint2.setStrokeWidth(80);
        // 设置点的形状 圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE)
        paint1.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeCap(Paint.Cap.BUTT);
//        paint2.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(350, 200, paint1);
        canvas.drawPoint(730, 200, paint2);

        // 批量画点
        paint3.setStrokeWidth(20);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        // 点的坐标数组，每两个成一对
        float[] points = {
                0, 0,
                300, 480,
                340, 480,
                380, 480,
                420, 480,
                460, 480,
                500, 480,
        };
        // 「offset」表示跳过数组的前几个数再开始记坐标；「count」表示一共要绘制几个点
        int offset = 2, count = 12;// 一共绘制 12 个数（6 个点）
        canvas.drawPoints(points, offset, count, paint3);
    }
}
