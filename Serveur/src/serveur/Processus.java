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
	private int numClients = 0;

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
		String message = "";
		System.out.println("Un nouveau client s'est connecte, no " + this.numClients);
		try
		{
			char charCur[] = new char[1];
			while (this.entrer.read(charCur, 0, 1) != -1)
			{
				if (charCur[0] != '\u0000' && charCur[0] != '\n' && charCur[0] != '\r')
					message += charCur[0];
				else if (!message.equalsIgnoreCase(""))
				{
					if (charCur[0] == '\u0000')
						this.monServeur.sendAll(message, "" + charCur[0]);
					else
						this.monServeur.sendAll(message, "");
					message = "";
				}
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			try
			{
				System.out.println("Le client no " + this.numClients + " s'est deconnecte");
				this.monServeur.delClient(this.numClients);
				this.socket.close();
			}
			catch (IOException e)
			{
			}
		}
	}
}
