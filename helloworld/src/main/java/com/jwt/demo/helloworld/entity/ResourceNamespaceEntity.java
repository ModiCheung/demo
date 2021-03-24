package com.jwt.demo.helloworld.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "resource_namespace", schema = "mon", catalog = "")
public class ResourceNamespaceEntity {
    private String namespaceId;
    private String namespaceName;
    private String clusterId;
    private String clusterName;
    private String tenantId;
    private String tenantName;

    @Id
    @Basic
    @Column(name = "namespace_id")
    public String getNamespaceId() {
        return namespaceId;
    }

    public void setNamespaceId(String namespaceId) {
        this.namespaceId = namespaceId;
    }

    @Basic
    @Column(name = "namespace_name")
    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName = namespaceName;
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
        ResourceNamespaceEntity that = (ResourceNamespaceEntity) o;
        return Objects.equals(namespaceId, that.namespaceId) &&
                Objects.equals(namespaceName, that.namespaceName) &&
                Objects.equals(clusterId, that.clusterId) &&
                Objects.equals(clusterName, that.clusterName) &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(tenantName, that.tenantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespaceId, namespaceName, clusterId, clusterName, tenantId, tenantName);
    }
}
