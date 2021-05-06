package com.keven.testejavajr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.keven.testejavajr.domain.Contatos;
import com.keven.testejavajr.dto.DContatos;
import com.keven.testejavajr.mapper.ContatosMapper;
import com.keven.testejavajr.repository.ContatosRepository;
import com.keven.testejavajr.service.exception.ObjectNotFoundException;

@Service
public class ContatosService {

	@Autowired
	private ContatosRepository contatosRepository;
	@Autowired
	private TelefonesService telefonesService;

	@Autowired
	private ContatosMapper mapper;

	public Contatos findById(Integer id) {
		return contatosRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Obj pesquisado não existe! "));
	}

	public List<Contatos> findAll() {
		return contatosRepository.findAll();
	}

	public DContatos insert(DContatos obj) {
		Contatos contato = mapper.dContatoToContato(obj);
		contato.setId(null);
		contato.getTelefones().forEach(t -> t.setContatos(contato));
		return mapper.entityToDto(contatosRepository.save(contato));
	}

	public DContatos update(DContatos obj) {
		Contatos contato = findById(obj.getId());

		contato.setEmail(obj.getEmail() == null ? contato.getEmail() : obj.getEmail());
		contato.setPrimeiroNome(obj.getPrimeiroNome() == null ? contato.getPrimeiroNome() : obj.getPrimeiroNome());
		contato.setUltimoNome(obj.getUltimoNome() == null ? contato.getUltimoNome() : obj.getUltimoNome());
		contato.setTelefones(obj.getTelefones() == null ? contato.getTelefones() : telefonesService.updateTelefone(obj.getTelefones()));
		
		return mapper.entityToDto(contatosRepository.save(contato));
	}

	public void delete(Integer id) {
		findById(id);
		contatosRepository.deleteById(id);

	}

	public Page<Contatos> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return contatosRepository.findAll(pageRequest);
	}
}
