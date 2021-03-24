package com.jwt.demo.helloworld.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "resource_node", schema = "mon", catalog = "")
public class ResourceNodeEntity {
    private String id;
    private String instance;
    private String nodeName;
    private String clusterId;
    private String clusterName;
    private String tenantId;
    private String tenantName;

    @Id
    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "instance")
    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    @Basic
    @Column(name = "node_name")
    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Basic
    @Column(name = "cluster_id")
    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    @Basic
    @Column(name = "cluster_name")
    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Basic
    @Column(name = "tenant_id")
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "tenant_name")
    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceNodeEntity that = (ResourceNodeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(instance, that.instance) &&
                Objects.equals(nodeName, that.nodeName) &&
                Objects.equals(clusterId, that.clusterId) &&
                Objects.equals(clusterName, that.clusterName) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(tenantName, that.tenantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instance, nodeName, clusterId, clusterName, tenantId, tenantName);
    }
}
