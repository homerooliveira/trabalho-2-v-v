public class Sensor {
	private boolean habilitado;
	private boolean alerta;

	public Sensor() {
		habilitado = false;
		alerta = false;
	}

/**
 * 	 bool setH() – habilita o sensor. Se o sensor já está habilitado, não altera nada e
 * 	 retorna false, caso contrário retorna true.
 */
	public boolean setH() {
		if (!habilitado) {
			habilitado = true;
			return true;
		}
		return false;
	}

//	bool resetH() – desabilita o sensor. Se o sensor já está desabilitado, não altera
//	nada e retorna false
	public boolean getH() {
		return habilitado;
	}
	
//	bool getH() – retorna true se o sensor está habilitado e false caso contrário.
	public boolean resetH() {
		if (habilitado && !alerta) {
			habilitado = false;
			return true;
		}
		return false;
	}

//	bool setAlerta() - se o sensor está habilitado, passa o sensor para o estado de
//	alerta, notifica o controlador e retorna true. Se o sensor já está em alerta ou está
//	desabilitado, não altera nada  e retorna false.
	public boolean setAlerta() {
		if (!alerta && habilitado) {
			alerta = true;
			return true;
		}
		return false;
	}

//	bool resetAlerta() - se o sensor está alerta, passa o sensor para o estado
//	habilitado, notifica o controlador e retorna true. Se o sensor não está em alerta,
//	não altera nada e retorna false
	public boolean resetAlerta() {
		if (alerta) {
			alerta = false;
			return true;
		}
		return false;
	}

	//  bool getAlerta() – retorna true se o sensor está alerta e false caso
	// contrário.
	public boolean getAlerta() {
		return alerta;
	}

}
