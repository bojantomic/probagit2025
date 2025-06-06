package biblioteka.interfejs;

import java.util.ArrayList;
import java.util.List;

import biblioteka.Autor;
import biblioteka.Knjiga;

public class Biblioteka implements BibliotekaInterface {
	
	//Ovo je implementirano kao ArrayList zbog cestog dodavanja i pretrage
	private List<Knjiga> knjige = new ArrayList<Knjiga>();

	@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (knjige.contains(knjiga))
			throw new IllegalArgumentException("Ta knjiga vec postoji u biblioteci");
		
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if (knjiga == null)
			throw new NullPointerException("Knjiga ne sme biti null");
		
		if (!knjige.contains(knjiga))
			throw new IllegalArgumentException("Ta knjiga ne postoji u biblioteci");
		
		knjige.remove(knjiga);
	}

	@Override
	public List<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	@Override
	public List<Knjiga> pronadjiKnjigu(Autor autor, long isbn, String naslov, String izdavac) {
		if (autor == null && isbn <= 0 && naslov == null && izdavac == null)
			throw new IllegalArgumentException("Morate uneti bar neki kriterijum za pretragu");
		
		List<Knjiga> rezultati = new ArrayList<Knjiga>();
		
		if (naslov != null)
			for(Knjiga k: knjige)
				if (k.getNaslov().toUpperCase().contains(naslov.toUpperCase()))
					rezultati.add(k);
		
		if (autor != null)
			for(Knjiga k: knjige)
				if (k.getAutori().contains(autor))
					rezultati.add(k);
		
		return rezultati;
	}

}
