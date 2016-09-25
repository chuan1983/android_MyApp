package com.example.user.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/**
 * Created by user on 2016/9/26.
 */

public class Spirite {

    private Context mContext;
    private Bitmap mBitmap;

    private final static float ACCLERATIONY = 3.5F;

    private final static float ACCLERATIONX = 0F;

    public PointF mCoord;

    public PointF mV;

    public PointF mDimention;

    private Paint mPaint;

    private int mType;

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public Spirite(Context context){
        mContext = context;
        mCoord = new PointF();
        mV = new PointF();
        mDimention = new PointF();
    }


    public void loadBitmap(int id){
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), id);
        mDimention.x = mBitmap.getWidth();
        mDimention.y = mBitmap.getHeight();
    }



    public void draw(Canvas canvas){
        canvas.drawBitmap(mBitmap, mCoord.x, mCoord.y, mPaint);

        move();
    }


    public void move(){
        mCoord.x += mV.x;
        mCoord.y += mV.y;

        mV.x += ACCLERATIONX;
        mV.y += ACCLERATIONY;
    }

}
