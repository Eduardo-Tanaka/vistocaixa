package br.gov.caixa.vistocaixa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.vistocaixa.security.transfer.JwtUserDto;;

@Repository
public interface UserRepository extends CrudRepository<JwtUserDto, Long> {
	JwtUserDto findByEmail(String email);
}