package de.digiclothes.server;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import de.digiclothes.server.ifc.ConnectorDescription;
import de.digiclothes.server.object.DC_Shop;
import de.digiclothes.server.socketimpl.DC_ClientHandler;
import de.madana.common.datastructures.DC_ShoppingCart;
/**
 * 
 * @author Jean
 *
 */
public class DC_ServerSessionManager implements Runnable
{
	static List<DC_ClientHandler> s_oSessions = new ArrayList<DC_ClientHandler>();

	/**
	 * Neu hergestellte Session wird in die Verwaltung aufgenommen
	 * @param oHandler - Die zu verwaltende Session
	 * @author Jean
	 */
	public static void registerSession(DC_ClientHandler oHandler)
	{
		s_oSessions.add(oHandler);
	}
	/**
	 * Entfernt die Übergebene Session aus der Verwaltung
	 * @param oHandler - die nicht mehr zu verwaltende Session
	 * @author Jean
	 */
	public static void deregisterSession(DC_ClientHandler oHandler)
	{
		for(int i=0; i < s_oSessions.size();i++)
		{
			if(s_oSessions.get(i).toString().equals(oHandler.toString()))
			{
				s_oSessions.remove(i);
				return;
			}
		}

	}
	/**
	 * Gibt alle derzeit angemeldeten Shops zurück
	 * @return List bestehenden aus {@link DC_Shop}
	 * @author Jean
	 */
	public static List <DC_Shop> getConnectedShops()
	{
		List<DC_Shop> oShops = new ArrayList<DC_Shop>();
		for(int i=0; i < s_oSessions.size(); i++)
		{
			if(s_oSessions.get(i).getShop()!=null)
				oShops.add(s_oSessions.get(i).getShop());
		}
		return oShops;
	}
	@Override
	public void run() 
	{
		while (true)
		{
			List <DC_Shop> oConnectedShops =getConnectedShops();
			System.out.println("SESSIONMANAGER:" +oConnectedShops.toString());
			for(int i=0; i < oConnectedShops.size(); i++)
			{
				List <ConnectorDescription> oInterfaces =oConnectedShops.get(i).getInterfaces();
				for (int j=0; j <oInterfaces.size(); j++)
				{
					DC_ShoppingCart oShoppingCart;
					try {
						oShoppingCart = oConnectedShops.get(i).getSession().getShoppingCart(oInterfaces.get(j).getId());
						if(oShoppingCart!=null)
						{
							System.out.println("SESSIONMANAGER:"+oConnectedShops.get(i).getName() +" - " +oInterfaces.get(j).getLocationDescription()+" - "  +oShoppingCart.getItems().size()+ " Produkte für insgesamt "+oShoppingCart.getAmount());
						}
						else
						{
							System.out.println("SESSIONMANAGER:"+oConnectedShops.get(i).getName() +" - " +oInterfaces.get(j).getLocationDescription()+" - Keine ShoppingCart initialisiert");
							
						}
						
					} catch (Exception e)
					{
						if (e instanceof SocketException)
						{
							deregisterSession(oConnectedShops.get(i).getSession());
						}
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
