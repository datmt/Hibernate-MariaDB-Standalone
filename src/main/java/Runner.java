import entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Runner {
    public static void main(String[] args) {

        Book b = new Book();
        b.setAuthor("No name");
        b.setPages(2000);
        b.setTitle("Some book");

        SessionFactory factory = SessionFactoryMaker.getFactory();

        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(b);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
