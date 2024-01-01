package hellojpa.jpql;

import hellojpa.jpql.domain.Member;
import hellojpa.jpql.domain.MemberDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProjectionMain implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
        //List<Member> resultList = query1.getResultList();
        //for (Member member1 : resultList) {
        //    System.out.println("member1 = " + member1);
        //}
        //
        //TypedQuery<Member> query2 = em.createQuery("select m from Member m where m.id = 1L", Member.class);
        //Member singleResult = query2.getSingleResult();
        //
        //Query query3 = em.createQuery("select m.username, m.age from Member m");
        //
        //TypedQuery<Member> query4 = em.createQuery("select m from Member m where m.username = :username", Member.class);
        //query4.setParameter("username", "member1");
        //Member singleResult1 = query4.getSingleResult();
        //System.out.println("singleResult1 = " + singleResult1);
        //
        //List<MemberDTO> resultList1 = em.createQuery("select new hellojpa.jpql.domain.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
        //        .getResultList();
    }
}
