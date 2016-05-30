package com.leondroid.animation.penner.back;

import android.view.animation.Interpolator;

public final class Back {

    private Back() {}

    private static final float DEFAULT_OVERSHOOT_AMOUNT = 1.70158f;

    public static class EaseIn implements Interpolator {

        private final float overshoot;

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing in: accelerating from zero velocity.
         */
        public EaseIn() {
            this(DEFAULT_OVERSHOOT_AMOUNT);
        }

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing in: accelerating from zero velocity.
         *
         * @param overshoot Overshoot ammount: higher overshoot means greater overshoot
         *          (0 produces cubic easing with no overshoot,
         *          and the default value of 1.70158 produces an overshoot of 10 percent).
         */
        public EaseIn(float overshoot) {
            this.overshoot = overshoot;
        }

        @Override
        public float getInterpolation(float t) {
            return t * t * ((overshoot + 1) * t - overshoot);
        }
    }

    public static class EaseOut implements Interpolator {

        private final float overshoot;

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing out: decelerating from zero velocity.
         */
        public EaseOut() {
            this(DEFAULT_OVERSHOOT_AMOUNT);
        }

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing out: decelerating from zero velocity.
         *
         * @param overshoot Overshoot ammount: higher overshoot means greater overshoot
         *          (0 produces cubic easing with no overshoot,
         *          and the default value of 1.70158 produces an overshoot of 10 percent).
         */
        public EaseOut(float overshoot) {
            this.overshoot = overshoot;
        }

        @Override
        public float getInterpolation(float t) {
            return (t = t - 1) * t * ((overshoot + 1) * t + overshoot) + 1;
        }
    }

    public static class EaseInOut implements Interpolator {

        private final float overshoot;

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing in/out: acceleration until halfway, then deceleration.
         */
        public EaseInOut() {
            this(DEFAULT_OVERSHOOT_AMOUNT);
        }

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing in/out: acceleration until halfway, then deceleration.
         *
         * @param overshoot Overshoot ammount: higher overshoot means greater overshoot
         *          (0 produces cubic easing with no overshoot,
         *          and the default value of 1.70158 produces an overshoot of 10 percent).
         */
        public EaseInOut(float overshoot) {
            this.overshoot = overshoot;
        }

        @Override
        public float getInterpolation(float t) {
            if ((t /= 2f) < 1) {
                return .5f * (t * t * ((overshoot * 1.525f + 1) * t - (overshoot * 1.525f)));
            } else {
                return .5f * ((t -= 2) * t * ((overshoot * 1.525f + 1) * t + overshoot * 1.525f) + 2);
            }
        }
    }

    public static class EaseOutIn implements Interpolator {

        private final float overshoot;

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing out/in: deceleration until halfway, then acceleration.
         */
        public EaseOutIn() {
            this(DEFAULT_OVERSHOOT_AMOUNT);
        }

        /**
         * Easing equation function for a back (overshooting cubic easing: (overshoot+1)*t^3 - overshoot*t^2)
         * easing out/in: deceleration until halfway, then acceleration.
         *
         * @param overshoot Overshoot ammount: higher overshoot means greater overshoot
         *          (0 produces cubic easing with no overshoot,
         *          and the default value of 1.70158 produces an overshoot of 10 percent).
         */
        public EaseOutIn(float overshoot) {
            this.overshoot = overshoot;
        }

        @Override
        public float getInterpolation(float t) {
            t = t * 2;
            if (t < 1f) {
                return .5f * ((t -= 1) * t * ((overshoot + 1) * t + overshoot) + 1);
            } else {
                return .5f * t * t * ((overshoot + 1) * t - overshoot) + .5f;
            }
        }
    }
}
