package groovy_dsl.classloader

class UserDO {
	def name
	def age
	def sex
	String getAllInfo(){
		return name+","+age+","+sex;
	}


	public UserDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDO(Object name, Object age, Object sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	
}
