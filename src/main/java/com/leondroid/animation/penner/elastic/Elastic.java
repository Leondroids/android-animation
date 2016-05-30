package com.leondroid.animation.penner.elastic;

import android.view.animation.Interpolator;

import com.waz.zclient.ui.utils.MathUtils;

public class Elastic {

    private static final float DEFAULT_AMPLITUDE = 1f;
    private static final float DEFAULT_PERIOD = .3f;

    private Elastic() {}

    public static class EaseIn implements Interpolator {

        private final float a;
        private final float p;

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
            this(DEFAULT_AMPLITUDE, DEFAULT_PERIOD);
        }

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing in: accelerating from zero velocity.
         *
         * @param a Amplitude.
         * @param p Period.
         */
        public EaseIn(float a, float p) {
            this.a = a;
            this.p = p;
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 0f)) {
                return 0;
            }
            if (MathUtils.floatEqual(t, 1f)) {
                return 1;
            }
            float s;
            float a1 = this.a;
            if (a1 < 1) {
                a1 = 1;
                s = p / 4;
            } else {
                s = p / (2 * (float) Math.PI) * (float) Math.asin(1f / a1);
            }
            return -(a1 * (float) Math.pow(2, 10 * (t -= 1)) * (float) Math.sin((t - s) * (2 * Math.PI) / p));
        }
    }

    public static class EaseOut implements Interpolator {

        private final float a;
        private final float p;

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
            this(DEFAULT_AMPLITUDE, DEFAULT_PERIOD);
        }

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing out: decelerating from zero velocity.
         *
         * @param a Amplitude.
         * @param p Period.
         */
        public EaseOut(float a, float p) {
            this.a = a;
            this.p = p;
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 0f)) {
                return 0;
            }
            if (MathUtils.floatEqual(t, 1f)) {
                return 1;
            }
            float s;
            float a1 = this.a;
            if (a1 < 1) {
                a1 = 1;
                s = p / 4;
            } else {
                s = p / (2 * (float) Math.PI) * (float) Math.asin(1f / a1);
            }
            return (a1 * (float) Math.pow(2, -10 * t) * (float) Math.sin((t - s) * (2 * (float) Math.PI) / p) + 1);
        }
    }

    public static class EaseInOut implements Interpolator {

        private final float a;
        private final float p;

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
            this(DEFAULT_AMPLITUDE, DEFAULT_PERIOD);
        }

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing in/out: acceleration until halfway, then deceleration.
         *
         * @param a Amplitude.
         * @param p Period.
         */
        public EaseInOut(float a, float p) {
            this.a = a;
            this.p = p;
        }

        @Override
        public float getInterpolation(float t) {
            if (MathUtils.floatEqual(t, 0f)) {
                return 0;
            }
            if (MathUtils.floatEqual(t /= .5f, 2f)) {
                return 1;
            }
            float s;
            float a1 = this.a;
            if (a1 < 1) {
                a1 = 1;
                s = p / 4;
            } else {
                s = p / (2 * (float) Math.PI) * (float) Math.asin(1f / a1);
            }
            if (t < 1) {
                return -.5f * (a1 * (float) Math.pow(2,
                                                     10 * (t -= 1)) * (float) Math.sin((t - s) * (2 * (float) Math.PI) / p));
            }
            return a1 * (float) Math.pow(2,
                                         -10 * (t -= 1)) * (float) Math.sin((t - s) * (2 * (float) Math.PI) / p) * .5f + 1;
        }
    }

    public static class EaseOutIn implements Interpolator {

        private final float a;
        private final float p;

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
            this(DEFAULT_AMPLITUDE, DEFAULT_PERIOD);
        }

        /**
         * Easing equation function for an elastic (exponentially decaying sine wave)
         * easing out/in: deceleration until halfway, then acceleration.
         *
         * @param a Amplitude.
         * @param p Period.
         */
        public EaseOutIn(float a, float p) {
            this.a = a;
            this.p = p;
        }

        @Override
        public float getInterpolation(float t) {
            float t1 = t * 2;
            float a1 = a;
            if (t < .5f) {
                if (MathUtils.floatEqual(t1, 0f)) {
                    return 0;
                }
                if (MathUtils.floatEqual(t1, 1f)) {
                    return 1 / 2;
                }
                float s;
                if (a1 < .5f) {
                    a1 = .5f;
                    s = p / 4;
                } else {
                    s = p / (2 * (float) Math.PI) * (float) Math.asin(.5f / a1);
                }
                return (a1 * (float) Math.pow(2,
                                              -10 * t1) * (float) Math.sin((t1 - s) * (2 * (float) Math.PI) / p) + .5f);
            } else {
                t1 -= 1;
                if (MathUtils.floatEqual(t1, 0f)) {
                    return 1 / 2;
                }
                if (MathUtils.floatEqual(t1, 1f)) {
                    return 1 / 2 + .5f;
                }
                float s;
                if (a1 < .5f) {
                    a1 = .5f;
                    s = p / 4;
                } else {
                    s = p / (2 * (float) Math.PI) * (float) Math.asin(.5f / a1);
                }
                return -(a1 * (float) Math.pow(2,
                                               10 * (t1 -= 1)) * (float) Math.sin((t1 - s) * (2 * Math.PI) / p)) + 1 / 2;
            }
        }
    }
}
