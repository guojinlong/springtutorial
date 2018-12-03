package xyz.guojinlong.batch.repository.read;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.guojinlong.batch.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
