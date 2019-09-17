package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice06DrawLineView extends View {

    Paint paint = new Paint();
    Paint paints = new Paint();

    public Practice06DrawLineView(Context context) {
        super(context);
    }

    public Practice06DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线

        paint.setStrokeWidth(10);
        canvas.drawLine(120, 300, 460, 500, paint);

        float[] pts = {
                640, 320, 840, 320,
                740, 320, 740, 480,
                600, 480, 880, 480
        };
        paints.setStrokeWidth(10);
        canvas.drawLines(pts, paints);
    }
}
