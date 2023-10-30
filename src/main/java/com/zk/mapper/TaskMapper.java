package com.zk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zk.entity.TaskEntity;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface TaskMapper extends BaseMapper<TaskEntity> {

    @Select("SELECT tt.*,tu.user_name as u_name FROM `mvc_zhoukai`.homework tt left join users tu on tu.id = tt.u_id where tu.id = #{uid} limit #{offset}, #{size}")
    List<TaskEntity> listByUidPaging(@Param("uid") Integer uid, @Param("offset") Integer offset, @Param("size") Integer size);


    /**
     * 查找已完成的 tId
     *
     * @return
     */
    @Select("SELECT t_id FROM homework_answer where  u_id = #{u_id}")
    List<Integer> selectCompletedByUid(@Param("u_id") Integer uid);


    /**
     * 插入答案
     *
     * @param uid
     * @return
     */
    @Insert("insert into homework_answer (t_id,u_id,content) values(#{t_id},#{u_id},#{content})")
    boolean insertTaskAnswer(@Param("u_id") Integer uid, @Param("t_id") String tId, @Param("content") String content);


    @Select("SELECT tsa.create_time ,tt.description,tu.user_name  FROM homework_answer tsa left join homework tt  on tt.id  = tsa.t_id left join users tu on tu.id = tsa.u_id where tt.id = #{t_id}")
    List<HashMap<String, String>> answerList(@Param("t_id") Integer tId);


}
