package com.example.t5test.core.infra.menu;

import com.example.t5test.core.common.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService extends BaseService {
    private final MenuDao dao;
    public int selectOneCount(MenuVo vo) { return dao.selectOneCount(vo); }
    public List<MenuDto> selectList(MenuVo vo) { return dao.selectList(vo); }
    public MenuDto selectOne(MenuVo vo) { return dao.selectOne(vo); }
    public int insert(MenuDto dto) { return dao.insert(dto); }
    public int update(MenuDto dto) { return dao.update(dto); }
    public int uelete(MenuDto dto) { return dao.uelete(dto); }
    public int delete(MenuVo vo) { return dao.delete(vo); }
    public List<MenuDto> selectListWithoutPaging() { return dao.selectListWithoutPaging(); }
}
