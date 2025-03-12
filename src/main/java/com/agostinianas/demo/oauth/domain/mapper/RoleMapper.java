package com.agostinianas.demo.oauth.domain.mapper;



import com.agostinianas.demo.oauth.domain.dto.RoleDTO;
import com.agostinianas.demo.oauth.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    private RoleMapper() {
    }

    public static RoleDTO toDTO(Role entity) {
        if (entity == null) {
            return null;
        }
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static Role toEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public static List<RoleDTO> toDTOList(List<Role> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream().map(RoleMapper::toDTO).collect(Collectors.toList());
    }

    public static List<Role> toEntityList(List<RoleDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream().map(RoleMapper::toEntity).collect(Collectors.toList());
    }

}

