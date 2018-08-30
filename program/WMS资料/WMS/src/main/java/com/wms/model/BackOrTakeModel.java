package com.wms.model;

//仓库退料与取料
public class BackOrTakeModel {

	private int id;
	private String goods_code;
	private String goods_name;
	private String goods_num;
	private String take_code;
	private String duty_code;
	private String supply_code;
	private String user_code;//用户code
	private String sum_money;//总金额
	private String single_money;
	private String goods_time;// 商品更新时间
	private String time;// 领料时间  与进货时间
	private String take_state;// 领料状态 0未领 1已领
	private String state;// 进出库状态 0入库 1出库

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(String goods_num) {
		this.goods_num = goods_num;
	}

	public String getTake_code() {
		return take_code;
	}

	public void setTake_code(String take_code) {
		this.take_code = take_code;
	}

	public String getDuty_code() {
		return duty_code;
	}

	public void setDuty_code(String duty_code) {
		this.duty_code = duty_code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTake_state() {
		return take_state;
	}

	public void setTake_state(String take_state) {
		this.take_state = take_state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getSingle_money() {
		return single_money;
	}

	public void setSingle_money(String single_money) {
		this.single_money = single_money;
	}

	public String getGoods_time() {
		return goods_time;
	}

	public void setGoods_time(String goods_time) {
		this.goods_time = goods_time;
	}

	public String getSupply_code() {
		return supply_code;
	}

	public void setSupply_code(String supply_code) {
		this.supply_code = supply_code;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getSum_money() {
		return sum_money;
	}

	public void setSum_money(String sum_money) {
		this.sum_money = sum_money;
	}

}
