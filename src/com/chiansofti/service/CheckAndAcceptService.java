package com.chiansofti.service;

import java.util.List;
import java.util.Map;

/**
 * 2019年8月8日 @CH
 */
public interface CheckAndAcceptService {
    Map<String, List<String>> getApplyList(String deptno);
    void subCheck(String[][] data);
    Map<String, List<String>> getCurApplyDetail(String tablenum);
    List<String> getCurApply(String tablenum);
}

