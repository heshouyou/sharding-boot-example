package com.sinochem.fintech.common;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: heshouyou
 * @Description  service架构
 * @Date Created in 2018/12/6 10:07
 */
public abstract class BaseService<T extends Mapper<E>,E> {

    @Autowired
    private T mapper;

    public T getMapper() {
        return mapper;
    }

    public void setMapper(T mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询列表
     * @Param:
     * @Return:
     */
    public List<E> selectList(E entity){
        return mapper.select(entity);
    }

    /**
     * 新增
     * @Param:
     * @Return:
     */
    public int insert(E entity){
        return mapper.insert(entity);
    }

    /**
     * 新增（有值添加没有值默认为空）
     * @Param:
     * @Return:
     */
    public int insertSelective(E entity){
        return mapper.insertSelective(entity);
    }

    /**
     * 通过主键更新
     * @Param:
     * @Return:
     */
    public int updateByPrimaryKey(E entity){
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     * 删除记录
     * @Param:
     * @Return:
     */
    public int delete(E entity){
        return mapper.delete(entity);
    }
}
