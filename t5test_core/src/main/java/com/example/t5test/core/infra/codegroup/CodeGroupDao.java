package com.example.t5test.core.infra.codegroup;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeGroupDao {

    int selectOneCount(CodeGroupVo vo);
    List<CodeGroupDto> selectList(CodeGroupVo vo);
    CodeGroupDto selectOne(CodeGroupVo vo);
    int insert(CodeGroupDto dto);
    int update(CodeGroupDto dto);
    int uelete(CodeGroupDto dto);
    int delete(CodeGroupVo vo);


}
