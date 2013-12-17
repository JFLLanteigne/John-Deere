package serveur;

import java.io.File;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Vector;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Serveur
{
	private Vector<PrintWriter> tabClient = new Vector<PrintWriter>();
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

	synchronized public void delClient(int i)
	{
		nbClients--;
		if (tabClient.elementAt(i) != null)
		{
			tabClient.removeElementAt(i);
		}
	}

	synchronized public int addClient(PrintWriter out)
	{
		nbClients++;
		tabClient.addElement(out);
		return tabClient.size() - 1;
	}

	synchronized public int getNbClients()
	{
		return nbClients;
	}

	synchronized public void sendAll(String message, String sLast)
	{
		PrintWriter out;
		for (int i = 0; i < tabClient.size(); i++)
		{
			out = (PrintWriter) tabClient.elementAt(i);
			if (out != null)
			{
				out.print(message + sLast);
				out.flush();
			}
		}
	}

	synchronized public String rechercherLivre(String recherche, String type)
	{
		Serializer serializer = new Persister();
		File source = new File("/src/CATA_BIBLIO.XML");
		String reponse = "";
		try
		{
			Xml xml = serializer.read(Xml.class, source);

			switch (type)
			{
			case "auteur":
				if (xml.getAuteur() == recherche)
				{
					reponse = xml.getAuteur();
				}
				break;
			case "titre":
				if (xml.getTitre() == recherche)
				{
					reponse = xml.getTitre();
				}
				break;
			case "isbn":
				if (xml.getIsbn() == recherche)
				{
					reponse = xml.getIsbn();
				}
				break;
			case "editeur":
				if (xml.getEditeur() == recherche)
				{
					reponse = xml.getEditeur();
				}
				break;
			case "sujet":
				if (xml.getSujet() == recherche)
				{
					reponse = xml.getSujet();
				}
				break;
			case "type":
				if (xml.getType() == recherche)
				{
					reponse = xml.getType();
				}
				break;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return reponse;

	}
}
