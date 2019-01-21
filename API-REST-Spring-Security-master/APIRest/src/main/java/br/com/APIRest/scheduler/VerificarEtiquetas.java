package br.com.APIRest.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class VerificarEtiquetas {
	
	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long HORA = MINUTO * 60;
	
	@Scheduled(fixedDelay = SEGUNDO * 5)
	public void testar() {
		System.out.println("Verificando etiquetas . . .");
	}
	
}

