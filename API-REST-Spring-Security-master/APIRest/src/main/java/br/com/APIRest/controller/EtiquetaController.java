package br.com.APIRest.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.APIRest.model.Etiqueta;
import br.com.APIRest.security.VerificarConexao;
import br.com.APIRest.service.EtiquetaService;

@RestController
@RequestMapping(value = "/etiqueta")
public class EtiquetaController {
	
	@Autowired
	EtiquetaService etiquetaService;

	
	//Cadastrar nova etiqueta
	@RequestMapping(value = "/nova-etiqueta", method = RequestMethod.POST)
	public Etiqueta cadastrarEtiqueta(@RequestBody Etiqueta etiqueta) {
			return etiquetaService.cadastrarEtiqueta(etiqueta);
	}
	
	
	//Pesquisar determinada etiqueta pelo ID
	@RequestMapping(value = "/pesquisar-etiqueta/{id}", method = RequestMethod.GET)
	public Optional<Etiqueta> pesquisarEtiqueta(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
		Boolean autenticado = VerificarConexao.verifica(request);
		
		if(autenticado==false) {
			try {
				response.getWriter().print("Acesso negado");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("O id é " + id);
		return etiquetaService.pesquisarEtiqueta(id);
	}
	
	
	//Listar todas etiquetas cadastradas
	@RequestMapping(value = "/todas-etiquetas", method = RequestMethod.GET)
	public List<Etiqueta> listarTodasEtiquetas(){
		return etiquetaService.listarEtiquetas();
	}
	
	//Deletar Etiqueta
	@RequestMapping(value = "deletar-etiqueta/{id}", method = RequestMethod.GET)
	public void deletarEtiqueta(@PathVariable Long id) {
		etiquetaService.deletarEtiqueta(id);
	}
	
	
}
