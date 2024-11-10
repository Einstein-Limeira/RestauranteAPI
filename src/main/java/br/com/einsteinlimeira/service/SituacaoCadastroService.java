package br.com.einsteinlimeira.service;

import br.com.einsteinlimeira.exceptions.ResourceNotFoundException;
import br.com.einsteinlimeira.model.dto.SituacaoCadastroDTO;
import br.com.einsteinlimeira.model.entity.SituacaoCadastro;
import br.com.einsteinlimeira.repository.SituacaoCadastroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SituacaoCadastroService {

    @Autowired
    private SituacaoCadastroRepository situacaoCadastroRepository;


    public List<SituacaoCadastroDTO> findAll() {
        return situacaoCadastroRepository.findAll().stream().map(SituacaoCadastroDTO::new).toList();
    }

    public SituacaoCadastroDTO findById(Integer id) {
        return situacaoCadastroRepository.findById(id).map(SituacaoCadastroDTO::new).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));
    }

    public SituacaoCadastroDTO save(SituacaoCadastroDTO situacaoCadastroDTO) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroDTO.toEntity();
        return new SituacaoCadastroDTO(situacaoCadastroRepository.save(situacaoCadastro));
    }

    public SituacaoCadastroDTO update(Integer id, SituacaoCadastroDTO situacaoCadastroDTO) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));

        SituacaoCadastro newSituacaoCadastro = situacaoCadastroDTO.toEntity();
        BeanUtils.copyProperties(newSituacaoCadastro, situacaoCadastro, "id");

        return new SituacaoCadastroDTO(situacaoCadastroRepository.save(situacaoCadastro));
    }

    public SituacaoCadastroDTO delete(Integer id) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));
        situacaoCadastroRepository.delete(situacaoCadastro);

        return new SituacaoCadastroDTO(situacaoCadastro);
    }
}