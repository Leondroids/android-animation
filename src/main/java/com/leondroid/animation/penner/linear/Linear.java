package com.leondroid.animation.penner.linear;

import android.view.animation.Interpolator;

public class Linear {

    private Linear() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a simple linear tweening, with no easing.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return t;
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a simple linear tweening, with no easing.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return t;
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a simple linear tweening, with no easing.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return t;
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a simple linear tweening, with no easing.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return t;
        }
    }
}
