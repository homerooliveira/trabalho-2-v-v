import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SensorTest {

	private Sensor sensor;

	@Before
	public void setUp() {
		sensor = new Sensor();
	}

	@Test
	public void testSequence1() {
		sensor.setAlerta();
		boolean alerta = sensor.setAlerta();
		Assert.assertEquals(false, alerta);
	}

	@Test
	public void testSequence2() {
		boolean alerta = sensor.setAlerta();
		
		boolean habilitado = sensor.setH();
		Assert.assertEquals(false, alerta);
		Assert.assertEquals(true, habilitado);
	}
		
	@Test
	public void testSequence7() {
		sensor.setH();
		sensor.setH();
		boolean alerta = sensor.setAlerta();
		Assert.assertEquals(true, alerta);
	}
	
	@Test
	public void testSequence11() {
		sensor.setH();
		sensor.setAlerta();
		sensor.resetAlerta();
		boolean alerta = sensor.setAlerta();
		Assert.assertEquals(true, alerta);
	}
	
}
