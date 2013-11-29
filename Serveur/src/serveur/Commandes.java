package serveur;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Commandes implements Runnable
{
	Serveur monServeur;
	BufferedReader entrer;
	Thread processus;

	Commandes(Serveur monServeur)
	{
		this.monServeur = monServeur;
		this.entrer = new BufferedReader(new InputStreamReader(System.in));
		this.processus = new Thread(this);
	}

	@Override
	public void run()
	{

	}
}
