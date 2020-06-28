package entire;

public class staff {
		private int staff_id;			/*员工号*/
		private String name;			/*姓名*/
		private String sex;  			/*性别*/
		private String bir;  			/*出生日期*/
		private String adr; 			/*家庭地址*/
		private String tel;				/*电话*/
		private String pos;				/*职位*/
		private String dep; 			/*所在部门*/
		private String wage;			/*薪资*/
		private String des;				/*简介*/
		/*员工号*/
		public int getStaff_id() {
			return staff_id;
		}
		public void setStaff_id(int staff_id) {//从文本获得数据时要将null转换为int型，即做判断，赋值为-1或者0
			this.staff_id=staff_id;
		}//
		/*姓名*/
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}//
		/*性别*/
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex=sex;
		}//
		/*出生日期*/
		public String getBir() {
			return bir;
		}
		public void setBir(String bir) {
			this.bir=bir;
		}//
		/*家庭地址*/
		public String getAdr() {
			return adr;
		}
		public void setAdr(String adr) {
			this.adr=adr;
		}//
		/*电话*/
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel= tel;
		}//
		/*职位*/
		public String getPos() {
			return pos;
		}
		public void setPos(String pos) {
			this.pos=pos;
		}//
		/*所在部门*/
		public String getDep() {
			return dep;
		}
		public void setDep(String dep) {
			this.dep=dep;
		}//
		/*薪资*/
		public String getWage() {
			return wage;
		}
		public void setWage(String wage) {
			this.wage=wage;
		}//
		/*简介*/
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des=des;
		}//
}
