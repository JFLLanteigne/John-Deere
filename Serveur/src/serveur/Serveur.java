package serveur;

import java.net.ServerSocket;
import java.util.Vector;

public class Serveur
{
	private Vector tabClient = new Vector();
	private int nbClients = 0;

	public static void main(String args[])
	{
		Serveur monServeur = new Serveur();

		try
		{
			Integer port;

			if (args.length <= 0)
			{
				port = new Integer(50027);
			}
			else
			{
				port = new Integer(args[0]);
			}

			new Commandes(monServeur);

			ServerSocket socket = new ServerSocket(port.intValue());

			while (true)
			{
				new Processus(socket.accept(), monServeur);
			}
		}
		catch (Exception e)
		{
		}
	}
}
