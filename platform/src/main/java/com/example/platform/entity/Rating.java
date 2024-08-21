package com.example.platform.entity;

import com.example.platform.utils.DateDemo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tl_rating")
@Entity
/**
 * 评价
 * @author Lenovo
 * @version 1.0
 * @created 25-4月-2023 16:42:02
 */
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rid")
	private int ID;
	@Column(name="orderID")
	private int OrderID;
	@Column(name="time")
	private String DateTime;
	@Column(name="starNum")
	private int StarNum;
	@Column(name="content")
	private String Content;
	@Column(name="likedNum")
	private int LikedNum;
	@Column(name="layer")
	private int Layer = 0;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}

	public int getStarNum() {
		return StarNum;
	}

	public void setStarNum(int starNum) {
		StarNum = starNum;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public int getLikedNum() {
		return LikedNum;
	}

	public void setLikedNum(int likedNum) {
		LikedNum = likedNum;
	}

	public int getLayer() {
		return Layer;
	}

	public void setLayer(int layer) {
		Layer = layer;
	}

	public Rating(){

	}

	public void finalize() throws Throwable {

	}

}