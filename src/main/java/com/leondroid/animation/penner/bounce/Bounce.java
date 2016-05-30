package com.leondroid.animation.penner.bounce;

import android.view.animation.Interpolator;

public class Bounce {

    private Bounce() {}

    public static class EaseIn implements Interpolator {

        /**
         * Easing equation function for a bounce (exponentially decaying parabolic bounce)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
        }

        @Override
        public float getInterpolation(float t) {
            t = 1 - t;
            if (t < (1 / 2.75f)) {
                return 1 - (7.5625f * t * t);
            } else if (t < (2 / 2.75f)) {
                return 1 - (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f);
            } else if (t < (2.5 / 2.75)) {
                return 1 - (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f);
            } else {
                return 1 - (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f);
            }
        }
    }

    public static class EaseOut implements Interpolator {

        /**
         * Easing equation function for a bounce (exponentially decaying parabolic bounce)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if (t < (1 / 2.75f)) {
                return (7.5625f * t * t);
            } else if (t < (2 / 2.75f)) {
                return (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f);
            } else if (t < (2.5 / 2.75)) {
                return (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f);
            } else {
                return (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f);
            }
        }
    }

    public static class EaseInOut implements Interpolator {

        /**
         * Easing equation function for a bounce (exponentially decaying parabolic bounce)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
        }

        @Override
        public float getInterpolation(float t) {
            if (t < .5f) {
                t = 1 - t * 2;
                if (t < (1 / 2.75f)) {
                    return (1 - (7.5625f * t * t)) * .5f;
                } else if (t < (2 / 2.75f)) {
                    return (1 - (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f)) * .5f;
                } else if (t < (2.5 / 2.75)) {
                    return (1 - (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f)) * .5f;
                } else {
                    return (1 - (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f)) * .5f;
                }
            } else {
                t = t * 2 - 1;
                if (t < (1 / 2.75f)) {
                    return (7.5625f * t * t) * .5f + .5f;
                } else if (t < (2 / 2.75f)) {
                    return (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f) * .5f + .5f;
                } else if (t < (2.5 / 2.75)) {
                    return (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f) * .5f + .5f;
                } else {
                    return (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f) * .5f + .5f;
                }
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        /**
         * Easing equation function for a bounce (exponentially decaying parabolic bounce)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
        }

        @Override
        public float getInterpolation(float t) {
            t = t * 2;
            if (t < 1f) {
                if (t < (1 / 2.75f)) {
                    return .5f * (7.5625f * t * t);
                } else if (t < (2 / 2.75f)) {
                    return .5f * (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f);
                } else if (t < (2.5 / 2.75)) {
                    return .5f * (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f);
                } else {
                    return .5f * (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f);
                }
            } else {
                if (t < (1 / 2.75f)) {
                    return 1 - .5f * (7.5625f * t * t);
                } else if (t < (2 / 2.75f)) {
                    return 1 - .5f * (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f);
                } else if (t < (2.5 / 2.75)) {
                    return 1f - .5f * (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f);
                } else {
                    return 1f - .5f * (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f);
                }
            }
        }
    }
}
