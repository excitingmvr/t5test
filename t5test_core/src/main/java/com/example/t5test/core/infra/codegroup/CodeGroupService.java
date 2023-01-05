package com.example.t5test.core.infra.codegroup;

import com.example.t5test.core.common.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class CodeGroupService extends BaseService {
    private final CodeGroupDao dao;
    public int selectOneCount(CodeGroupVo vo) { return dao.selectOneCount(vo); }
    public List<CodeGroupDto> selectList(CodeGroupVo vo) { return dao.selectList(vo); }
    public CodeGroupDto selectOne(CodeGroupVo vo) { return dao.selectOne(vo); }
    public int insert(CodeGroupDto dto) { return dao.insert(dto); }
    public int update(CodeGroupDto dto) { return dao.update(dto); }
    public int uelete(CodeGroupDto dto) { return dao.uelete(dto); }
    public int delete(CodeGroupVo vo) { return dao.delete(vo); }
}
