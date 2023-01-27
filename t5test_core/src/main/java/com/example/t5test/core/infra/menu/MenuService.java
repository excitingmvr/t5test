package com.example.t5test.core.infra.menu;

import com.example.t5test.core.common.base.BaseService;
import com.example.t5test.core.infra.auth.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.t5test.core.infra.auth.AuthDao;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService extends BaseService {
    private final MenuDao dao;
    private final AuthDao Adao;
    public int selectOneCount(MenuVo vo) { return dao.selectOneCount(vo); }
    public List<MenuDto> selectList(MenuVo vo) { return dao.selectList(vo); }
    public MenuDto selectOne(MenuVo vo) { return dao.selectOne(vo); }
    public int insert(MenuDto dto) {
        dao.insert(dto);

        for(AuthDto AuthSeq : Adao.selectListWithoutPaging()) {
            dto.setIfatSeq(AuthSeq.getIfatSeq());
            dao.AuthMenuInsert(dto);
        }
        return 0;
    }
    public int update(MenuDto dto) { return dao.update(dto); }
    public int uelete(MenuDto dto) { return dao.uelete(dto); }
    public int delete(MenuVo vo) { return dao.delete(vo); }

}
