package com.example.t5test.core.common.base;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDto {
    //	uploaded
    private String tableName;

    private String seq;
    private Integer type;
    private Integer defaultNy;
    private Integer sort;
    private String path;
    private String originalName;
    private String uuidName;
    private String ext;
    private long size;
    private Integer delNy;
    private String pseq;


    //	regmod
    private String regIp;
    private String regSeq;
    private String regId;
    private Integer regDeviceCd;
    private Date regDateTime;
    private Date regDateTimeSvr;
    private String modIp;
    private String modSeq;
    private String modId;
    private Integer modDeviceCd;
    private Date modDateTime;
    private Date modDateTimeSvr;
}
