package com.example.thanhson.cookingrecipet3h.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class UnscrollableViewPager extends ViewPager {
    private Boolean isPagingEnabled = true;

    public UnscrollableViewPager(@NonNull Context context) {
        super(context);
    }

    public UnscrollableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return this.isPagingEnabled && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(ev);
    }

    public void setPagingEnabled(Boolean b) {
        this.isPagingEnabled = b;
    }
}
