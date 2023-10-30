package com.example.userservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zk.entity.TaskEntity;
import com.zk.entity.UserEntity;
import com.zk.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Slf4j
@RestController
@RequestMapping("/api/task")
public class TaskApi extends BaseApi {


    private ITaskService taskService;


    /**
     * 添加作业
     *
     * @param task
     * @param request
     * @return
     */
    @PostMapping("")
    public HashMap<String, Object> add(@RequestBody TaskEntity task, HttpServletRequest request) {
        log.info("task = {}", task);
        UserEntity user = user(request);
        task.setUId(user.getId());
        task.setPublishTime(new Date());
        boolean res = taskService.save(task);
        if (res) {
            return genResponseResult(200, null, "添加成功");
        }
        return genResponseResult(500, null, "添加失败");
    }

    /**
     * 删除作业
     *
     * @param id
     * @param request
     * @return
     */
    @DeleteMapping("/{id}")
    public HashMap<String, Object> delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        boolean res = taskService.removeById(id);
        if (res) {
            return genResponseResult(200, null, "删除成功");
        }
        return genResponseResult(500, null, "删除失败");
    }


    /**
     * 更新作业
     *
     * @param request
     * @return
     */
    @PutMapping("")
    public HashMap<String, Object> update(@RequestBody TaskEntity task, HttpServletRequest request) {
        log.info("task = {}", task);
        boolean res = taskService.updateById(task);
        if (res) {
            return genResponseResult(200, null, "修改成功");
        }
        return genResponseResult(500, null, "修改失败");
    }


    /**
     * 获取列表
     *
     * @param params
     * @param request
     * @return
     */
    @GetMapping("/list")
    public HashMap<String, Object> list(@RequestParam("page_num") Integer pageNum, @RequestParam("page_size") Integer pageSize, HttpServletRequest request) {
        UserEntity user = user(request);
        List<TaskEntity> taskEntityList = taskService.listByUidPaging(user.getId(), pageNum, pageSize);
        HashMap<String, Object> res = new HashMap<>();


        QueryWrapper<TaskEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",user.getId());
        res.put("list", taskEntityList);
        res.put("total_count", taskService.count(wrapper));
        res.put("page_num", pageNum);
        res.put("page_size", pageSize);

        return genResponseResult(200, res, "修改成功");
    }


    /**
     * 学生获取作业接口
     *
     * @param params
     * @param request
     * @return
     */
    @GetMapping("/student/list")
    public HashMap<String, Object> taskList(@RequestParam Map<String, String> params, HttpServletRequest request) {
        UserEntity user = user(request);
        List<TaskEntity> taskEntityList = taskService.studentTaskList(user.getId());
        return genResponseResult(200, taskEntityList, "修改成功");
    }


    /**
     * 提交作业
     *
     * @param params
     * @param request
     * @return
     */
    @PostMapping("/answer")
    public HashMap<String, Object> submit(@RequestParam Map<String, String> params, HttpServletRequest request) {
        log.info("params = {}", params);
        UserEntity user = user(request);
        String tid = params.get("tId");
        String content = params.get("content");
        boolean res = taskService.submitTaskAnswer(tid, user.getId(), content);
        if (res) {
            return genResponseResult(200, null, "提交成功");
        }
        return genResponseResult(500, null, "提交失败");
    }


    /**
     * 获取作业的提交列表
     *
     * @param taskId
     * @param request
     * @return
     */
    @GetMapping("/answer-list/{taskId}")
    public HashMap<String, Object> submit(@PathVariable("taskId") Integer taskId, HttpServletRequest request) {
        return genResponseResult(200, taskService.answerListByTid(taskId), "获取成功");
    }


    @Autowired
    public void setTaskService(ITaskService taskService) {
        this.taskService = taskService;
    }
}
