package com.example.t5test.core.infra.codegroup;

import lombok.Data;

@Data
public class CodeGroupDto {
    private String ifcgSeq;
    private String ifcgSeqAnother;
    private String ifcgName;
    private String ifcgNameEng;
    private Integer ifcgUseNy;
    private Integer ifcgOrder;
    private String ifcgReferenceV1;
    private String ifcgReferenceV2;
    private String ifcgReferenceV3;
    private String ifcgReferenceV4;
    private Integer ifcgReferenceI1;
    private Integer ifcgReferenceI2;
    private Integer ifcgReferenceI3;
    private Integer ifcgReferenceI4;
    private String ifcgDesc;
    private Integer ifcgDelNy;

    //---------------------
    private String xifcdSeqCount;
}
