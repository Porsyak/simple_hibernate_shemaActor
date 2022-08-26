import entity.ActorEntity;
import entity.User;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.List;

@Log4j2
public class Main {
    public static void main(String[] args) {
        log.info("Start");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.close();
        HibernateUtil.close();


    }

    // Criteria API
    public static void insertTable(String firsName, String lastName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction(); // открыть транзакцию
        ActorEntity actor = new ActorEntity();
        actor.setFirstName(firsName);
        actor.setLastName(lastName);
        actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        session.persist(actor);
        session.getTransaction().commit(); // закомитить
        session.close(); // закрыть транзакцию
        HibernateUtil.close();
    }

    public static void getListTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ActorEntity> criteriaQuery = criteriaBuilder.createQuery(ActorEntity.class);
        Root<ActorEntity> root = criteriaQuery.from(ActorEntity.class);
        criteriaQuery.select(root);//.where(criteriaBuilder.gt(root.get("id"), 10));
        Query query = session.createQuery(criteriaQuery);
        List<ActorEntity> list = query.getResultList();
        list.forEach(System.out::println);
        session.close();
        HibernateUtil.close();

    }

    public static void deleteFromTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<ActorEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(ActorEntity.class);
        Root<ActorEntity> root = criteriaDelete.from(ActorEntity.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), 10));
        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();
        session.close();
    }

    //HQL
    public static void getListTableHQL() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ActorEntity> list =
                session.createQuery("from ActorEntity", ActorEntity.class).getResultList();
        list.forEach(System.out::println);
        session.close();
        HibernateUtil.close();
    }

    public static void getStringFirstName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.query.Query<String> query = session.createQuery("" +
                "select firstName " +
                "from ActorEntity " +
                "where id = : id", String.class);
        query.setParameter("id", 33);
        String firsName = query.uniqueResult();
        System.out.println(firsName);
        session.close();
        HibernateUtil.close();
    }

}
