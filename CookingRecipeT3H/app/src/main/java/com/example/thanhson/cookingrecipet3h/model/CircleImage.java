package com.example.thanhson.cookingrecipet3h.model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class CircleImage extends AppCompatImageView {
    private Paint paint;
    public CircleImage(Context context) {
        super(context);
        init();
    }

    public CircleImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        readAttr(attrs);
    }

    public CircleImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        readAttr(attrs);
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
    }
    private void readAttr(AttributeSet attrs) {
       // TypedArray typedArray = getContext().getResources().obtainAttributes(attrs,R.styleable.CircleImage);
      //  int color = typedArray.getColor(R.styleable.CircleImage_color,Color.WHITE);
       // paint.setColor(color);
       // typedArray.recycle();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(h,h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = getWidth()/2;
        int stroke = getWidth()/12;
        int radius = getWidth()/2 +getWidth()/5;
        paint.setStrokeWidth(stroke);
        canvas.drawCircle(size,size,radius,paint);
    }

}
