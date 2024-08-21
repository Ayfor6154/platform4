package com.example.platform.entity;

import javax.persistence.*;
//import com.baomidou.mybatisplus.annotation.*;
/**
 * 用户类
 * @version 1.0
 * @created 25-4月-2023 16:16:29
 */
//@TableName("tl_user")
@Table(name = "tl_user")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@TableField(value="uid")
	@Column(name="uid")
	private Integer ID;
	//@TableField(value="username")
	@Column(name="username")
	private String name;
	private String password;/*
	private String Info;
	private image Image;*/
	@Column(name="role")
	private int roleID;//0是玩家，1是厂商，2是审核员
	@Column(name="state")
	private int stateID;//0：正常，1：封号(封号不能发表评论和发言)

	//玩家和厂商可以自己注册
	//审核员由1号审核员注册
	public User(){

	}



	/**
	 *一大批getter and setter
	 * */
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String uname) {
		name = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String tpassword) {
		password = tpassword;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int stateID) {
		this.stateID = stateID;
	}

	/*
            public String getInfo() {
                return Info;
            }

            public void setInfo(String info) {
                Info = info;
            }
        */
	public void finalize() throws Throwable {

	}


	@Override
	public String toString() {
		//String uID = ID.toString();
		return "{" +
				"ID:" + ID +
				", name:'" + name + '\'' +
				", password:'" + password + '\'' +
				", role:" + roleID +
				'}';
	}/*
	@Override
	public String toString() {
		return "{" +
				"\"ID\":" + ID +
				", \"name\":\"" + name + '\'' +
				", \"password\":\"" + password + '\'' +
				", \"role\":" + roleID +
				'}';
	}*/
}