package com.restaurant.model;

public class Menu {

	private Integer id;
	
	private String itemName;
	private Integer cost;
	private String description;

	public Menu() {
	}
	public Menu(String itemName, Integer cost, String description) {
		super();
		this.itemName = itemName;
		this.cost = cost;
		this.description = description;
	}
	
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the cost
	 */
	public Integer getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
