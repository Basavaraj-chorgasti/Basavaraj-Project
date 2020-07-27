package sendingbirthdaywish;

import java.util.List;

import birthdayWishNotification.Birthday;
import constant.Constant;
import detailformdatabase.DetailFromDatabase;
import sendemail.Sendemail;
import sendsms.Sendsms;

public class SendingBirthdayWish {
		
		public static void sendingmailandsms()
		{
			List<DetailFromDatabase> FetchData = Birthday.birthday();
			
			String Name;
			for(int i= 0;i<FetchData.size();i++)
			{
				DetailFromDatabase details = FetchData.get(i);
				Name = Constant.GREETING+details.getName().toUpperCase();
				// PRINTING  ON CONSOLE 
				System.out.println(Name);
				Sendemail.sendemail(details.getEmail(),Name);
				Sendsms.sendSms(Name, details.getNumber());
			}
		}

	}


