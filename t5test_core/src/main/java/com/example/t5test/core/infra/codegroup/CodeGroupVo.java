package com.example.t5test.core.infra.codegroup;

import com.example.t5test.core.common.base.BaseVo;
import lombok.Data;

@Data
public class CodeGroupVo extends BaseVo {
    private String codeGroupSeq;

    public String getCodeGroupSeq() {
        return codeGroupSeq;
    }

    public void setCodeGroupSeq(String codeGroupSeq) {
        this.codeGroupSeq = codeGroupSeq;
    }
}
