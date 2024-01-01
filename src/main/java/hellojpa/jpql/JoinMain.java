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


        Team team1 = new Team();
        team1.setName("teasmA");
        Team team2 = new Team();
        team2.setName("teasmB");
        em.persist(team1);
        em.persist(team2);

        Member member1 = new Member();
        member1.setUsername("member1");
        member1.setAge(10);
        member1.changeTeam(team1);
        member1.setType(MemberType.ADMIN);
        em.persist(member1);

        Member member2 = new Member();
        member2.setUsername("member2");
        member2.setAge(10);
        member2.changeTeam(team1);
        member2.setType(MemberType.ADMIN);
        em.persist(member2);

        Member member3 = new Member();
        member3.setUsername("member2");
        member3.setAge(10);
        member3.changeTeam(team2);
        member3.setType(MemberType.ADMIN);
        em.persist(member3);


        String query1 = "select m from Member m join fetch m.team";
        List<Member> result1 = em.createQuery(query1, Member.class)
                .getResultList();

        for (Member member : result1) {
            System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
        }


        String query2 = "select t from Team t join fetch t.members";
        List<Team> result2 = em.createQuery(query2, Team.class)
                .getResultList();

        for (Team team : result2) {
            System.out.println("team.getName() = " + team.getName() + ", size() = " + team.getMembers().size());
        }
    }
}