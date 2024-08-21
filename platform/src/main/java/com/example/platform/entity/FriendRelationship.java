package com.example.platform.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * @author Lenovo
 * @version 1.0
 * @created 25-4月-2023 16:44:44
 */
@Table(name = "tl_friend")
@Entity
public class FriendRelationship {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fid")
	private int ID;
	@Column(name="fromID")
	private int Player1ID;
	@Column(name="toID")
	private int Player2ID;
	@Column(name="time")
	private Date DateTime;
	@Column(name="stateID")
	public int state;//0已申请，1成为好友，2删除好友//2先不要了吧
	//public Player m_Player;

	public FriendRelationship(){

	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getPlayer1ID() {
		return Player1ID;
	}

	public void setPlayer1ID(int player1ID) {
		Player1ID = player1ID;
	}

	public int getPlayer2ID() {
		return Player2ID;
	}

	public void setPlayer2ID(int player2ID) {
		Player2ID = player2ID;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void finalize() throws Throwable {

	}

}