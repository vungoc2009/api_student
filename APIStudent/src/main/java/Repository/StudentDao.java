package Repository;

import Entity.Student;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Query;

import java.util.List;


public class StudentDao {
    Logger logger = Logger.getLogger(String.valueOf(StudentDao.class));

    public List<Student> getAll() {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Student> students = session.createQuery("from Student ").list();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace();
                logger.error(e);
            }
        }
        session.close();
        return null;
    }

    //    Thêm
    public boolean addnew(Student student) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace();
                logger.error(e);
            }
        }
        session.close();
        return false;
    }

// xos


    public boolean delete(int id) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(id);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace();
                logger.error(e);
            }
        }
        session.close();
        return false;
    }

    //   cap nhap
    public boolean update(Student student) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace();
                logger.error(e);
            }
        }
        session.close();
        return false;
    }

    //    theo ten
    public List<Student> getByName(String name) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Student> query = session.createQuery("from Student  where lower(fullName) like :s_name");
            query.setParameter("s_name", "%" + name + "%");
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (transaction == null) {
                transaction.rollback();
                e.printStackTrace();
                logger.error(e);
            }
        }
        session.close();
        return null;
    }

    //  ngay sinh
    public List<Student> getbyDay(int start, int end) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where to_number(to_char(birthday,'dd')) between :start and :end");
            query.setParameter("start", start);
            query.setParameter("end", end);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;

    }

    //    gioi tinh
    public List<Student> getAllByGender(String gender) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(gender)= :s_gender");
            query.setParameter("s_gender", gender);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    //    theo lop
    public List<Student> getByClassName(String name) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(className)= :s_cname");
            query.setParameter("s_cname", name);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    // theo khoa
    public List<Student> getByMajor(String major) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where lower(major)= :s_major");
            query.setParameter("s_major", major);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    //    theo diem
    public List<Student> getAllByMark(float markBegin, float markEnd) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query<Student> query = session.createQuery(" from Student where averageMark between :markBegin and :markEnd");
            query.setParameter("markBegin", markBegin);
            query.setParameter("markEnd", markEnd);
            List<Student> students = query.getResultList();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    // sinh nhat
    public List<Student> getAllByBirthday() {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Student> students = session.createQuery(" from Student where to_char(current_date ,'ddMM')=to_char(birthday,'ddMM')").list();
            session.getTransaction().commit();
            return students;
        } catch (HibernateException e) {
            if (tx == null)
                tx.rollback();
            e.printStackTrace();
            logger.error(e);
        } finally {
            session.close();
        }
        return null;
    }


}
