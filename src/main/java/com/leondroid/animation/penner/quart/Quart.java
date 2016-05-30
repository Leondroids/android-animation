package com.leondroid.animation.penner.quart;

import android.view.animation.Interpolator;

public class Quart {

    private Quart() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a quartic (t^4)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return t * t * t * t;
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a quartic (t^4)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return -((t = t - 1) * t * t * t - 1);
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a quartic (t^4)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if ((t /= .5f) < 1) {
                return .5f * t * t * t * t;
            } else {
                return -.5f * ((t -= 2) * t * t * t - 2);
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a quartic (t^4)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            if ((t = t * 2 - 1) < 0f) {
                return -.5f * (t * t * t * t - 1);
            } else {
                return .5f * t * t * t * t + .5f;
            }
        }
    }
}
