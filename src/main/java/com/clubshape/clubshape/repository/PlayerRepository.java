package com.clubshape.clubshape.repository;

import com.clubshape.clubshape.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findByFio(String fio);
}
