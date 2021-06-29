package br.edu.infnet.SpringMVCPU.model.repository;

import br.edu.infnet.SpringMVCPU.model.negocio.Disciplina;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplinaRepository extends CrudRepository<Disciplina, Integer> {
	@Query(value = "SELECT d FROM Disciplina d WHERE d.nome LIKE '%' || :keyword || '%'"
            + " OR d.codigo LIKE '%' || :keyword || '%'")   
    public List<Disciplina> search(@Param("keyword") String keyword);
}
