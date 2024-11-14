package br.com.einsteinlimeira.service;

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

    public List<SituacaoCadastroDTO> findAllAccountsStatus() {
        return situacaoCadastroRepository.findAll().stream().map(SituacaoCadastroDTO::new).toList();
    }

    public SituacaoCadastroDTO findAccountStatusById(Integer id) {
        SituacaoCadastro findAccountStatus = situacaoCadastroRepository.getReferenceById(id);
        return new SituacaoCadastroDTO(findAccountStatus);
    }

    public SituacaoCadastroDTO saveAccountStatus(SituacaoCadastroDTO situacaoCadastroDTO) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroDTO.toEntity();
        return new SituacaoCadastroDTO(situacaoCadastroRepository.save(situacaoCadastro));
    }

    public SituacaoCadastroDTO updateAccountStatus(Integer id, SituacaoCadastroDTO situacaoCadastroDTO) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroRepository.getReferenceById(id);

        SituacaoCadastro newSituacaoCadastro = situacaoCadastroDTO.toEntity();
        BeanUtils.copyProperties(newSituacaoCadastro, situacaoCadastro, "id");

        return new SituacaoCadastroDTO(situacaoCadastroRepository.save(situacaoCadastro));
    }

    public SituacaoCadastroDTO deleteAccountStatus(Integer id) {
        SituacaoCadastro situacaoCadastro = situacaoCadastroRepository.getReferenceById(id);
        situacaoCadastroRepository.delete(situacaoCadastro);
        return new SituacaoCadastroDTO(situacaoCadastro);
    }
}