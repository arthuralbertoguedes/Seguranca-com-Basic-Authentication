package br.com.APIRest.security;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

public class VerificarConexao {

	public static boolean verifica(HttpServletRequest request) {
		if(request.getHeader("Basic")==null)
			return false;
		
		String infosCodificadas = request.getHeader("Basic");
		
		byte[] decodedBytes = Base64.getDecoder().decode(infosCodificadas);
		String infoDecodificadas = new String(decodedBytes);
		String[] infosUsuarios = infoDecodificadas.split(":");
		
		if(infosUsuarios[0].equals("arthuralbertoguedes") && infosUsuarios[1].equals("ara@123555J")) {
			return true;
		}
		else
			return false;
	}
	
}
