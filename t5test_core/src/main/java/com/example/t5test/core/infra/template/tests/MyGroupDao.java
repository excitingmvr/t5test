package com.example.t5test.core.infra.template.tests;

import com.example.t5test.core.infra.template.AbstractDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MyGroupDao extends AbstractDao<MyGroupVo, MyGroupDto> {
}
