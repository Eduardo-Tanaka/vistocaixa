package br.gov.caixa.vistocaixa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.caixa.vistocaixa.model.Tarefa;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

}
