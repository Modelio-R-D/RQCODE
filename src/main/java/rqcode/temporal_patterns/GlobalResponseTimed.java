package rqcode.temporal_patterns;

import java.net.MalformedURLException;
import java.net.URL;


import rqcode.concepts.Checkable;

/**
 * Temporal requirements pattern:
 * Globally, Real-time Response: Globally, it is always the case that if P holds, the S eventually holds within T time units.
 */

public class GlobalResponseTimed extends MonitoringLoop {
    
    private Checkable s;
    
    private Checkable r;
    
    public  GlobalResponseTimed(Checkable s, Checkable r, int boundary) {
        this.s = s;
        this.r = r;
        this.boundary = boundary;

        this.setStatement(this.toString());
    }
    
    @Override
    public boolean precondition() {
        return (s.check() == CheckStatus.PASS);
    }
    
    @Override
    public boolean postcondition() {
        return (r.check() == CheckStatus.PASS);
    }
    
    @Override
    public boolean exitCondition() {
        return (r.check() == CheckStatus.PASS);
    }
    
    @Override
    public String toString() {
        URL patternURL;
        try {
            patternURL = new URL("https://people.cs.ksu.edu/~dwyer/SPAT/ctl.html#Response");
        } catch (MalformedURLException e) {
            return "";
        }
        return
                "Globally, it is always the case that if S holds, the R will eventually hold within " + boundary +
                " seconds (" + patternURL.toString() + "), where S is:\n\n\t\t" +
                        s.toString().replaceAll("\n", "\n\t\t") +
                "\nand R is:\n\n\t\t:" +
                        r.toString().replaceAll("\n", "\n\t\t");
    }

    
    @Override
    public String TCTL() {
        String sStr, rStr;
        if (s instanceof MonitoringLoop) {
            sStr = ((MonitoringLoop) s).TCTL();
        } else {
            sStr = s.getClass().getSimpleName();
        }
        if (r instanceof MonitoringLoop) {
            rStr = ((MonitoringLoop) r).TCTL();
        } else {
            rStr = r.getClass().getSimpleName();
        }
        return "AG((" + sStr + ") ==> (AF <= " + boundary + " (" + rStr + ")))";
    }

}
