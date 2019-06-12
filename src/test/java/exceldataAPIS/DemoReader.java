package exceldataAPIS;



public class DemoReader 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		String num = e.getCellData("login", 1, 1);
		System.out.println(num);
		
		
		String name = e.getCellData("login", "UserName", 3);
		System.out.println(name);
	}

}
