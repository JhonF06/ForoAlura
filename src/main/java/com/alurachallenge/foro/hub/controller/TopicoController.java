package com.alurachallenge.foro.hub.controller;

import com.alurachallenge.foro.hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
     public ResponseEntity<DatosRegistroTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                      UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topico(datosRegistroTopico);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        topicoRepository.save(topico);
        return ResponseEntity.created(url).body(datosRegistroTopico);
    }

    @GetMapping
    public ResponseEntity <Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopicos>  buscarTopicoPorId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosListadoTopicos(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha(),
                topico.getStatus(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRegistroTopico> borrarTopico (@PathVariable @RequestBody Long id){
        var topico = topicoRepository.findById(id).orElse(null);
        if (topico != null ) {
            topicoRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico  topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actulizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosListadoTopicos(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha()
        ,topico.getStatus(),topico.getAutor(),topico.getCurso()));

    }





}