package com.example.user.myapp;


import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


/**
 * Created by user on 2016/9/26.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private SurfaceHolder mHolder;
    private DrawThread mDrawThread;

    public MySurfaceView(Context context){
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);   // 给SurfaceView目前的持有者一個回復對象。

    }
    //調整畫面的線程
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }
    //在surface的大小發生改變時激發
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mDrawThread = new DrawThread();
        Thread thread =new Thread(mDrawThread);        //創立畫圖線程
        thread.start();
    }
    //畫面的線程停止
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mDrawThread.stop();
    }

     protected void myDraw(Canvas canvas){

     }

    private class DrawThread implements Runnable{
        private boolean mRun = true;
        @Override
        public void run() {
            while (mRun){
                Canvas canvas = mHolder.lockCanvas();// 鎖定畫面，在鎖定後就可以通過其返回的畫布對象Canvas，在其上面畫圖等操作了。
                myDraw(canvas);
                mHolder.unlockCanvasAndPost(canvas); // lockCanvas鎖定後畫完圖之後结束锁定画图，來進行改變。
            }
        }
        public void stop(){mRun = false;}
    }
}
