package com.itsdf07.mapper;

import com.itsdf07.entity.AuthorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AuthorEntityMapper {
    /**
     * @return 作者信息
     */
    AuthorEntity getAuthor();

}