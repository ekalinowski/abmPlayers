package ekalinowski.models;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;


@Transactional
public interface PlayersDAO extends CrudRepository<Player, Long> {
	List<Player> findByName(String name);

	List<Player> findAll();

}

