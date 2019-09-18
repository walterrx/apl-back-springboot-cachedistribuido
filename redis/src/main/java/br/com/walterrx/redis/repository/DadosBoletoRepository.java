package br.com.walterrx.redis.repository;

import br.com.walterrx.redis.domain.BoletoDomain;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DadosBoletoRepository extends JpaRepository<BoletoDomain, String> {


}
