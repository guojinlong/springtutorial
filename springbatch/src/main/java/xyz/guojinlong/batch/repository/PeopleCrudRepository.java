package xyz.guojinlong.batch.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.guojinlong.batch.entity.wirte.People;

public interface PeopleCrudRepository extends CrudRepository<People, Long> {
}
