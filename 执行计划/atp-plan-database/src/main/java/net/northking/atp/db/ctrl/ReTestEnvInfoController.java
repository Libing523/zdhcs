/*
* Copyright (c) 京北方信息技术股份有限公司 Corporation 2019 . All rights reserved.
*
*/
package net.northking.atp.db.ctrl;

import net.northking.atp.db.persistent.ReTestEnvInfo;
import net.northking.atp.db.service.ReTestEnvInfoService;

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
* 测试环境信息表 API
*
* <p>文件内容由代码生成器产生，请不要手动修改！ <br>
  * createdate:  2019-08-08 19:11:46  <br>
  * @author:  database-mybatis-maven-plugin  <br>
  * @since:  1.0 <br>
*/
@Api(tags = {"底层数据服务--测试环境信息表"}, description = "由代码生成器自动生成")
@RestController
@RequestMapping(value = "/genCode")
public class ReTestEnvInfoController
{

  /**
   * 测试环境信息表 数据库持久层服务
   */
  @Autowired
  private ReTestEnvInfoService service;


  /**
   * 新增 测试环境信息表
   *
   * @param target 测试环境信息表
   * @return 接口返回
   */
  @ApiOperation(value = "新增 测试环境信息表", notes = "新增 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/insert", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReTestEnvInfo> insert(@RequestBody ReTestEnvInfo target)
  {
  target.setId(UUID.randomUUID().toString().replace("-", ""));
    service.insert(target);
    return new ResultWrapper<ReTestEnvInfo>().success(target);
  }

  /**
   * 新增批量 测试环境信息表
   *
   * @param list 批量测试环境信息表
   * @return 接口返回
   */
  @ApiOperation(value = "批量新增 测试环境信息表", notes = "批量新增 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/insertBatch", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper insertBatch(@RequestBody List<ReTestEnvInfo> list)
  {
    for (ReTestEnvInfo target : list)
    {
      target.setId(UUID.randomUUID().toString().replace("-", ""));
    }
    service.insertByBatch(list);
    return new ResultWrapper().success();
  }

  /**
   * 根据主键修改 测试环境信息表
   *
   * @param target 测试环境信息表
   * @return 接口返回
   */
  @ApiOperation(value = "修改 测试环境信息表", notes = "根据主键修改 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/updateByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReTestEnvInfo> updateByPrimaryKey(@RequestBody ReTestEnvInfo target)
  {
    service.updateByPrimaryKey(target);
    ReTestEnvInfo newOne = service.findByPrimaryKey(target);
    return new ResultWrapper<ReTestEnvInfo>().success(newOne);
  }

  /**
   * 根据主键删除 测试环境信息表
   *
   * @param id 主键
   * @return 接口返回
   */
  @ApiOperation(value = "删除 测试环境信息表", notes = "根据主键删除 测试环境信息表",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReTestEnvInfo/deleteByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper deleteByPrimaryKey(@RequestParam("id") String id)
  {
    service.deleteByPrimaryKey(id);
    return new ResultWrapper().success();
  }

  /**
  * 根据主键批量删除 测试环境信息表
  *
  * @param ids 主键数组
  * @return 接口返回
  */
  @ApiOperation(value = "批量删除 测试环境信息表", notes = "根据主键批量删除 测试环境信息表",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReTestEnvInfo/deleteByPrimaryKeys", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper deleteByPrimaryKeys(@RequestParam("ids") String[] ids)
  {
    service.deleteByPrimaryKey(ids);
    return new ResultWrapper().success();
  }

  /**
   * 查询全部 测试环境信息表
   *
   * @param target 查询条件
   * @return 接口返回
   */
  @ApiOperation(value = "查询全部 测试环境信息表", notes = "查询全部 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/query", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<List<ReTestEnvInfo>> query(@RequestBody ReTestEnvInfo target)
  {
    return new ResultWrapper<List<ReTestEnvInfo>>().success(service.query(target));
  }

  /**
   * 分页查询 测试环境信息表
   * @param queryByPage 分页查询对象
   * @return 接口返回
   */
  @ApiOperation(value = "分页查询 测试环境信息表", notes = "分页查询 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/queryByPage", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<Pagination<ReTestEnvInfo>> queryByPage(@RequestBody QueryByPage<ReTestEnvInfo> queryByPage)
  {
    OrderBy orderBy = new SqlOrderBy();
    for (QueryOrderBy queryOrderBy : queryByPage.getOrderByList())
    {
      orderBy.addOrderBy(queryOrderBy.getColumn(), queryOrderBy.getDir());
    }
    Pagination<ReTestEnvInfo> result = service.query(queryByPage.getQuery(), orderBy, queryByPage.getPageNo(), queryByPage.getPageSize());
    return new ResultWrapper<Pagination<ReTestEnvInfo>>().success(result);
  }

  /**
   * 查询记录数 测试环境信息表
   *
   * @param target 查询条件
   * @return 接口返回
   */
  @ApiOperation(value = "查询记录数 测试环境信息表", notes = "查询记录数 测试环境信息表")
  @RequestMapping(value = "/ReTestEnvInfo/queryCount", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<Long> queryCount(@RequestBody ReTestEnvInfo target)
  {
    return new ResultWrapper<Long>().success(service.queryCount(target));
  }

  /**
   * 根据主键查询 测试环境信息表
   *
   * @param id 主键
   * @return 接口返回
   */
  @ApiOperation(value = "查询 测试环境信息表", notes = "根据主键查询 测试环境信息表",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/ReTestEnvInfo/findByPrimaryKey", method = {RequestMethod.POST},
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResultWrapper<ReTestEnvInfo> findByPrimaryKey(@RequestParam("id") String id)
  {
    ResultWrapper<ReTestEnvInfo> resultWrapper = new ResultWrapper<ReTestEnvInfo>();
    ReTestEnvInfo record = service.findByPrimaryKey(id);
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

