package com.crxl.qpp.comicdis.basics.entity.data;

public class DistributorWithdrawalsData {

	private String id = "";
	private String distridutionId = ""; //分销商id
	private String todayRecharge="";//订单金额
	private String orderSum = ""; //订单数量
	private String withdrawalsMoney= "";//提现金额
	private String proportion ="";//  分成比例
	private String withdrawalsState = ""; //提现状态  1已到账 0 待打款
	private String impldate = ""; //操作时间
	private String withdrawalsDate="";//提现时间
	private String remarks = ""; //备注
	private String nowPage ="";     //当前页
	private String pageNum ="";        //每页容量
	private String condition = "";           //查询条件
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDistridutionId() {
		return distridutionId;
	}
	public void setDistridutionId(String distridutionId) {
		this.distridutionId = distridutionId;
	}
	public String getTodayRecharge() {
		return todayRecharge;
	}
	public void setTodayRecharge(String todayRecharge) {
		this.todayRecharge = todayRecharge;
	}
	public String getOrderSum() {
		return orderSum;
	}
	public void setOrderSum(String orderSum) {
		this.orderSum = orderSum;
	}
	public String getWithdrawalsMoney() {
		return withdrawalsMoney;
	}
	public void setWithdrawalsMoney(String withdrawalsMoney) {
		this.withdrawalsMoney = withdrawalsMoney;
	}
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public String getWithdrawalsState() {
		return withdrawalsState;
	}
	public void setWithdrawalsState(String withdrawalsState) {
		this.withdrawalsState = withdrawalsState;
	}
	public String getImpldate() {
		return impldate;
	}
	public void setImpldate(String impldate) {
		this.impldate = impldate;
	}
	public String getWithdrawalsDate() {
		return withdrawalsDate;
	}
	public void setWithdrawalsDate(String withdrawalsDate) {
		this.withdrawalsDate = withdrawalsDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
}
