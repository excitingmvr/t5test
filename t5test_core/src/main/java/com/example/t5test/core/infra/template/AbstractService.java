package com.example.t5test.core.infra.template;

import com.example.t5test.core.common.base.BaseDto;
import com.example.t5test.core.common.base.BaseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public abstract class AbstractService<Dao extends AbstractDao<VO, DTO>, VO extends BaseVo, DTO extends BaseDto> {
    private final Dao dao;
    public int selectOneCount(VO vo) { return dao.selectOneCount(vo); }
    public List<DTO> selectList(VO vo) { return dao.selectList(vo); }
    public DTO selectOne(VO vo) { return dao.selectOne(vo); }
    public int insert(DTO dto) { return dao.insert(dto); }
    public int update(DTO dto) { return dao.update(dto); }
    public int uelete(DTO dto) { return dao.uelete(dto); }
    public int delete(VO vo) { return dao.delete(vo); }
    public List<DTO> selectListWithoutPaging() { return dao.selectListWithoutPaging(); }
}
