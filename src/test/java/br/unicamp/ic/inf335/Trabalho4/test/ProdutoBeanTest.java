package br.unicamp.ic.inf335.Trabalho4.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.unicamp.ic.inf335.Trabalho4.beans.ProdutoBean;

class ProdutoBeanTest {

	@Test
	void testGetMethods() {
		ProdutoBean nProd = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
		assertAll("nProd", 
				() -> assertEquals("CD00001",nProd.getCodigo()),
				() -> assertEquals("Celular Galaxy S10",nProd.getNome()),
				() -> assertEquals("128 Gb, Preto, com Carregador",nProd.getDescricao()),
				() -> assertEquals(1250.0,nProd.getValor()),
				() -> assertEquals("Poucos riscos, estado de novo.",nProd.getEstado())
		);
	}
	@Test
	void testCompare() {
		ProdutoBean nProd = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
		assertAll("nProd", 
				() -> assertEquals(1,nProd.compareTo(new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1000.0,"Bla Bla Bla"))),
				() -> assertEquals(-1,nProd.compareTo(new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1800.0,"Bla Bla Bla"))),
				() -> assertEquals(0,nProd.compareTo(new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1250.0,"Bla Bla Bla")))
		   );
	}
	
	

}
