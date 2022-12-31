package com.example.t5test.core.infra.codegroup;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeGroup2Mapper {
    List<CodeGroupDto> selectList();
    int insert(CodeGroupDto dto);
    int update(CodeGroupDto dto);
    CodeGroupDto selectOne(CodeGroupVo vo);
}
