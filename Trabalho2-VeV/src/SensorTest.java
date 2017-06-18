import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SensorTest {

	private Sensor sensor;

	@Before
	public void setUp() {
		sensor = new Sensor();
	}

	@Test
	public void testSequence1() {
		// Não muda de estado e começa como Desabilitado
		boolean resetAlerta = sensor.resetAlerta();
		assertEquals(false, resetAlerta);

		// Desabilitado -> Habilitado
		boolean setH = sensor.setH();
		assertEquals(true, setH);
	}

	@Test
	public void testSequence4() {
		// Desabilitado -> Habilitado
		boolean setH = sensor.setH();
		assertEquals(true, setH);

		// Habilitado -> Desabilitado
		boolean resetH = sensor.resetH();
		assertEquals(true, resetH);

		//Desabilitado -> Habilitado
		setH = sensor.setH();
		assertEquals(true, setH);
	}

	@Test
	public void testSequence7() {
		// Desabilitado -> Habilitado
		boolean setH = sensor.setH();
		assertEquals(true, setH);

		// Não muda de estado
		setH = sensor.setH();
		assertEquals(false, setH);

		// Não muda de estado
		setH = sensor.setH();
		assertEquals(false, setH);
	}

	@Test
	public void testSequence13(){
		// Desabilitado -> Habilitado
		boolean setH = sensor.setH();
		assertEquals(true, setH);

		//Habilitado -> Alerta
		boolean alerta = sensor.setAlerta();
		assertEquals(true, alerta);

		// Não muda de estado
		setH = sensor.setH();
		assertEquals(false, setH);

		// Não muda de estado
		setH = sensor.setH();
		assertEquals(false, setH);
	}

	@Test
	public void testSequence16(){
		// Desabilitado -> Habilitado
		boolean setH = sensor.setH();
		assertEquals(true, setH);

		//Habilitado -> Alerta
		boolean alerta = sensor.setAlerta();
		assertEquals(true, alerta);

		// Não muda de estado
		setH = sensor.resetH();
		assertEquals(false, setH);

		// Não muda de estado
		setH = sensor.resetH();
		assertEquals(false, setH);
	}
}
