package com.example.t5test.core.infra.codegroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class CodeGroupService {
    private final CodeGroupDao mapper;

    public List<CodeGroupDto> selectList(CodeGroupVo vo) {
        return mapper.selectList(vo);
    }
    public int insert(CodeGroupDto dto) {
        return mapper.insert(dto);
    }
    public int update(CodeGroupDto dto) {
        return mapper.update(dto);
    }
    public CodeGroupDto selectOne(CodeGroupVo vo) { return mapper.selectOne(vo); }
    public int delete(CodeGroupVo vo) { return mapper.delete(vo); }
    public int selectOneCount(CodeGroupVo vo) { return mapper.selectOneCount(vo); }
    public int uelete(CodeGroupDto dto) { return mapper.uelete(dto); }
}
