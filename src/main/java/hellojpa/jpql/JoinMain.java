package hellojpa.jpql;

import hellojpa.jpql.domain.Member;
import hellojpa.jpql.domain.MemberType;
import hellojpa.jpql.domain.Team;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JoinMain implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        Team team = new Team();
        team.setName("teasmA");
        em.persist(team);

        Member member1 = new Member();
        member1.setUsername("member1");
        member1.setAge(10);
        member1.setTeam(team);
        member1.setType(MemberType.ADMIN);
        em.persist(member1);


        String query = "select m from Member m where m.type = :userType";
        List<Member> result = em.createQuery(query, Member.class)
                .setParameter("userType", MemberType.ADMIN)
                .getResultList();

        System.out.println("result.size() = " + result.size());
        for (Member member : result) {
            System.out.println("member = " + member);
        }
    }
}