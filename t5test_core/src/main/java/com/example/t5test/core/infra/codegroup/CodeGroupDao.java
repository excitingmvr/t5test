package com.example.t5test.core.infra.codegroup;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeGroupDao {

    List<CodeGroupDto> selectList(CodeGroupVo vo);
    int insert(CodeGroupDto dto);
    int update(CodeGroupDto dto);
    CodeGroupDto selectOne(CodeGroupVo vo);
    int delete(CodeGroupVo vo);
    int selectOneCount(CodeGroupVo vo);
    int uelete(CodeGroupDto dto);

}
