package com.educandoweb.cursomc2022.services.validation;

import com.educandoweb.cursomc2022.dto.ClienteNewDTO;
import com.educandoweb.cursomc2022.entities.Cliente;
import com.educandoweb.cursomc2022.entities.enums.TipoCliente;
import com.educandoweb.cursomc2022.repositories.ClienteRepository;
import com.educandoweb.cursomc2022.resources.exceptions.FieldMessage;
import com.educandoweb.cursomc2022.services.validation.utils.BR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipoCliente().equals(TipoCliente.PESSOA_FISICA.getCodigo()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "Cpf inválido"));
        }

        if (objDto.getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA.getCodigo()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "Cnpj inválido"));
        }

        Cliente aux = repository.findClienteByEmail(objDto.getEmail());
        if (aux != null) {
            list.add(new FieldMessage("Email", "Email existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
