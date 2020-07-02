/*
* Copyright (c) 京北方信息技术股份有限公司 Corporation 2019 . All rights reserved.
*
*/
package net.northking.atp.db.ctrl;

import net.northking.atp.db.persistent.ReDataPool;
import net.northking.atp.db.service.ReDataPoolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.northking.atp.commons.http.QueryByPage;
import net.northking.atp.commons.http.QueryOrderBy;
import net.northking.atp.commons.http.ResultWrapper;
import net.northking.db.OrderBy;
import net.northking.db.Pagination;
import net.northking.db.mybatis.SqlOrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
* 数据池 API
*
* <p>文件内容由代码生成器产生，请不要手动修改！ <br>
  * createdate:  2019-07-18 20:11:30  <br>
  * @author:  database-mybatis-maven-plugin  <br>
  * @since:  1.0 <br>
*/
@Api(tags = {"底层数据服务--数据池"}, description = "由代码生成器自动生成")
@RestController
@RequestMapping(value = "/genCode")
public class ReDataPoolController
{

  /**
   * 数据池 数据库持久层服务
   */
  @Autowired
  private ReDataPoolService service;


  /**
   * 新增 数据池
   *
   * @param target 数据池
   * @return 接口返回
   */
  @ApiOperation(value = "新增 数据池", notes = "新增 数据池")
  @RequestMapping(value = "/ReDataPool/insert", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReDataPool> insert(@RequestBody ReDataPool target)
  {
  target.setId(UUID.randomUUID().toString().replace("-", ""));
    service.insert(target);
    return new ResultWrapper<ReDataPool>().success(target);
  }

  /**
   * 新增批量 数据池
   *
   * @param list 批量数据池
   * @return 接口返回
   */
  @ApiOperation(value = "批量新增 数据池", notes = "批量新增 数据池")
  @RequestMapping(value = "/ReDataPool/insertBatch", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper insertBatch(@RequestBody List<ReDataPool> list)
  {
    for (ReDataPool target : list)
    {
      target.setId(UUID.randomUUID().toString().replace("-", ""));
    }
    service.insertByBatch(list);
    return new ResultWrapper().success();
  }

  /**
   * 根据主键修改 数据池
   *
   * @param target 数据池
   * @return 接口返回
   */
  @ApiOperation(value = "修改 数据池", notes = "根据主键修改 数据池")
  @RequestMapping(value = "/ReDataPool/updateByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReDataPool> updateByPrimaryKey(@RequestBody ReDataPool target)
  {
    service.updateByPrimaryKey(target);
    ReDataPool newOne = service.findByPrimaryKey(target);
    return new ResultWrapper<ReDataPool>().success(newOne);
  }

  /**
   * 根据主键删除 数据池
   *
   * @param id 主键
   * @return 接口返回
   */
  @ApiOperation(value = "删除 数据池", notes = "根据主键删除 数据池",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReDataPool/deleteByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper deleteByPrimaryKey(@RequestParam("id") String id)
  {
    service.deleteByPrimaryKey(id);
    return new ResultWrapper().success();
  }

  /**
  * 根据主键批量删除 数据池
  *
  * @param ids 主键数组
  * @return 接口返回
  */
  @ApiOperation(value = "批量删除 数据池", notes = "根据主键批量删除 数据池",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReDataPool/deleteByPrimaryKeys", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper deleteByPrimaryKeys(@RequestParam("ids") String[] ids)
  {
    service.deleteByPrimaryKey(ids);
    return new ResultWrapper().success();
  }

  /**
   * 查询全部 数据池
   *
   * @param target 查询条件
   * @return 接口返回
   */
  @ApiOperation(value = "查询全部 数据池", notes = "查询全部 数据池")
  @RequestMapping(value = "/ReDataPool/query", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<List<ReDataPool>> query(@RequestBody ReDataPool target)
  {
    return new ResultWrapper<List<ReDataPool>>().success(service.query(target));
  }

  /**
   * 分页查询 数据池
   * @param queryByPage 分页查询对象
   * @return 接口返回
   */
  @ApiOperation(value = "分页查询 数据池", notes = "分页查询 数据池")
  @RequestMapping(value = "/ReDataPool/queryByPage", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<Pagination<ReDataPool>> queryByPage(@RequestBody QueryByPage<ReDataPool> queryByPage)
  {
    OrderBy orderBy = new SqlOrderBy();
    for (QueryOrderBy queryOrderBy : queryByPage.getOrderByList())
    {
      orderBy.addOrderBy(queryOrderBy.getColumn(), queryOrderBy.getDir());
    }
    Pagination<ReDataPool> result = service.query(queryByPage.getQuery(), orderBy, queryByPage.getPageNo(), queryByPage.getPageSize());
    return new ResultWrapper<Pagination<ReDataPool>>().success(result);
  }

  /**
   * 查询记录数 数据池
   *
   * @param target 查询条件
   * @return 接口返回
   */
  @ApiOperation(value = "查询记录数 数据池", notes = "查询记录数 数据池")
  @RequestMapping(value = "/ReDataPool/queryCount", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<Long> queryCount(@RequestBody ReDataPool target)
  {
    return new ResultWrapper<Long>().success(service.queryCount(target));
  }

  /**
   * 根据主键查询 数据池
   *
   * @param id 主键
   * @return 接口返回
   */
  @ApiOperation(value = "查询 数据池", notes = "根据主键查询 数据池",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReDataPool/findByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReDataPool> findByPrimaryKey(@RequestParam("id") String id)
  {
    ResultWrapper<ReDataPool> resultWrapper = new ResultWrapper<ReDataPool>();
    ReDataPool record = service.findByPrimaryKey(id);
    if (record == null)
    {
      resultWrapper.fail("0000001", "不存在[主键=" + id + "]的记录！");
    } else
    {
      resultWrapper.success(service.findByPrimaryKey(id));
    }
    return resultWrapper;
  }


}

