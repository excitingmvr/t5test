package com.example.t5test.core.infra.auth;

import java.util.List;

public interface AuthDao {

    int selectOneCount(AuthVo vo);
    List<AuthDto> selectList(AuthVo vo);
    AuthDto selectOne(AuthVo vo);
    int insert(AuthDto dto);
    int AuthMenuInsert(AuthDto dto);
    int update(AuthDto dto);
    int uelete(AuthDto dto);
    int delete(AuthVo vo);

    List<AuthDto> selectListWithoutPaging();
}
