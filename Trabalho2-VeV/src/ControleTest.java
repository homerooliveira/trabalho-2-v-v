import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControleTest {

	private Controle controle;

	@Before
	public void setUp() {
		controle = new Controle();
	}

	//Test Sequence 4 :	[resetAlerta(1), resetH(2)]
	@Test
	public void TestSequence4(){
		// Não muda de estado fica como Desabilitado
		controle.resetAlerta(1);

		// Não muda de estado
		boolean resetH = controle.resetH(2);
		assertEquals(false, resetH);
	}

	//Test Sequence 6 :	*[resetH(1), resetH(2)]
	@Test
	public void TestSequence6(){
		// Não muda de estado fica como Desabilitado
		boolean resetH1 = controle.resetH(1);
		assertEquals(false, resetH1);

		// Não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);
	}

    //	Test Sequence 10 :	*[alerta(1), resetH(2)]
	@Test
	public void TestSequence10(){
		// Não muda de estado fica como Desabilitado
		controle.alerta(1);

		// Não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);
	}

    //	Test Sequence 16 :	*[setH(1), resetAlerta(1), setH(1)]
	@Test
	public void TestSequence16(){
		// Desabilitado -> TemperaturaHab
		boolean setH = controle.setH(1);
		assertEquals(true, setH);

		// Não muda de estado
		controle.resetAlerta(1);

		// Não muda de estado
		setH = controle.setH(1);
		assertEquals(false, setH);
	}

	//Test Sequence 20 :	*[setH(1), resetAlerta(2), resetH(2)]
	@Test
	public void TestSequence20(){
		// Desabilitado -> TemperaturaHab
		boolean setH = controle.setH(1);
		assertEquals(true, setH);

		// Não muda de estado
		controle.resetAlerta(2);

		// Não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);
	}

	//Test Sequence 23 :	*[setH(1), alerta(1), resetH(2)]
	@Test
	public void TestSequence23(){
		// Desabilitado -> TemperaturaHab
		boolean setH = controle.setH(1);
		assertEquals(true, setH);

		// Não muda de estado
		controle.alerta(1);

		// Não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);
	}

	//Test Sequence 28 :	*[setH(1), resetH(1), setH(1)]
	@Test
	public void TestSequence28(){
		// Desabilitado -> TemperaturaHab
		boolean setH = controle.setH(1);
		assertEquals(true, setH);

		// TemperaturaHab -> Desabilitado
		boolean resetH1 = controle.resetH(1);
		assertEquals(true, resetH1);

		// Desabilitado -> TemperaturaHab
		setH = controle.setH(1);
		assertEquals(true, setH);
	}

	//Test Sequence 40 :	*[setH(2), resetH(2), setH(1)]
	@Test
	public void TestSequence40(){
		// Desabilitado -> PressãoHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// PressãoHab -> Desabilitado
		boolean resetH2 = controle.resetH(2);
		assertEquals(true, resetH2);

		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);
	}

	//Test Sequence 42 :	*[setH(2), resetAlerta(2), resetH(2)]
	@Test
	public void TestSequence42(){
		// Desabilitado -> PressãoHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// Não muda de estado
		controle.resetAlerta(2);

		// PressãoHab -> Desabilitado
		boolean resetH2 = controle.resetH(2);
		assertEquals(true, resetH2);
	}

	//Test Sequence 47 :	*[setH(2), setH(2), setH(1)]
	@Test
	public void TestSequence47(){
		// Desabilitado -> PressãoHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// Não muda de estado
		setH2 = controle.setH(2);
		assertEquals(false, setH2);

		// PressãoHab -> TotalHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);
	}

	//Test Sequence 58 :	*[setH(1), setH(2), resetAlerta(2), resetH(1)]
	@Test
	public void TestSequence58(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// Não muda de estado
		controle.resetAlerta(2);

		// TotalHab -> PresãoHab
		boolean resetH1 = controle.resetH(1);
		assertEquals(true, resetH1);
	}

	//Test Sequence 68 :	*[setH(1), setH(2), alerta(1), resetH(2), setH(2)]
	@Test
	public void TestSequence68(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);

		// não muda de estado
		setH2 = controle.setH(2);
		assertEquals(false, setH2);
	}

	//Test Sequence 71 :	*[setH(1), setH(2), alerta(1), resetH(1), setH(1)]
	@Test
	public void TestSequence71(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		boolean resetH1 = controle.resetH(1);
		assertEquals(false, resetH1);

		// não muda de estado
		setH1 = controle.setH(1);
		assertEquals(false, setH1);
	}

	//Test Sequence 73 :	*[setH(1), setH(2), alerta(1), resetH(1), resetH(2)]
	@Test
	public void TestSequence73(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		boolean resetH1 = controle.resetH(1);
		assertEquals(false, resetH1);

		// não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);
	}

	//Test Sequence 80 :	*[setH(1), setH(2), alerta(1), alerta(1), setH(2)]
	@Test
	public void TestSequence80(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		controle.alerta(1);

		// não muda de estado
		setH2 = controle.setH(2);
		assertEquals(false, setH2);
	}

	//Test Sequence 91 :	*[setH(1), setH(2), alerta(1), setH(1), setH(2)]
	@Test
	public void TestSequence91(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		setH1 = controle.setH(1);
		assertEquals(false, setH1);

		// não muda de estado
		setH2 = controle.setH(2);
		assertEquals(false, setH2);
	}

	//Test Sequence 95 :	*[setH(1), setH(2), alerta(2), alerta(1), setH(2)]
	@Test
	public void TestSequence95(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// não muda de estado
		setH2 = controle.setH(2);
		assertEquals(false, setH2);
	}

	//Test Sequence 100 :	*[setH(1), setH(2), alerta(2), resetAlerta(2), setH(1)]
	@Test
	public void TestSequence100(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaPre
		controle.alerta(2);

		//AlertaPre -> TotalHab
		controle.resetAlerta(2);

		// não muda de estado
		setH1 = controle.setH(1);
		assertEquals(false, setH1);
	}

	//Test Sequence 110 :	*[setH(1), setH(2), alerta(2), resetH(1), resetH(1)]
	@Test
	public void TestSequence110(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaPre
		controle.alerta(2);

		// não muda de estado
		boolean resetH1 = controle.resetH(1);
		assertEquals(false, resetH1);

		// não muda de estado
		resetH1 = controle.resetH(1);
		assertEquals(false, resetH1);
	}

	//Test Sequence 156 :	*[setH(1), setH(2), alerta(1), alerta(2), setH(1), resetH(2)]
	@Test
	public void TestSequence156(){
		// Desabilitado -> TemperaturaHab
		boolean setH1 = controle.setH(1);
		assertEquals(true, setH1);

		// PressãoHab -> TotalHab
		boolean setH2 = controle.setH(2);
		assertEquals(true, setH2);

		// TotalHab -> AlertaTemp
		controle.alerta(1);

		// AlertaTemp -> AlertaTotal
		controle.alerta(2);

		// não muda de estado
		setH1 = controle.setH(1);
		assertEquals(false, setH1);

		// não muda de estado
		boolean resetH2 = controle.resetH(2);
		assertEquals(false, resetH2);

	}

}
