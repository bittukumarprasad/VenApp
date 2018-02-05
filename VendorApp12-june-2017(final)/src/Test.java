import org.codehaus.jackson.map.ObjectMapper;

import com.app.Employee;


public class Test {
	public static void main(String[] args) {
	
		String s="{\"empId\":55,\"empName\":\"AA\",\"empSal\":55}";
		try {
			ObjectMapper om=new ObjectMapper();
			Object ob=om.readValue(s, Employee.class);
			Employee e=(Employee)ob;
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println(e.getEmpSal());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
