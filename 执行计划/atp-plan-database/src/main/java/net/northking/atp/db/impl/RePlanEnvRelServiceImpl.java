/*
 * Copyright (c) 京北方信息技术股份有限公司 Corporation 2019 . All rights reserved.
 *
 */
package net.northking.atp.db.impl;

import net.northking.atp.db.adapter.RePlanEnvRelSrvAdapter;
import net.northking.atp.db.dao.RePlanEnvRelDao;
import net.northking.atp.db.service.RePlanEnvRelService;
import net.northking.atp.db.persistent.RePlanEnvRel;

import net.northking.db.BasicDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 执行计划-环境关联表
 *
 * <p>文件内容由代码生成器产生，请不要手动修改！ <br>
 * createdate:  2019-08-05 16:56:26  <br>
 *
 * @author: database-mybatis-maven-plugin  <br>
 * @since: 1.0 <br>
 */
@Service
public class RePlanEnvRelServiceImpl extends RePlanEnvRelSrvAdapter implements RePlanEnvRelService {
    private static final Logger logger = LoggerFactory.getLogger(RePlanEnvRelServiceImpl.class);

    @Autowired
    private RePlanEnvRelDao rePlanEnvRelDao;

    protected BasicDao<RePlanEnvRel> getDao() {
        return rePlanEnvRelDao;
    }

// ----      The End by Generator     ----//

    @Override
    public long batchDeleteByPlanIds(List<String> planIds) {
      if (planIds != null && planIds.size() > 0) {
        return rePlanEnvRelDao.batchDeleteByPlanIds(planIds);
      }
      return 0;
    }


}

