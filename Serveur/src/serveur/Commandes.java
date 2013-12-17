package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Commandes implements Runnable
{
	Serveur monServeur;
	BufferedReader entrer;
	Thread processus;
	String maCommande = "";

	Commandes(Serveur monServeur)
	{
		this.monServeur = monServeur;
		this.entrer = new BufferedReader(new InputStreamReader(System.in));
		this.processus = new Thread(this);
	}

	@Override
	public void run()
	{
		try
		{
			while ((this.maCommande = this.entrer.readLine()) != null)
			{
				if (this.maCommande.equalsIgnoreCase("quit"))
					System.exit(0);
				else if (this.maCommande.equalsIgnoreCase("total"))
				{
					System.out.println("Nombre de connectes : " + this.monServeur.getNbClients());
					System.out.println("--------");
				}
				else
				{
					System.out.println("Cette commande n'est pas supportee");
					System.out.println("Quitter : \"quit\"");
					System.out.println("Nombre de connectes : \"total\"");
					System.out.println("--------");
				}
				System.out.flush();
			}
		}
		catch (IOException e)
		{
		}
	}

}
