package com.ycy.service.impl;

import com.ycy.center.dao.entity.YcyTable;
import com.ycy.center.dao.mapper.YcyTableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ycy on 16/7/19.
 */
@Service
public class TestServiceImpl implements com.ycy.service.TestService {
  @Autowired
  private YcyTableMapper ycyTableMapper;

  @Transactional
  public void testInsert(int num, String name) {
    try {
      YcyTable ycyTable = new YcyTable();
      ycyTable.setName(name);
      ycyTable.setNum(num);
      ycyTableMapper.insert(ycyTable);
      if (num == 3) {
        int i = 1 / 0;// 此处会产生异常
      }
    } catch (Exception ex) {
      System.out.println(num + "service异常日志处理");
    }
    System.out.println(num + "service正常执行");
  }
}
