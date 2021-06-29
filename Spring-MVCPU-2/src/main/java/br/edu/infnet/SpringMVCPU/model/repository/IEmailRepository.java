package br.edu.infnet.SpringMVCPU.model.repository;

import br.edu.infnet.SpringMVCPU.model.negocio.Email;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailRepository extends CrudRepository<Email, Integer> {
	@Query(value = "SELECT e FROM Email e WHERE e.mail LIKE '%' || :keyword || '%'")   
    public List<Email> search(@Param("keyword") String keyword);
}
