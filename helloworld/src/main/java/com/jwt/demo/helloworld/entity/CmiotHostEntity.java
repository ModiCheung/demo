package com.jwt.demo.helloworld.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cmiot_host_copy", schema = "mon", catalog = "")
public class CmiotHostEntity {
    private int id;
    private Integer zoneId;
    private String hostName;
    private String ip;
    private String rootPasswd;
    private String location;
    private String note;
    private Timestamp lastUpdated;
    private Short cores;
    private Integer memory;
    private Byte usageFlag;
    private Byte sshLogin;
    private Integer clusterId;
    private Integer pods;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ZONE_ID")
    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    @Basic
    @Column(name = "HOST_NAME")
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Basic
    @Column(name = "IP")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "ROOT_PASSWD")
    public String getRootPasswd() {
        return rootPasswd;
    }

    public void setRootPasswd(String rootPasswd) {
        this.rootPasswd = rootPasswd;
    }

    @Basic
    @Column(name = "LOCATION")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @Column(name = "LAST_UPDATED")
    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Basic
    @Column(name = "CORES")
    public Short getCores() {
        return cores;
    }

    public void setCores(Short cores) {
        this.cores = cores;
    }

    @Basic
    @Column(name = "MEMORY")
    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    @Basic
    @Column(name = "USAGE_FLAG")
    public Byte getUsageFlag() {
        return usageFlag;
    }

    public void setUsageFlag(Byte usageFlag) {
        this.usageFlag = usageFlag;
    }

    @Basic
    @Column(name = "SSH_LOGIN")
    public Byte getSshLogin() {
        return sshLogin;
    }

    public void setSshLogin(Byte sshLogin) {
        this.sshLogin = sshLogin;
    }

    @Basic
    @Column(name = "CLUSTER_ID")
    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    @Basic
    @Column(name = "PODS")
    public Integer getPods() {
        return pods;
    }

    public void setPods(Integer pods) {
        this.pods = pods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CmiotHostEntity that = (CmiotHostEntity) o;
        return id == that.id &&
                Objects.equals(zoneId, that.zoneId) &&
                Objects.equals(hostName, that.hostName) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(rootPasswd, that.rootPasswd) &&
                Objects.equals(location, that.location) &&
                Objects.equals(note, that.note) &&
                Objects.equals(lastUpdated, that.lastUpdated) &&
                Objects.equals(cores, that.cores) &&
                Objects.equals(memory, that.memory) &&
                Objects.equals(usageFlag, that.usageFlag) &&
                Objects.equals(sshLogin, that.sshLogin) &&
                Objects.equals(clusterId, that.clusterId) &&
                Objects.equals(pods, that.pods);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zoneId, hostName, ip, rootPasswd, location, note, lastUpdated, cores, memory, usageFlag, sshLogin, clusterId, pods);
    }
}
