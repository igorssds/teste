package com.keven.testejavajr.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.keven.testejavajr.domain.Telefones;
import com.keven.testejavajr.dto.DTelefones;

@Mapper(componentModel = "spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR ,
uses = ContatosMapper.class)
public interface TelefoneMapper {
	
	Telefones dTelefonesToTelefones(DTelefones telefones);
	
	DTelefones entityToDto(Telefones telefones);
	
	default List<Telefones> listDTelefoneToListTelefones(List<DTelefones> listTelefones){
		if(listTelefones == null)
			return Collections.emptyList();
		
		return listTelefones.stream().map(this::dTelefonesToTelefones).collect(Collectors.toList());
	}

	default List<DTelefones> listEntityToListDto(List<Telefones> list){
		if(list == null)
			return Collections.emptyList();
		
		return list.stream().map(this::entityToDto).collect(Collectors.toList());
	}
}
