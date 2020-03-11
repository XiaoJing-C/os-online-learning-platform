package com.jxnu.os.mapper;

import com.jxnu.os.model.Resource;

import java.util.List;

/**
 * @author xiao
 */
public interface ResourceMapper {

    List<Resource> getAllRe (Integer p_id);

    List<Resource> selectPage(Integer p_id);

    int insert (Resource resource);

    int deleteById (Integer id);

    int updateRe (Resource resource);

}
