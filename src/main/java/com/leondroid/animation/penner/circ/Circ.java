package com.leondroid.animation.penner.circ;

import android.view.animation.Interpolator;

public class Circ {

    private Circ() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a circular (sqrt(1-t^2))
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return -((float) Math.sqrt(1 - t * t) - 1);
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a circular (sqrt(1-t^2))
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return (float) Math.sqrt(1 - (t = t - 1) * t);
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a circular (sqrt(1-t^2))
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if ((t /= .5f) < 1) {
                return -.5f * ((float) Math.sqrt(1 - t * t) - 1);
            } else {
                return .5f * ((float) Math.sqrt(1 - (t -= 2) * t) + 1);
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a circular (sqrt(1-t^2))
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            t = t * 2 - 1;
            if (t < 0f) {
                return .5f * (float) Math.sqrt(1 - t * t);
            } else {
                return -(.5f) * ((float) Math.sqrt(1 - t * t) - 1) + .5f;
            }
        }
    }
}
