package xyz.guojinlong.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.guojinlong.batch.entity.wirte.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
