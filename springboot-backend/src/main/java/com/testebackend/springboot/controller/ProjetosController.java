package com.testebackend.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testebackend.springboot.exception.ResourceNotFoundException;
import com.testebackend.springboot.model.Projeto;
import com.testebackend.springboot.repository.ProjetosRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class ProjetosController {
	
	@Autowired
	private ProjetosRepository projetosRepository;
	
	// get all projects
	@GetMapping("/projetos")
	public List<Projeto> getAllProjects(){
		return projetosRepository.findAll();
	}
	
	// create project rest api
	@PostMapping("/projetos")
	public Projeto createProjeto(@RequestBody Projeto projeto) {
		return projetosRepository.save(projeto);
	}
	
	//get project by id rest api
	@GetMapping("/projetos/{id}")
	public ResponseEntity<Projeto> getProjectById(@PathVariable Long id) {
		Projeto projeto = projetosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Projeto não existe com o id: " + id));
		return ResponseEntity.ok(projeto);
	}
	
	// update project rest api
	@PutMapping("/projetos/{id}")
	public ResponseEntity<Projeto> updateProject(@PathVariable Long id, @RequestBody Projeto projectDetails){
		Projeto projeto = projetosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Projeto não existe com o id: " + id));
		projeto.setNome(projectDetails.getNome());
		projeto.setDescricao(projectDetails.getDescricao());
		projeto.setResponsavel(projectDetails.getResponsavel());
		projeto.setDataInicio(projectDetails.getDataInicio());
		projeto.setDataPrevisao(projectDetails.getDataPrevisao());
		projeto.setDataReal(projectDetails.getDataReal());
		projeto.setOrcamento(projectDetails.getOrcamento());
		projeto.setStatus(projectDetails.getStatus());
		projeto.setRisco(projectDetails.getRisco());
		
		Projeto updatedProject = projetosRepository.save(projeto);
		return ResponseEntity.ok(updatedProject);
	}
	
	// delete project rest api
	@DeleteMapping("/projetos/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable Long id){
		Projeto projeto = projetosRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Projeto não existe com o id: " + id));
		
		projetosRepository.delete(projeto);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
