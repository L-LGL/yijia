package com.zt.pojo;

import java.io.Serializable;
import java.util.Date;

public class store implements Serializable {

	private int id;
	private String name;
	private String boss;
	private int grade;
	private String info;
	private String license;
	private int status;
	private Date create;
	private Date update;
	private Date delete;

	public store() {
	}

	public store(String name, String boos, int grade, String info, String license, int status, Date create, Date update) {
		this.name = name;
		this.boss = boos;
		this.grade = grade;
		this.info = info;
		this.license = license;
		this.status = status;
		this.create = create;
		this.update = update;
	}
	public store(String name, String boos , String info, String license, int status, Date update) {
		this.name = name;
		this.boss = boos;
		this.info = info;
		this.license = license;
		this.status = status;
		this.update = update;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoos() {
		return boss;
	}

	public void setBoos(String boos) {
		this.boss = boos;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public Date getDelete() {
		return delete;
	}

	public void setDelete(Date delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "store{" +
				"id=" + id +
				", name='" + name + '\'' +
				", boos='" + boss + '\'' +
				", grade=" + grade +
				", info='" + info + '\'' +
				", license='" + license + '\'' +
				", status=" + status +
				", create=" + create +
				", update=" + update +
				", delete=" + delete +
				'}';
	}
}
