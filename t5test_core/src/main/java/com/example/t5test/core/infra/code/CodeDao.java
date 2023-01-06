package com.example.t5test.core.infra.code;

import com.example.t5test.core.infra.codegroup.CodeGroupDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeDao {

    int selectOneCount(CodeVo vo);
    List<CodeDto> selectList(CodeVo vo);
    CodeDto selectOne(CodeVo vo);
    int insert(CodeDto dto);
    int update(CodeDto dto);
    int uelete(CodeDto dto);
    int delete(CodeVo vo);
    List<CodeDto> selectListWithoutPaging();


}
