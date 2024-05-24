import com.mysql.cj.conf.ConnectionUrlParser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Purchaselist> courseCriteriaQuery = criteriaBuilder.createQuery(Purchaselist.class);
        Root<Purchaselist> root = courseCriteriaQuery.from(Purchaselist.class);
        List<Purchaselist> purchaselists = session.createQuery(courseCriteriaQuery).getResultList();

        List<String> coursesNames = new ArrayList<>();
        for(Purchaselist p : purchaselists){
            if (!coursesNames.contains(p.getCourse_name())){
                coursesNames.add(p.getCourse_name());
            }
        }

        Map<String, Integer> totalExpenses = new HashMap<>();
        for (String course : coursesNames) {
            totalExpenses.put(course, 0);
        }

        for (Purchaselist p : purchaselists) {
            String course = p.getCourse_name();
            Integer price = p.getPrice();
            totalExpenses.put(course, totalExpenses.get(course) + price);
        }

        totalExpenses.forEach((elem1, elem2) -> System.out.println(elem1 + " - " + elem2));


        transaction.commit();
        sessionFactory.close();
    }
}
