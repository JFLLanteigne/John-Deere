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

	public void setAuteur(String auteur)
	{
		this.Auteur = auteur;
	}

	public String getTitre()
	{
		return Titre;
	}

	public void setTitre(String titre)
	{
		this.Titre = titre;
	}

	public String getIsbn()
	{
		return Isbn;
	}

	public void setIsbn(String isbn)
	{
		this.Isbn = isbn;
	}

	public String getEditeur()
	{
		return Editeur;
	}

	public void setEditeur(String editeur)
	{
		Editeur = editeur;
	}

	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public String getSujet()
	{
		return Sujet;
	}

	public void setSujet(String sujet)
	{
		Sujet = sujet;
	}

	public String getType()
	{
		return Type;
	}

	public void setType(String type)
	{
		Type = type;
	}
}