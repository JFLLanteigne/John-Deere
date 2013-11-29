package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Processus implements Runnable
{
	private Thread processus;
	private Socket socket;
	private Serveur monServeur;
	private PrintWriter sortie;
	private BufferedReader entrer;
	private int nbClients = 0;

	Processus(Socket socket, Serveur monServeur)
	{
		this.monServeur = monServeur;
		this.socket = socket;

		try
		{
			this.sortie = new PrintWriter(this.socket.getOutputStream());
			this.entrer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		}
		catch (IOException e)
		{
		}
		this.processus = new Thread(this);
		this.processus.start();
	}

	@Override
	public void run()
	{

	}
}
