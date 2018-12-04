package xyz.guojinlong.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import xyz.guojinlong.batch.entity.wirte.People;
import xyz.guojinlong.batch.entity.read.User;

import java.util.UUID;

@Slf4j
@Component
public class UserPeopleItemProcessor implements ItemProcessor<User, People> {
    @Override
    public People process(User user) throws Exception {
        final String firstName = user.getFirstName().toUpperCase();
        final String lastName = user.getLastName().toUpperCase();
        final People transformedPeople = People.builder().firstName(firstName)
                .lastName(lastName).personId(UUID.randomUUID().toString()).build();
        log.info("converting user to people:" + transformedPeople);
        return transformedPeople;
    }
}
