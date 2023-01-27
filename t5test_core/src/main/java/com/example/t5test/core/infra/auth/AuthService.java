package com.example.t5test.core.infra.auth;

import com.example.t5test.core.common.base.BaseService;
import com.example.t5test.core.infra.menu.MenuDao;
import com.example.t5test.core.infra.menu.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthService extends BaseService {
        private final AuthDao dao;
        private final MenuDao Mdao;
        public int selectOneCount(AuthVo vo) { return dao.selectOneCount(vo); }
        public List<AuthDto> selectList(AuthVo vo) { return dao.selectList(vo); }
        public AuthDto selectOne(AuthVo vo) { return dao.selectOne(vo); }
        public int insert(AuthDto dto) {
                dao.insert(dto);
                for(MenuDto MenuSeq : Mdao.selectListWithoutPaging()) {
                        dto.setIfmuSeq(MenuSeq.getIfmuSeq());
                        dao.AuthMenuInsert(dto);
                }
                return 0;
        }
        public int update(AuthDto dto) { return dao.update(dto); }
        public int uelete(AuthDto dto) { return dao.uelete(dto); }
        public int delete(AuthVo vo) { return dao.delete(vo); }
        public  List<AuthDto> selectListWithoutPaging() { return dao.selectListWithoutPaging(); }

}

// menu -> insert -> authMenu = ifmu = 1 /ifat= null