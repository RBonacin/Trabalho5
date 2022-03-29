package br.unicamp.ic.inf335.Trabalho4.test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.Trabalho4.beans.AnuncianteBean;
import br.unicamp.ic.inf335.Trabalho4.beans.AnuncioBean;
import br.unicamp.ic.inf335.Trabalho4.beans.ProdutoBean;

class AnuncianteBeanTest {

	@Test
	void testGetMethods() throws MalformedURLException {
		ArrayList<URL> fotosUrl = new ArrayList<URL>();
		URL url = new URL("https://www.unicamp.br/unicamp/");
		fotosUrl.add(url);
		ProdutoBean nProd = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
		AnuncioBean anuncioBean = new AnuncioBean(nProd,fotosUrl,0.0);
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		anuncios.add(anuncioBean);
		AnuncianteBean anunciante = new AnuncianteBean("Rodrigo","111.111.111-11",anuncios);
		
		assertAll("anunciante", 
				() -> assertEquals("Rodrigo",anunciante.getNome()),
				() -> assertEquals("111.111.111-11",anunciante.getCPF()),
				() -> assertEquals(anuncios,anunciante.getAnuncios())
		);
	}

	
	@Test
	void testValorMedioVazio() throws MalformedURLException {
		ArrayList<URL> fotosUrl = new ArrayList<URL>();
		URL url = new URL("https://www.unicamp.br/unicamp/");
		fotosUrl.add(url);
		ProdutoBean nProd = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		
		// testa array vazio
		AnuncianteBean anunciante = new AnuncianteBean("Rodrigo","111.111.111-11",anuncios);
		
		assertEquals(0.0,anunciante.valorMedioAnuncios());
		
	}
	
	@Test
	void testValorMedio() throws MalformedURLException {
		ArrayList<URL> fotosUrl = new ArrayList<URL>();
		URL url = new URL("https://www.unicamp.br/unicamp/");
		fotosUrl.add(url);
		ProdutoBean nProd = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1000.0,"Poucos riscos, estado de novo.");
		AnuncioBean anuncioBean = new AnuncioBean(nProd,fotosUrl,0.0);
		ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
		anuncios.add(anuncioBean);
		
		nProd = new ProdutoBean("CD00002","Celular Galaxy S21", "128 Gb, Preto, com Carregador",4000.0,"Poucos riscos, estado de novo.");
		anuncioBean = new AnuncioBean(nProd,fotosUrl,0.0);
		anuncios.add(anuncioBean);
		
		AnuncianteBean anunciante = new AnuncianteBean("Rodrigo","111.111.111-11",anuncios);
		
		assertEquals(2500.0,anunciante.valorMedioAnuncios());
		
	}
}
