package de.brunker.intranet.montageprotokoll.SignaturePad;

class Bezier {

    final TimedPoint startPoint;
    final FloatPoint control1;
    final FloatPoint control2;
    final TimedPoint endPoint;

    Bezier (TimedPoint startPoint, FloatPoint control1,
                  FloatPoint control2, TimedPoint endPoint) {
        this.startPoint = startPoint;
        this.control1 = control1;
        this.control2 = control2;
        this.endPoint = endPoint;
    }

    public float length() {
        int steps = 10;
        float length = 0;
        double cx, cy, px = 0, py = 0, xDiff, yDiff;

        for (int i = 0; i <= steps; i++) {
            float t = (float) i / steps;
            cx = pointOnBezier(t, this.startPoint.x, this.control1.x,
                    this.control2.x, this.endPoint.x);
            cy = pointOnBezier(t, this.startPoint.y, this.control1.y,
                    this.control2.y, this.endPoint.y);
            if (i > 0) {
                xDiff = cx - px;
                yDiff = cy - py;
                length += Math.sqrt(xDiff * xDiff + yDiff * yDiff);
            }
            px = cx;
            py = cy;
        }
        return length;

    }

    private double pointOnBezier(float t, float start, float c1, float c2, float end) {
        return start * (1.0 - t) * (1.0 - t) * (1.0 - t)
                + 3.0 * c1 * (1.0 - t) * (1.0 - t) * t
                + 3.0 * c2 * (1.0 - t) * t * t
                + end * t * t * t;
    }



}
