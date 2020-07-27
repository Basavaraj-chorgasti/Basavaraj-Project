package birthdayWishNotification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
 
import dbconnect.Dbconnect;
import detailformdatabase.DetailFromDatabase;



public class Birthday
{
	public static List<DetailFromDatabase> birthday() 
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
	
		ArrayList<DetailFromDatabase> Addstudent = new ArrayList<DetailFromDatabase>();  
		try 
		{
			connection=Dbconnect.DatabaseConnect();
			statement=connection.createStatement();
			resultset=statement.executeQuery("select * from student");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date();
		    String currentdate = formatter.format(date);
		    
			String databasedate;
			String[] currentmonthanddate = currentdate.split("-");
			while(resultset.next())
			{
				databasedate=resultset.getString(6);
				String[] databasemonthanddate = databasedate.split("-");
				
									
				if(databasemonthanddate[1].equals(currentmonthanddate[1]) && databasemonthanddate[2].equals(currentmonthanddate[2]))
				{
					DetailFromDatabase detailobject = new DetailFromDatabase();

					detailobject.setEmail(resultset.getString(4));
					detailobject.setNumber(resultset.getString(5));
					detailobject.setName(resultset.getString(2));
					detailobject.setBirthday(resultset.getString(6));
					
					Addstudent.add(detailobject);
										
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				resultset.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				statement.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				connection.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Addstudent;
	}
}
