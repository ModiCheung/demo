package com.jwt.demo.helloworld.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cmiot_ku8_res_partion", schema = "mon", catalog = "")
public class CmiotKu8ResPartionEntity {
    private int id;
    private int clusterId;
    private Integer tenantId;
    private String namespace;
    private Integer podLimit;
    private Integer cpuLimit;
    private Long memoryLimit;
    private Integer rcLimit;
    private Integer serviceLimit;
    private Integer pvLimit;
    private String note;
    private Integer nodeNumber;
    private Timestamp lastUpdated;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CLUSTER_ID")
    public int getClusterId() {
        return clusterId;
    }

    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }

    @Basic
    @Column(name = "tenantId")
    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    @Basic
    @Column(name = "NAMESPACE")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Basic
    @Column(name = "POD_LIMIT")
    public Integer getPodLimit() {
        return podLimit;
    }

    public void setPodLimit(Integer podLimit) {
        this.podLimit = podLimit;
    }

    @Basic
    @Column(name = "CPU_LIMIT")
    public Integer getCpuLimit() {
        return cpuLimit;
    }

    public void setCpuLimit(Integer cpuLimit) {
        this.cpuLimit = cpuLimit;
    }

    @Basic
    @Column(name = "MEMORY_LIMIT")
    public Long getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Long memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    @Basic
    @Column(name = "RC_LIMIT")
    public Integer getRcLimit() {
        return rcLimit;
    }

    public void setRcLimit(Integer rcLimit) {
        this.rcLimit = rcLimit;
    }

    @Basic
    @Column(name = "SERVICE_LIMIT")
    public Integer getServiceLimit() {
        return serviceLimit;
    }

    public void setServiceLimit(Integer serviceLimit) {
        this.serviceLimit = serviceLimit;
    }

    @Basic
    @Column(name = "PV_LIMIT")
    public Integer getPvLimit() {
        return pvLimit;
    }

    public void setPvLimit(Integer pvLimit) {
        this.pvLimit = pvLimit;
    }

    @Basic
    @Column(name = "NOTE")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "NODE_NUMBER")
    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    @Basic
    @Column(name = "LAST_UPDATED")
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmiotKu8ResPartionEntity that = (CmiotKu8ResPartionEntity) o;
        return id == that.id &&
                clusterId == that.clusterId &&
                Objects.equals(tenantId, that.tenantId) &&
                Objects.equals(namespace, that.namespace) &&
                Objects.equals(podLimit, that.podLimit) &&
                Objects.equals(cpuLimit, that.cpuLimit) &&
                Objects.equals(memoryLimit, that.memoryLimit) &&
                Objects.equals(rcLimit, that.rcLimit) &&
                Objects.equals(serviceLimit, that.serviceLimit) &&
                Objects.equals(pvLimit, that.pvLimit) &&
                Objects.equals(note, that.note) &&
                Objects.equals(nodeNumber, that.nodeNumber) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clusterId, tenantId, namespace, podLimit, cpuLimit, memoryLimit, rcLimit, serviceLimit, pvLimit, note, nodeNumber, lastUpdated);
    }
}
