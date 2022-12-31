package com.example.t5test.core.infra.codegroup;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class CodeGroupService {
    private final CodeGroupMapper mapper;

    @Qualifier("SqlSessionTemplateMysqlSub")
    private final CodeGroup2Mapper mapper2;
    public List<CodeGroupDto> selectList() { return mapper.selectList(); }
//    public int insert(CodeGroup dto) {
//        return codeGroupDao.insert(dto);
//    }
//    public int update(CodeGroup dto) {
//        return codeGroupDao.update(dto);
//    }
//    public CodeGroup selectOne(CodeGroupVo vo) {
//        return codeGroupDao.selectOne(vo);
//    }

}
