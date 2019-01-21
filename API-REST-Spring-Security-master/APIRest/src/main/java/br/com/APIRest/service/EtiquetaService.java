package br.com.APIRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.APIRest.model.Etiqueta;
import br.com.APIRest.repository.EtiquetaRepository;

@Service
public class EtiquetaService {
	
	@Autowired
	EtiquetaRepository etiquetaRepository;
	
	public Etiqueta cadastrarEtiqueta(Etiqueta etiqueta) {
		return etiquetaRepository.save(etiqueta);
	}
	
	public Optional<Etiqueta> pesquisarEtiqueta(Long id){
		return  etiquetaRepository.findById(id);
	}
	
	public List<Etiqueta> listarEtiquetas(){
		return etiquetaRepository.findAll();
	}
	
	public void deletarEtiqueta(Long id) {
		etiquetaRepository.deleteById(id);
	}
}
