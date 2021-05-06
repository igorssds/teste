package com.keven.testejavajr.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.keven.testejavajr.domain.Contatos;
import com.keven.testejavajr.dto.DContatos;

@Mapper(componentModel = "spring" , injectionStrategy = InjectionStrategy.CONSTRUCTOR ,
uses = TelefoneMapper.class)
public interface ContatosMapper {

	Contatos dContatoToContato(DContatos contatos);
	
	DContatos entityToDto(Contatos contato);
}
