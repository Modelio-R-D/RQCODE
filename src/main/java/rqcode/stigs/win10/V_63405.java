package rqcode.stigs.win10;

import rqcode.patterns.win10.AccountLockoutPolicy;

public class V_63405 extends AccountLockoutPolicy {
    @Override
    public String checkTextCode() {
        return "C-74549r2_chk";
    }

    @Override
    public String date() {
        return "2019-01-04";
    }

    @Override
    public String findingID() {
        return "V-63405";
    }

    @Override
    public String fixTextCode() {
        return "F-81277r1_fix";
    }

    @Override
    public String iAControls() {
        return "";
    }

    @Override
    public String ruleID() {
        return "SV-77895r2_rule";
    }

    @Override
    public String sTIG() {
        return "Windows 10 Security Technical Implementation Guide";
    }

    @Override
    public String severity() {
        return "Medium";
    }

    @Override
    public String version() {
        return "WN10-AC-000005";
    }

    @Override
    public String description() {
        return "The account lockout feature, when enabled, prevents brute-force password attacks on the system. This parameter specifies the amount of time that an account will remain locked after the specified number of failed logon attempts.";
    }

    @Override
    protected String getCheckTextAdditional() {
        return "\nIf the \"Account lockout duration\" is less than \"15\" minutes (excluding \"0\"), this is a finding.\n" +
                "\n" +
                "Configuring this to \"0\", requiring an administrator to unlock the account, is more restrictive and is not a finding.";
    }

    @Override
    protected String getFixTextAdditional() {
        return " minutes or greater.\n" +
                "\n" +
                "A value of \"0\" is also acceptable, requiring an administrator to unlock the account.";
    }

    @Override
    protected String getInclusionSetting() {
        return "15";
    }

    @Override
    protected String getOption() {
        return "Account lockout duration";
    }

    @Override
    protected String getValueType() {
        return "LockoutDuration";
    }
}
