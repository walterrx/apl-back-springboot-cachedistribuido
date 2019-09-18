package br.com.walterrx.redis.restservice;


import br.com.walterrx.redis.business.DadosBoletoService;
import br.com.walterrx.redis.domain.BoletoDomain;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoBoletoAPI {

    @Autowired
    private DadosBoletoService dadosBoletoService;


    @GetMapping
    public List<BoletoDomain> findAll() {
        return dadosBoletoService.findAll();
    }

    @GetMapping("/{identifier}")
    public BoletoDomain findByIdentifier(@PathVariable("identifier") final String identifier) {
        return dadosBoletoService.findbyIdentifier(identifier);
    }

    @PostMapping
    public BoletoDomain create(@RequestBody final BoletoDomain boleto) {
        return dadosBoletoService.create(boleto);
    }

    @PutMapping
    public BoletoDomain update(@RequestBody final BoletoDomain boleto) {
        return dadosBoletoService.update(boleto);
    }

    @DeleteMapping("/{identifier}")
    public void delete(@PathVariable("identifier") final String identifier) {
        dadosBoletoService.delete(identifier);
    }

}
