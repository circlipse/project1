package reserve.service;

public class ReserveService {
	private static ReserveService rsService=new ReserveService();
	public static ReserveService getReserveService()
	{
		return rsService;
	}
	private ReserveService() {}
	
}
