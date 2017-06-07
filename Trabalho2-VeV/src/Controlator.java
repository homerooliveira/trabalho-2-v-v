
public class Controlator {
	
	private Sensor[] sensores;
	private boolean[] valvulas;

	public Controlator() {
		int capacidade = 2;
		sensores = new Sensor[capacidade];
		valvulas = new boolean[capacidade];
		
		for(int i = 0; i < sensores.length; i++){
			sensores[i] = new Sensor();
		}
		
	}
	
//	 bool setH(n) – habilita o sensor “n” (1- temperatura; 2- pressão) e retorna true.
//	Se o sensor já está habilitado, não altera nada e retorna false.
	public boolean setH(int n){
		if(n < 0 && n > sensores.length - 1){
			return false;
		}
		return sensores[n-1].setH();
	}	
//	 bool resetH(n) – desabilita o sensor “n” e retorna true. Se o sensor já está
//	desabilitado, não altera nada e retorna false.
	public boolean resetH(int n){
		if(n < 0 && n > sensores.length - 1){
			return false;
		}
		return sensores[n-1].resetH();
	}
	
//	 void alerta(n) - usado pelo sensor para avisar o controlador de que está em
//	alerta. O controlador deve abrir a válvula correspondente.
	public void alerta(int n){
		if(n >= 0 && n < sensores.length){
			sensores[n-1].setAlerta();
		}
	}
//	 void resetAlerta() - usado pelo sensor para avisar que não está mais em alerta. O
//	controlador deve fechar a válvula correspondente.
	public void resetAlerta(int n){
		if(n >= 0 && n < sensores.length){
			sensores[n-1].resetAlerta();
		}
	}
//	 void open(n) – abre a válvula “n”.
	public void open(int n){
		if(n >= 0 && n < valvulas.length){
			valvulas[n-1] = true;
		}
	}
	
//	 void fecha(n) – fecha a válvula “n”.
	public void fecha(int n){
		if(n >= 0 && n < valvulas.length){
			valvulas[n-1] = false;
		}
	}
	
//	 bool getV(n) – retorna o status da válvula “n” – true se está aberta e false caso
//	esteja fechada.
	public boolean getV(int n){
		if(n < 0 && n > sensores.length - 1){
			return false;
		}
		return valvulas[n-1];
	}
}
