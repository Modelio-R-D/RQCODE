package rqcode.stigs.win10_new;

import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63447;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63449;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63463;
import rqcode.stigs.win10_new.AuditPolicy.stigs.V_63467;
import rqcode.stigs.win10_new.patterns.STIGPattern;

public class Windows10SecurityTechnicalImplementationGuide {
    public static final STIGPattern v_63447 = new V_63447();
    public static final STIGPattern v_63449 = new V_63449();
    public static final STIGPattern v_63463 = new V_63463();
    public static final STIGPattern v_63467 = new V_63467();

    public static void main(String[] args) {
        System.out.println(v_63447.check());
        System.out.println(v_63449.check());
        System.out.println(v_63463.check());
        System.out.println(v_63467.check());
    }
}