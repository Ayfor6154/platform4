package com.example.platform.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * @author Lenovo
 * @version 1.0
 * @created 25-4月-2023 16:37:10
 */

@Table(name = "tl_order")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid")
	private int ID;
	@Column(name="userID")
	private int UserID;
	@Column(name="gameID")
	private int GameID;
	@Column(name="time")
	private Date DateTime;
	@Column(name="stateID")
	private int StateID;
	@Column(name="amount")
	private float Amount;
	//public Rating m_Rating;
	//public OrderStatus m_OrderStatus;
	//public Player m_Player;
	//public Game m_Game;

	public Order(){

	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getGameID() {
		return GameID;
	}

	public void setGameID(int gameID) {
		GameID = gameID;
	}

	public Date getDateTime() {
		return DateTime;
	}

	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}

	public int getStateID() {
		return StateID;
	}

	public void setStateID(int stateID) {
		StateID = stateID;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param order
	 */
	public int createOrder(Order order){
		return 0;
	}

	/**
	 * 
	 * @param id
	 */
	public int deleteOrder(int id){
		return 0;
	}

	/**
	 * 
	 * @param order
	 */
	public int updateOrder(Order order){
		return 0;
	}

}