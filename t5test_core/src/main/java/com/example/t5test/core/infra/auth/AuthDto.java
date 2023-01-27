package com.example.t5test.core.infra.auth;

import com.example.t5test.core.common.base.BaseDto;
import lombok.Data;

@Data
public class AuthDto extends BaseDto {
    private String ifatSeq;
    private Integer ifatAdminNy;
    private String ifatName;
    private String ifatNameEng;
    private Integer ifatUseNy;
    private Integer ifatOrder;
    private String ifatDesc;
    private Integer ifatDelNy;
    private String IfauSeq;
    private  String IfmuSeq;
}
