package com.jxnu.os.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jxnu.os.mapper.ResourceMapper;
import com.jxnu.os.model.PageRequest;
import com.jxnu.os.model.PageResult;
import com.jxnu.os.model.Resource;
import com.jxnu.os.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiao
 */
@Service
public class ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    /**
     * 根据父节点查询所有资源记录
     * @param p_id
     * @return
     */
    public List<Resource> getAllRe (Integer p_id) {
        return resourceMapper.getAllRe(p_id);
    }

    public PageResult findPage(PageRequest pageRequest,Integer p_id) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,p_id));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Resource> getPageInfo(PageRequest pageRequest,Integer p_id) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Resource> resources = resourceMapper.selectPage(p_id);
        return new PageInfo<Resource>(resources);
    }

    /**
     * 添加资源记录
     * @param resource
     * @return
     */
    public Integer insert (Resource resource) {
        return resourceMapper.insert(resource);
    }

    /**
     * 根据ID删除资源记录
     * @param id
     * @return
     */
    public Integer deleteById (Integer id) {
        return resourceMapper.deleteById(id);
    }

    /**
     * 根据ID修改资源记录
     * @param resource
     * @return
     */
    public Integer updateRe (Resource resource) {
        return resourceMapper.updateRe(resource);
    }
}
