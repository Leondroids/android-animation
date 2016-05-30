package com.leondroid.animation.penner.quad;

import android.view.animation.Interpolator;

public class Quad {

    private Quad() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a quadratic (t^2)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return t * t;
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a quadratic (t^2)
         * easing out: decelerating to zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return -t * (t - 2);
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a quadratic (t^2)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if (t < .5f) {
                return .5f * t * t;
            } else {
                return -.5f * (t * (t - 2) - 1);
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a quadratic (t^2)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            if ((t *= 2) < 1f) {
                return -(.5f) * t * (t - 2);
            } else {
                return .5f * (t -= 1) * t + .5f;
            }
        }
    }
}
