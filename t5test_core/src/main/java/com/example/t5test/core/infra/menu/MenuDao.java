package com.example.t5test.core.infra.menu;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    int selectOneCount(MenuVo vo);
    List<MenuDto> selectList(MenuVo vo);
    MenuDto selectOne(MenuVo vo);
    int insert(MenuDto dto);
    int update(MenuDto dto);
    int uelete(MenuDto dto);
    int delete(MenuVo vo);
    List<MenuDto> selectListWithoutPaging();


}
