package com.example.t5test.core.infra.menu;

import com.example.t5test.core.common.base.BaseDto;
import lombok.Data;

@Data
public class MenuDto extends BaseDto {
    private String ifmuSeq;
    private Integer ifmuAdminNy;
    private String ifmuName;
    private String ifmuNameEng;
    private String ifmuUrl;
    private String ifmuParents;
    private String ifmuDepth;
    private Integer ifmuDelNy;
    private Integer ifmuUseNy;
    private Integer ifmuOrder;
    private String ifmuDesc;
    private String IfatSeq;
    private String IfauSeq;
    private String parentsSeq;

}
