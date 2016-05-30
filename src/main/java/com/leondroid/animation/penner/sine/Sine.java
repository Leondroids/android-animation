package com.leondroid.animation.penner.sine;

import android.view.animation.Interpolator;

public class Sine {

    private Sine() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a sinusoidal (sin(t))
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            return 1 - (float) Math.cos(t * (Math.PI / 2f));
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a sinusoidal (sin(t))
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return (float) Math.sin(t * (Math.PI / 2f));
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a sinusoidal (sin(t))
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            return .5f * (1 - (float) Math.cos(Math.PI * t));
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a sinusoidal (sin(t))
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            if (t < .5f) {
                return .5f * (float) Math.sin(t * 2 * (Math.PI / 2f));
            } else {
                return -.5f * (float) Math.cos(((t * 2) - 1f) * (Math.PI / 2f)) + 1f;
            }
        }
    }
}
