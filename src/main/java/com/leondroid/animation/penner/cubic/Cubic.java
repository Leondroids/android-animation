package com.leondroid.animation.penner.cubic;

import android.view.animation.Interpolator;

public class Cubic {

    private Cubic() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a cubic (t^3)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return t * t * t;
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a cubic (t^3)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return ((t = t - 1) * t * t + 1);
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a cubic (t^3)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if ((t /= .5f) < 1) {
                return .5f * t * t * t;
            } else {
                return .5f * ((t -= 2) * t * t + 2);
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a cubic (t^3)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return .5f * (t = t * 2 - 1) * t * t + .5f;
        }
    }
}
