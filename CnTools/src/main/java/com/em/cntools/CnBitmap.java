package com.em.cntools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * @author yemint
 * bitmap工具类
 */
public class CnBitmap {


    private CnBitmap() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException(" FmBitmap cannot be instantiated");
    }

    /**
     * 调整图片旋转
     *
     * @param bitmap
     * @return bitmap
     */
    public static Bitmap adjustPhotoRotation(Bitmap bitmap) {

        int orientationDegree = 90;

        Matrix matrix = new Matrix();
        matrix.setRotate(orientationDegree, (float) bitmap.getWidth() / 2,
                (float) bitmap.getHeight() / 2);
        float targetX, targetY;
        if (orientationDegree == 90) {
            targetX = bitmap.getHeight();
            targetY = 0;
        } else {
            targetX = bitmap.getHeight();
            targetY = bitmap.getWidth();
        }


        final float[] values = new float[9];
        matrix.getValues(values);


        float x1 = values[Matrix.MTRANS_X];
        float y1 = values[Matrix.MTRANS_Y];


        matrix.postTranslate(targetX - x1, targetY - y1);


        Bitmap canvasBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(),
                Bitmap.Config.ARGB_8888);


        Paint paint = new Paint();
        Canvas canvas = new Canvas(canvasBitmap);
        canvas.drawBitmap(bitmap, matrix, paint);


        return canvasBitmap;
    }
}
