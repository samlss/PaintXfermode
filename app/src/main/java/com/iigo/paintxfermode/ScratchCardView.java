package com.iigo.paintxfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author SamLeung
 * @Emial 729717222@qq.com
 * @date 2018/6/25 0025 14:39
 */
public class ScratchCardView extends View {
    private Paint paint;
    private Bitmap dstBitmap, srcBitmap, realRewardBitmap;
    private Path path;
    private float touchX, touchY;

    public ScratchCardView(Context context) {
        super(context);

        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(40);

        //真实的奖励图
        realRewardBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.scratch_2,null);

        //原图，即要刮走的图
        srcBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.scratch_1,null);

        //目标图
        dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(realRewardBitmap,0,0, paint); //画底图

        int count = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG); //创建画布

        new Canvas(dstBitmap).drawPath(path, paint); //新建一个canvas，将手指轨迹画到目标Bitmap上

        canvas.drawBitmap(dstBitmap,0,0, paint);//将目标图像画到画布上

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)); //设置图像混合模式
        canvas.drawBitmap(srcBitmap,0,0,paint); //将最上面的刮刮奖图片画到画布上

        paint.setXfermode(null); //清空Xfermode
        canvas.restoreToCount(count);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                touchX = event.getX();
                touchY = event.getY();
                return true;

            case MotionEvent.ACTION_MOVE:
                float endX = (touchX + event.getX()) / 2;
                float endY = (touchY + event.getY()) / 2;

                path.quadTo(touchX,touchY,endX,endY);

                touchX = event.getX();
                touchY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }
}
