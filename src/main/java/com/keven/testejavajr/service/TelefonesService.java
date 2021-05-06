package com.keven.testejavajr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keven.testejavajr.domain.Telefones;
import com.keven.testejavajr.dto.DTelefones;
import com.keven.testejavajr.mapper.TelefoneMapper;
import com.keven.testejavajr.repository.TelefonesRepository;
import com.keven.testejavajr.service.exception.ObjectNotFoundException;

@Service
public class TelefonesService {

	@Autowired
	private TelefonesRepository telefonesRepository;

	@Autowired
	private TelefoneMapper telefoneMapper;

	public DTelefones find(Integer id) {
		Telefones telefone = telefonesRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Obj pesquisado não existe! "));
		return telefoneMapper.entityToDto(telefone);
	}

	public List<DTelefones> findAll() {
		return telefoneMapper.listEntityToListDto(telefonesRepository.findAll());
	}

	public Telefones updateData(Telefones newObj, Telefones obj) {
		newObj.setTelefone((obj.getTelefone() == null) ? newObj.getTelefone() : obj.getTelefone());
		return newObj;
	}

	public void updateOrInsert(Telefones updateData) {
		telefonesRepository.save(updateData);
	}

	public List<Telefones> updateTelefone(List<DTelefones> telefones) {
		List<Telefones> response = new ArrayList<>();
		for (DTelefones t : telefones) {
			Telefones telefone = telefonesRepository.findById(t.getId())
					.orElseThrow(() -> new ObjectNotFoundException("Obj pesquisado não existe! "));
			telefone.setTelefone(t.getTelefone() == null ? telefone.getTelefone() : t.getTelefone());
			response.add(telefonesRepository.save(telefone));
		}

		return response;
	}

}
