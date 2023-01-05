package com.example.t5test.core.infra.code;

import com.example.t5test.core.infra.codegroup.CodeGroupDto;
import com.example.t5test.core.infra.codegroup.CodeGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CodeDao {

    List<CodeGroupDto> selectList();
    int insert(CodeGroupDto dto);

    int update(CodeGroupDto dto);
    CodeGroupDto selectOne(CodeGroupVo vo);


}
