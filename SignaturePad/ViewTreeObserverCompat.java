package de.brunker.intranet.montageprotokoll.SignaturePad;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewTreeObserver;

class ViewTreeObserverCompat {
    /**
     * Remove a previously installed global layout callback.
     * @param observer the view observer
     * @param victim the victim
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    static void removeOnGlobalLayoutListener(ViewTreeObserver observer, ViewTreeObserver.OnGlobalLayoutListener victim) {
        // Future (API16+)...
        if (Build.VERSION.SDK_INT >= 16) {
            observer.removeOnGlobalLayoutListener(victim);
        }
        // Legacy...
        else {
            observer.removeGlobalOnLayoutListener(victim);
        }
    }
}
