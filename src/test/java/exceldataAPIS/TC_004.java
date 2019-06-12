package exceldataAPIS;

public class TC_004 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		System.out.println(e.getCellData("login", 0, 1));
		
		System.out.println(e.getCellData("login", "UserName", 2));
		
		System.out.println(e.getRowCount("login"));
		
		System.out.println(e.columnCount("login"));
		
		e.setCellData("login", 4, 1, "PASSED");
	}

}
