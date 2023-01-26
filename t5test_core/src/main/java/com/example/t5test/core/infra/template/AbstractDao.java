package com.example.t5test.core.infra.template;

import com.example.t5test.core.common.base.BaseDto;
import com.example.t5test.core.common.base.BaseVo;
import com.example.t5test.core.infra.code.CodeDto;
import com.example.t5test.core.infra.code.CodeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AbstractDao<VO extends BaseVo, DTO extends BaseDto> {
    int selectOneCount(VO vo);
    List<DTO> selectList(VO vo);
    DTO selectOne(VO vo);
    int insert(DTO dto);
    int update(DTO dto);
    int uelete(DTO dto);
    int delete(VO vo);
    List<DTO> selectListWithoutPaging();
}
