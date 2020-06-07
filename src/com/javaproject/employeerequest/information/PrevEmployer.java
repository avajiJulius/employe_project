package com.javaproject.employeerequest.information;

import java.time.LocalDate;

public class PrevEmployer {
    private String fName;
    private String sName;
    private LocalDate workStart;
    private LocalDate workEnd;
    private String contactInfo;
    private String quitReason;

    public PrevEmployer(String fName, String sName, LocalDate workStart,
                        LocalDate workEnd, String contactInfo, String quitReason) {
        this.fName = fName;
        this.sName = sName;
        this.workStart = workStart;
        this.workEnd = workEnd;
        this.contactInfo = contactInfo;
        this.quitReason = quitReason;
    }
}
