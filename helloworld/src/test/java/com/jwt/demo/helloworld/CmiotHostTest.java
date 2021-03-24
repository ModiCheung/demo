package com.jwt.demo.helloworld;

import com.jwt.demo.helloworld.entity.CmiotHostEntity;
import com.jwt.demo.helloworld.entity.CmiotKu8ResPartionEntity;
import com.jwt.demo.helloworld.entity.ResourceNamespaceEntity;
import com.jwt.demo.helloworld.entity.ResourceNodeEntity;
import com.jwt.demo.helloworld.mapper.CmiotHostMapper;
import com.jwt.demo.helloworld.mapper.CmiotKu8ResPartionMapper;
import com.jwt.demo.helloworld.mapper.ResNodeMapper;
import com.jwt.demo.helloworld.mapper.ResourceNamespaceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CmiotHostTest {

    @Autowired
    private CmiotHostMapper cmiotHostMapper;
    @Autowired
    private ResNodeMapper resNodeMapper;
    @Autowired
    private CmiotKu8ResPartionMapper cmiotKu8ResPartionMapper;
    @Autowired
    private ResourceNamespaceMapper resourceNamespaceMapper;
    
    @Test
    public void test() {
        List<CmiotHostEntity> all = cmiotHostMapper.findAll();
        List<ResourceNodeEntity> resourceNodeEntities = all.parallelStream().map(cmiotHost -> {
            ResourceNodeEntity resourceNodeEntity = new ResourceNodeEntity();
            resourceNodeEntity.setId(String.valueOf(cmiotHost.getId()));
            resourceNodeEntity.setInstance(cmiotHost.getIp());
            resourceNodeEntity.setNodeName(cmiotHost.getHostName());
            resourceNodeEntity.setClusterId(String.valueOf(cmiotHost.getClusterId()));
            if (cmiotHost.getClusterId() == 5) {
                resourceNodeEntity.setClusterName("crm-cluster-1");
            } else if (cmiotHost.getClusterId() == 7) {
                resourceNodeEntity.setClusterName("cbs-cluster-1");
            }
            return resourceNodeEntity;
        }).collect(Collectors.toList());
        resourceNodeEntities.forEach(resourceNodeEntity -> resNodeMapper.save(resourceNodeEntity));
    }

    @Test
    public void test1() {
        List<CmiotKu8ResPartionEntity> all = cmiotKu8ResPartionMapper.findAll();
        List<ResourceNamespaceEntity> resourceNamespaceEntities = all.parallelStream().map(cmiotKu8ResPartionEntity -> {
            ResourceNamespaceEntity resourceNamespaceEntity = new ResourceNamespaceEntity();
            resourceNamespaceEntity.setNamespaceId(String.valueOf(cmiotKu8ResPartionEntity.getId()));
            resourceNamespaceEntity.setNamespaceName(cmiotKu8ResPartionEntity.getNamespace());
            resourceNamespaceEntity.setClusterId(String.valueOf(cmiotKu8ResPartionEntity.getClusterId()));
            if (cmiotKu8ResPartionEntity.getClusterId() == 5) {
                resourceNamespaceEntity.setClusterName("crm-cluster-1");
            } else if (cmiotKu8ResPartionEntity.getClusterId() == 7) {
                resourceNamespaceEntity.setClusterName("cbs-cluster-1");
            }
            return resourceNamespaceEntity;
        }).collect(Collectors.toList());
        resourceNamespaceEntities.forEach(resourceNamespaceEntity -> resourceNamespaceMapper.save(resourceNamespaceEntity));
    }
}
