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


    public List<SituacaoCadastroDTO> getAll() {
        return situacaoCadastroRepository.findAll().stream().map(SituacaoCadastroDTO::new).toList();
    }

    public SituacaoCadastroDTO getById(Integer id) {
        return situacaoCadastroRepository.findById(id).map(SituacaoCadastroDTO::new).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));
    }

    public void save(SituacaoCadastroDTO situacaoCadastroDTO) {
        situacaoCadastroRepository.save(situacaoCadastroDTO.toEntity());
    }

    public void update(Integer id, SituacaoCadastroDTO situacaoCadastroDTO) {
        SituacaoCadastro findSituacaoCadastro = situacaoCadastroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));

        SituacaoCadastro newSituacaoCadastro = situacaoCadastroDTO.toEntity();
        BeanUtils.copyProperties(newSituacaoCadastro, findSituacaoCadastro, "id");

        situacaoCadastroRepository.save(findSituacaoCadastro);
    }

    public void delete(Integer id) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Situação Cadastro", id));
        situacaoCadastroRepository.delete(situacaoCadastro);
    }
}