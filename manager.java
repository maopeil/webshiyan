package entire;

public class manager {
	public int id;					/*序号*/
	public int staff_id;			/*员工号*/
	public String name;				/*姓名*/
	public String passwd;			/*密码*/
	public String power;			/*管理权限("user"or"manager")*/
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
	/*密码*/
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd=passwd;
	}
	/*管理权限("user"or"manager")*/
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power=power;
	}
}
