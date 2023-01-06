package com.example.t5test.core.infra.code;

import com.example.t5test.core.common.base.BaseVo;
import lombok.Data;

@Data
public class CodeVo extends BaseVo {
    private String codeGroupSeq;

    public String getCodeGroupSeq() {
        return codeGroupSeq;
    }

    public void setCodeGroupSeq(String codeGroupSeq) {
        this.codeGroupSeq = codeGroupSeq;
    }
}
