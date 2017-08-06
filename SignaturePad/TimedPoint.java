package de.brunker.intranet.montageprotokoll.SignaturePad;

import android.util.Log;

class TimedPoint {
    final float x;
    final float y;
    private final long timestamp;

    TimedPoint(float ax, float ay) {
        x = ax;
        y = ay;
        timestamp = System.currentTimeMillis();
        Log.v("Signaturepad", "x: " + ax + " / y: " + ay + " / timestamp: " + timestamp);
    }

    float velocityFrom(TimedPoint start) {
        float dist = distanceTo(start);
        if ( dist == 0 ) { return 0f; }
        // return dist / (this.timestamp - start.timestamp);
        float velocity = dist / (timestamp - start.timestamp);
        //Log.v("Signaturepad", "Distance: " + dist + " / Time1: " + start.timestamp + " / Time2: " + timestamp + " / Velocity: " + velocity);
        Log.v("Signaturepad", "x1: " + start.x  + " / x2: " + x + " / y1: " + start.y + " / y2: " + y + " / Time1: " + start.timestamp + " / Time2: " + timestamp );
        return velocity;
    }

    float distanceTo(TimedPoint point) {
        return (float) Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
    }
}
