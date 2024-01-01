package hellojpa.jpql;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JpaMain implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

    }
}
