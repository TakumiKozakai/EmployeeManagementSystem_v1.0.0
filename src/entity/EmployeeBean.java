package entity;

/**
 * @author Kozakaitakumi
 *
 */
public class EmployeeBean {
	private String id;
	private String name;
	private String section;
	private String phone;
	private String password;

	/**
	 * コンストラクタ
	 */
	public EmployeeBean() {
	}

	/**
	 * コンストラクタ
	 * @param id
	 * @param name
	 * @param section
	 * @param phone
	 */
	public EmployeeBean(String id, String name, String section, String phone, String password) {
		this.id = id;
		this.name = name;
		this.section = section;
		this.phone = phone;
	}

	/**
	 * 従業員データの表示
	 */
	public void print() {
		System.out.print(id + ",");
		System.out.print(name + ",");
		System.out.print(section + ",");
		System.out.print(phone);
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section セットする section
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone セットする phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
