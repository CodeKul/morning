package com.melayer.customview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by aniruddha on 31/7/17.
 */

public class MyView extends android.support.v7.widget.AppCompatEditText {

    private Paint paint, paintVerti;

    public MyView(Context context) {
        super(context);

        initUtils();
    }

    public MyView(Context context, AttributeSet attr) {
        super(context, attr);
        initUtils();
    }

    private void initUtils() {
        setGravity(Gravity.LEFT | Gravity.TOP);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(1.2f);

        paintVerti = new Paint();
        paintVerti.setColor(Color.BLACK);
        paintVerti.setStrokeWidth(2.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(300, 0, 300, 2000, paintVerti);
        for (int i = 0; i < 2000; i += 100)
            canvas.drawLine(0, i, getWidth(), i, paint);
        //canvas.drawCircle(50, 50, 30, paint);
    }
}
