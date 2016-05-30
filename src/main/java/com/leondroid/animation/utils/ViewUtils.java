package com.leondroid.animation.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewGroup;

public class ViewUtils {

    private ViewUtils() {
    }

    public static int toPx(Context context, int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int toPx(Context context, double dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static void setWidth(View v, int width) {
        v.getLayoutParams().width = width;
        v.invalidate();
    }

    public static void setHeight(View v, int height) {
        v.getLayoutParams().height = height;
        v.invalidate();
    }

    public static void setMarginTop(View v, int topMargin) {
        ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).topMargin = topMargin;
        v.invalidate();
    }

    public static void setMarginLeft(View v, int leftMargin) {
        ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).leftMargin = leftMargin;
        v.invalidate();
    }

    public static void setMarginBottom(View v, int bottomMargin) {
        ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin = bottomMargin;
        v.invalidate();
    }

    public static void setMarginRight(View v, int leftMargin) {
        ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).leftMargin = leftMargin;
        v.invalidate();
    }

    public static void setPaddingLeft(View view, int leftPadding) {
        view.setPadding(leftPadding, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingTop(View view, int topPadding) {
        view.setPadding(view.getPaddingLeft(), topPadding, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setPaddingRight(View view, int rightPadding) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), rightPadding, view.getPaddingBottom());
    }

    public static void setPaddingBottom(View view, int bottomPadding) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), bottomPadding);
    }

    public static void setPaddingLeftRight(View view, int padding) {
        view.setPadding(padding, view.getPaddingTop(), padding, view.getPaddingBottom());
    }

    public static Point getLocationOnScreen(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }


    public static <T extends View> T getView(View v, @IdRes int resId) {
        return (T) v.findViewById(resId);
    }

    public static <T extends View> T getView(Activity activity, @IdRes int resId) {
        return (T) activity.findViewById(resId);
    }
}
