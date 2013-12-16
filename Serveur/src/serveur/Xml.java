package serveur;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root
public class Xml
{

	@Path("Biblio[1]")
	@Element
	private String Auteur;

	@Path("Biblio[1]")
	@Element
	private String Titre;

	@Path("Biblio[1]")
	@Element
	private String Isbn;

	@Path("Biblio[1]")
	@Element
	private String Editeur;

	@Path("Biblio[1]")
	@Element
	private String Description;

	@Path("Biblio[1]")
	@Element
	private String Sujet;

	@Path("Biblio[1]")
	@Element
	private String Type;

	public String getAuteur()
	{
		return Auteur;
	}

	public String getTitre()
	{
		return Titre;
	}

	public String getIsbn()
	{
		return Isbn;
	}

	public String getEditeur()
	{
		return Editeur;
	}

	public String getSujet()
	{
		return Sujet;
	}

	public String getType()
	{
		return Type;
	}
}