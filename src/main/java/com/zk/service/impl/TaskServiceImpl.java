package com.zk.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zk.entity.TaskEntity;
import com.zk.mapper.TaskMapper;
import com.zk.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskEntity> implements ITaskService {

    @Override
    public List<TaskEntity> listByUidPaging(Integer uid, Integer pageNum, Integer pageSize) {
        Integer start = (pageNum - 1) * pageSize;
        return baseMapper.listByUidPaging(uid, start, pageSize);
    }

    @Override
    public List<TaskEntity> studentTaskList(int uId) {
        List<TaskEntity> res = baseMapper.selectList(Wrappers.emptyWrapper());
        List<Integer> completedTIdList = baseMapper.selectCompletedByUid(uId);

        log.info("completedTIdList = {}", completedTIdList);

        HashMap<String, Integer> tidMap = new HashMap<>();
        for (int i = 0; i < completedTIdList.size(); i++) {
            tidMap.put(completedTIdList.get(i) + "", 1);
        }
        log.info("tidMap = {}", tidMap);

        for (TaskEntity t : res) {
            int flag = tidMap.get(t.getId() + "") == null ? 0 : 1;
            t.setSubmitStatus(flag);
        }
        return res;
    }


    @Override
    public boolean submitTaskAnswer(String tid, Integer uId, String content) {
        TaskEntity task = getById(Integer.parseInt(tid));
        task.setCommitNum(task.getCommitNum() + 1);
        updateById(task); // 提交人数加一
        return baseMapper.insertTaskAnswer(uId, tid, content);
    }

    @Override
    public List<HashMap<String, String>> answerListByTid(Integer tid) {
        return baseMapper.answerList(tid);
    }


}
