package com.example.t5test.core.infra.template.tests;

import com.example.t5test.core.infra.template.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class MyGroupService extends AbstractService<MyGroupDao, MyGroupVo, MyGroupDto> {
    public MyGroupService(MyGroupDao myGroupDao) {
        super(myGroupDao);
    }
}
