package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice05DrawOvalView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF rectF = new RectF(340, 200, 740, 400);

    public Practice05DrawOvalView(Context context) {
        super(context);
    }

    public Practice05DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GRAY);
//        canvas.drawOval(340, 200, 740, 600, paint);
        canvas.drawOval(rectF, paint);
    }
}
