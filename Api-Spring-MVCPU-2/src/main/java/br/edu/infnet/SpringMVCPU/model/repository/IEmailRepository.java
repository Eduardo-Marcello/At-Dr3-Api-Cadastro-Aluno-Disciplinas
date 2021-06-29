package br.edu.infnet.SpringMVCPU.model.repository;

import br.edu.infnet.SpringMVCPU.model.negocio.Email;
import org.springframework.data.repository.CrudRepository;

public interface IEmailRepository extends CrudRepository<Email, Integer> {

}
