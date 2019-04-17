package com.netassist.pojo;

public class TbSwork {
    private Integer id;

    private Integer tid;

    private String file;

    private String score;

    private String committime;

    private Integer ttid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getCommittime() {
        return committime;
    }

    public void setCommittime(String committime) {
        this.committime = committime == null ? null : committime.trim();
    }

    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
    }
}