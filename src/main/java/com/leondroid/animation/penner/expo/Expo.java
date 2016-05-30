package com.leondroid.animation.penner.expo;

import android.view.animation.Interpolator;

import com.waz.zclient.ui.utils.MathUtils;

public class Expo {

    private Expo() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for an exponential (2^t)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 0f)) {
                return 0;
            } else {
                return (float) Math.pow(2, 10 * (t - 1));
            }
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for an exponential (2^t)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 1f)) {
                return 1;
            } else {
                return 1 - (float) Math.pow(2, -10 * t);
            }
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for an exponential (2^t)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 0f)) {
                return 0;
            }
            if (MathUtils.floatEqual(t, 1f)) {
                return 1;
            }
            if ((t /= .5f) < 1) {
                return .5f * (float) Math.pow(2, 10 * (t - 1));
            } else {
                return .5f * (2 - (float) Math.pow(2, -10 * --t));
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for an exponential (2^t)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t * 2, 1f)) {
                return .5f;
            }

            if (t < .5f) {
                return .5f * (1 - (float) Math.pow(2, -10 * t * 2f));
            } else {
                return .5f * (float) Math.pow(2, 10 * (((t * 2) - 1) - 1)) + .5f;
            }
        }
    }
}
