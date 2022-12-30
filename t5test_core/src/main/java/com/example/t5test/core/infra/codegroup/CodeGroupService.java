package com.example.t5test.core.infra.codegroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class CodeGroupService {
    private final CodeGroupMapper mapper;
    public List<CodeGroupDto> selectList() {
        return mapper.selectList();
    }
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
