package com.netassist.pojo;

public class TbSwork {
    private Integer id;

    private Integer tid;

    private String file;

    private String score;

    private String committime;

    private Integer ttid;

    private String isdowload;

    private Integer sid;

    private String stuname;
    private String teachername;
    
    private String status="未批改";
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

    public String getIsdowload() {
        return isdowload;
    }

    public void setIsdowload(String isdowload) {
        this.isdowload = isdowload == null ? null : isdowload.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}