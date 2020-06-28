package entire;

public class pay {
	public int id;							/*序号*/
	public int staff_id;					/*员工号*/
	public String name;						/* 姓名*/
	public String ym; 						/*年月*/
	public int basic; 						/*基本工资*/
	public int reward; 						/*奖金*/
	public int punish; 						/*扣罚金额*/
	public int total; 						/*实发金额*/
	/*序号*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}//
	/*员工号*/
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id=staff_id;
	}//
	/*姓名*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}//
	/*年月*/
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym=ym;
	}//
	/*基本工资*/
	public int getBasic() {
		return basic;
	}
	public void setBasic(int basic) {
		this.basic=basic;
	}//
	/*奖金*/
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward=reward;
	}//
	/*扣罚金额*/
	public int getPunish() {
		return punish;
	}
	public void setPunish(int punish) {
		this.punish=punish;
	}//
	/*实发金额*/
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total=basic+reward+punish;
	}//
}
