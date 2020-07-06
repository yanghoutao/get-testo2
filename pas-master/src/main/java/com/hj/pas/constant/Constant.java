package com.hj.pas.constant;

import java.time.format.DateTimeFormatter;

/**
 * 常量
 *
 * @author kingboat
 * @date 2019/3/24 16:03
 */
public class Constant {

  public static final DateTimeFormatter formatter =
          DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  public static final DateTimeFormatter yMdHm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  /**
   * redis-OK
   */
  public static final String OK = "OK";

  public static final String DEFAULT_CYCLE = "202006";
}
