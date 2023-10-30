package com.zk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zk.entity.TaskEntity;
import javafx.concurrent.Task;

import java.util.HashMap;
import java.util.List;

public interface ITaskService extends IService<TaskEntity> {



    List<TaskEntity> studentTaskList(int uId);


    List<TaskEntity> listByUidPaging(Integer uId,Integer pageNum,Integer pageSize);


    boolean submitTaskAnswer(String tid,Integer uId, String content);



    List<HashMap<String,String>> answerListByTid(Integer tid);
}
