package br.com.walterrx.redis.business;

import br.com.walterrx.redis.domain.BoletoDomain;
import br.com.walterrx.redis.repository.DadosBoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class DadosBoletoService {

    @Autowired
    private DadosBoletoRepository dadosBoletoRepository;


    //Anotação para definição do nome do cache e a chave. Na primeira vez que este metodo for executado
    // as informações retornadas serão gravadas no cache, e na proxima execução a operação não executará a operação, pois será buscada via cache
    @Cacheable(cacheNames = BoletoDomain.CACHE_NAME, key="#boletos")
    public List<BoletoDomain> findAll() {
        return dadosBoletoRepository.findAll();
    }

    //Anotação para definição do nome do cache e a chave //Anotação para definição do nome do cache e a chave. Na primeira vez que este metodo for executado
    //    // as informações retornadas serão gravadas no cache, e na proxima execução a operação não executará a operação, pois será buscada via cache
    @Cacheable(cacheNames = BoletoDomain.CACHE_NAME, key="#boleto.codigobarras")
    public BoletoDomain findbyIdentifier(final String codigoBarras) {
        return dadosBoletoRepository.findById(codigoBarras)
                .orElseThrow(() -> new EntityNotFoundException("Código de Barras: " + codigoBarras + " não identificado !"));
    }

    // Anotação para remoção ou limpeza de cache.
    // Quando utilizado com a propriedade allEntries = true, todos as informações do cacheName serão removidas
     @CacheEvict(cacheNames = BoletoDomain.CACHE_NAME, allEntries = true)
    public BoletoDomain create(final BoletoDomain boleto) {
        return dadosBoletoRepository.save(boleto);
    }

    // @CachePut - Anotação para atualização do cache
    @CachePut(cacheNames = BoletoDomain.CACHE_NAME, key="#boleto.getCodigoBarras()")
    public BoletoDomain update(final BoletoDomain boleto) {
        if(boleto.getCodigoBarras()== null) {
            throw new EntityNotFoundException("Codigo de Barras nao encontrado !");
        }

        return dadosBoletoRepository.save(boleto);
    }

    // Anotação para remoção ou limpeza de cache.
    // quando utilizado com a propriedade key, será removido apenas um dado especificado no key.
    @CacheEvict(cacheNames = BoletoDomain.CACHE_NAME, key="#boleto.codigobarras")
    public void delete(final String codigoBarras) {
        if(codigoBarras == null) {
            throw new EntityNotFoundException("Codigo de Barras vazio !");
        }

        dadosBoletoRepository.deleteById(codigoBarras);
    }

}
