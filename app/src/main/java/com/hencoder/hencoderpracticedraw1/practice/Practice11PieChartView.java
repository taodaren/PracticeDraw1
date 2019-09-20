package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 综合练习：使用各种 Canvas.drawXXX() 方法画饼图
 */
public class Practice11PieChartView extends View {

    Paint mPaint   = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint txtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF mRectF   = new RectF();
    Path  mPath    = new Path();

    List<PhoneModel> phoneModels = new ArrayList<>();

    {
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_huawei), R.color.colorHuawei, 27.05));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_samsung), R.color.colorSamsung, 9.77));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_lenovo), R.color.colorLenovo, 7.07));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_mi), R.color.colorMi, 5.50));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_oppo), R.color.colorOppo, 5.21));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_vivo), R.color.colorVivo, 5.19));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_meizu), R.color.colorMeizu, 1.78));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_other), R.color.colorOther, 38.43));
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制标题
        String title = "2019上半年安卓手机市场占比";
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(48);
        mPaint.setColor(Color.WHITE);
        canvas.drawText(title, getWidth() / 2, getHeight() - 40, mPaint);

        // 扇形绘制起点
        int outset = -188;

        // 对比 360 度转换倍率
        double to360 = 3.43;

        // 手机占比
        double percent;

        // 扇形开始角度、划过一半角度
        float startAngle = 0, midAngle = 0;

        // 折线两段线
        int line1 = 20;
        int line2 = 50;

        // 椭圆四边
        float left, right, top, bottom;

        // 圆的半径及坐标
        float r, oX, oY;

        // 扇形弧线中点坐标
        float midX, midY;

        // 文字坐标
        float txtX, txtY;

        // 折线坐标
        float line1X, line1Y, line2X, line2Y;

        int offset = 0;

        for (int i = 0; i < phoneModels.size(); i++) {
            percent = phoneModels.get(i).percent * to360;
            if (i == 0) {
                startAngle = outset;
                left = 150;
                right = 730;
                top = 65;
                bottom = 640;
            } else {
                startAngle += phoneModels.get(i - 1).percent * to360 + 2.18;
                left = 180;
                right = 730;
                top = 90;
                bottom = 640;
            }

            midAngle = startAngle + (float) (percent / 2);

            r = (right - left) / 2;
            oX = left + r;
            oY = top + r;

            midX = (float) (oX + Math.cos(midAngle * Math.PI / 180) * (r + offset));
            midY = (float) (oY + Math.sin(midAngle * Math.PI / 180) * (r + offset));

            line1X = (float) (oX + Math.cos(midAngle * Math.PI / 180) * (r + offset + line1));
            line1Y = (float) (oY + Math.sin(midAngle * Math.PI / 180) * (r + offset + line1));

            line2X = Math.abs(midAngle) <= 90 ? line1X + line2 : line1X - line2;
            line2Y = line1Y;

            txtX = Math.abs(midAngle) <= 90 ? line2X + 20 : line2X - 20;
            txtY = line1Y;

            // 绘制折线
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.WHITE);
            mPath.moveTo(midX, midY);
            mPath.lineTo(line1X, line1Y);
            mPath.lineTo(line2X, line2Y);
            canvas.drawPath(mPath, mPaint);

            // 绘制手机厂商名
            txtPaint.setStyle(Paint.Style.STROKE);
            txtPaint.setColor(Color.WHITE);
            txtPaint.setTextSize(24);
            if (Math.abs(midAngle) <= 90) {
                txtPaint.setTextAlign(Paint.Align.LEFT);
            } else {
                txtPaint.setTextAlign(Paint.Align.RIGHT);
            }
            String name = phoneModels.get(i).brand + " " + phoneModels.get(i).percent + " %";
            canvas.drawText(name, txtX, txtY, txtPaint);

            // 绘制扇形
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setColor(getResources().getColor(phoneModels.get(i).color));
            mRectF.set(left, top, right, bottom);
            canvas.drawArc(mRectF, startAngle, (float) percent, true, mPaint);
        }
    }

    private class PhoneModel {

        String brand;
        @ColorRes
        int color;
        double percent;

        PhoneModel(String brand, @ColorRes int color, double percent) {
            this.brand = brand;
            this.color = color;
            this.percent = percent;
        }

    }

}
