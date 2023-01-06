package com.example.t5test.core.infra.code;

import com.example.t5test.core.common.base.BaseService;
import com.example.t5test.core.infra.codegroup.CodeGroupDao;
import com.example.t5test.core.infra.codegroup.CodeGroupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//@RequiredArgsConstructor
@Service
@RequiredArgsConstructor
public class CodeService extends BaseService {
    private final CodeDao dao;
    private final CodeGroupDao cgdao;
    public int selectOneCount(CodeVo vo) { return dao.selectOneCount(vo); }
    public List<CodeDto> selectList(CodeVo vo) { return dao.selectList(vo); }
    public CodeDto selectOne(CodeVo vo) { return dao.selectOne(vo); }
    public int insert(CodeDto dto) { return dao.insert(dto); }
    public int update(CodeDto dto) { return dao.update(dto); }
    public int uelete(CodeDto dto) { return dao.uelete(dto); }
    public int delete(CodeVo vo) { return dao.delete(vo); }
    public List<CodeDto> selectListWithoutPaging() { return dao.selectListWithoutPaging(); }
}
