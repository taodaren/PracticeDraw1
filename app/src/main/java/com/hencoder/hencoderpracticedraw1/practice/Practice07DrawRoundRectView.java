package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice07DrawRoundRectView extends View {

    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF rectF1 = new RectF(340, 120, 740, 320);
    RectF rectF2 = new RectF(340, 420, 740, 620);
    // 圆角的横向半径和纵向半径
    int rx = 40, ry = 40;

    public Practice07DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice07DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice07DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        paint2.setStyle(Paint.Style.STROKE);
//        canvas.drawRoundRect(340, 120, 740, 320, 40, 40, paint1);
//        canvas.drawRoundRect(340, 420, 740, 620, 40, 40, paint2);
        canvas.drawRoundRect(rectF1, rx, ry, paint1);
        canvas.drawRoundRect(rectF2, rx, ry, paint2);
    }
}
