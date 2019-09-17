package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice09DrawPathView extends View {

    Paint paint = new Paint();
    RectF rectF1 = new RectF();
    RectF rectF2 = new RectF();
    Path path = new Path();

    public Practice09DrawPathView(Context context) {
        super(context);
    }

    public Practice09DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        rectF1.set(340, 200, 540, 400);
        rectF2.set(540, 200, 740, 400);
        // 使用 path 对图形进行描述
//        paint.setStyle(Paint.Style.FILL);// 省略默认
        paint.setColor(Color.RED);
        path.addArc(rectF1, -225, 225);
        path.arcTo(rectF2, -180, 225, false);
        path.lineTo(540, 542);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        canvas.drawPath(path, paint);

    }
}
