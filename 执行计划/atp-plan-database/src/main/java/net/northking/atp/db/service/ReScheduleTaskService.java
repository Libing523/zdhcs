/*
* Copyright (c) 京北方信息技术股份有限公司 Corporation 2019 . All rights reserved.
*
*/
package net.northking.atp.db.service;

import net.northking.db.BasicService;
import net.northking.atp.db.persistent.ReScheduleTask;

import java.util.List;

public interface ReScheduleTaskService extends BasicService<ReScheduleTask>
{
// ----      The End by Generator     ----//

    List<ReScheduleTask> queryNotCreateTask(ReScheduleTask task);
}
