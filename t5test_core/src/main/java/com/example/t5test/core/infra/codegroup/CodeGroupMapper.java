package com.example.t5test.core.infra.codegroup;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Repository
public interface CodeGroupMapper {
    List<CodeGroupDto> selectList();
    int insert(CodeGroupDto dto);
    int update(CodeGroupDto dto);
    CodeGroupDto selectOne(CodeGroupVo vo);


}
