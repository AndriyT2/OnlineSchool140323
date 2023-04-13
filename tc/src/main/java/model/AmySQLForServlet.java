package model;

import models.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import osHibernate.AdditionalMaterialsEntity;
import osHibernate.LectureEntity;
import osHibernate.PersonEntity;
import utility.hibernate.HibernateUtil;
import utility.utilityLog.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan({"model"})
@Lazy
@PropertySource("classpath:connection.properties")
public class AmySQLForServlet {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AmySQLForServlet.class);


    @Value("${bd_url}")
    private String bd_url;

    @Value("${user}")
    private String user;

    @Value("${password}")
    private String password;

    @Value("${driver}")
    private String driver;

    public Connection getConnection() throws SQLException {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(bd_url, user, password);
    }
//     ??????Чому БД дозволяє створювати рядки з пустими стовпчиками, які позначені як NotNull
    public void addPersonSQLJSP(String lastname, String firstname, String phone, String email, String role) {
//        LogFactory.debug(this.getClass().getName(), "Create new person JSP");
        PersonEntity person = new PersonEntity();
        person.setLastname(lastname);
        person.setFirstname(firstname);
        person.setPhone(phone);
        person.setEmail(email);
        person.setRole(role);
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person);
        transaction.commit();
        HibernateUtil.shutdown();

    }

//???Select(79) не працюэ
    public List<PersonEntity> personGetAll() {
        List<PersonEntity> personList = new ArrayList<>();


       try(Session session = HibernateUtil.getSession()) {

//           Query query = session.createQuery("select  p.personId, p.lastname, p.role from PersonEntity p");
//           Query<PersonEntity> query = session.createQuery("select  p.personId, p.lastname, p.role from PersonEntity p", PersonEntity.class);
           Query<PersonEntity> query = session.createQuery("from PersonEntity", PersonEntity.class);
           personList = query.list();
           System.out.println(personList);
       }
        return personList;
    }


    public PersonEntity personById(int idFromDB) {
        Query query;
        PersonEntity person;
        try (Session session = HibernateUtil.getSession()) {
            query = session.createQuery("from PersonEntity  where id=:personId");

            query.setParameter("personId", idFromDB);
            person = (PersonEntity) query.uniqueResult();
        }
        return person;
    }
//??? Не сортує за датоюта та не відображає на вебсторінці
    public List<LectureEntity> lectureBefore2023() {

        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT l.name, count (am.additionalMaterialsId) as amCount from LectureEntity l left join AdditionalMaterialsEntity am where l.lectureDate < :date group by l.lectureId order by l.lectureDate"); //where l.lectureDate<'2023-01-01 00:00:00'
        query.setParameter("date", java.sql.Date.valueOf("2023-01-01 00:00:00"));
        List<LectureEntity> lectureList = query.list();
        System.out.println(query.list());
        HibernateUtil.shutdown();
//        List<Lecture> lectureList = null;
//        try (Connection connection = ctx.getBean(AmySQLForServlet.class).getConnection()) {
//            String lectureSQL = "SELECT l.name, COUNT(am.additional_materials_id) AS am_count FROM lecture l LEFT JOIN additional_materials am ON l.lecture_id = am.lecture_id WHERE l.lecture_date < '2023-01-01 00:00:00' GROUP BY l.lecture_id ORDER BY l.lecture_date";
//            CallableStatement statement = connection.prepareCall(lectureSQL);
//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//                String name = result.getString("name");
//                int am_count = result.getInt("am_count");
//                Lecture lecture = new Lecture(name);
//                lecture.am = am_count;
//                lectureList.add(lecture);
//            }
//        } catch (SQLException e) {
//            LogFactory.warning(this.getClass().getName(), "JSP", e.getStackTrace());
//        }
        return lectureList;
    }
//??? Не  відображає на вебсторінці
    public LectureEntity firstLecture() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select l.lectureId, l.description, l.lectureDate, l.lectureDate, l.name, l.creationDate, count (h.homeworkId) as hCount from LectureEntity l left join HomeworkEntity h where l.creationDate = (select max (creationDate) from LectureEntity ) group by l.lectureId order by hCount limit 1");
        LectureEntity lecture = (LectureEntity) query.uniqueResult();
        HibernateUtil.shutdown();

//        Query<LectureEntity> query = session.createQuery("select l.lectureId, l.description, l.lectureDate, l.lectureDate, l.name, l.creationDate, count (h.homeworkId) as hCount from LectureEntity l left join HomeworkEntity h where l.creationDate = (select max (creationDate) from LectureEntity ) group by l.lectureId order by hCount limit 1", LectureEntity.class);
//        LectureEntity lecture = query.uniqueResult();
//
//
//
//        try (Connection connection = ctx.getBean(AmySQLForServlet.class).getConnection()) {
//            String lectureSQL = "SELECT l.lecture_id, l.description, l.lecture_date, l.name, l.creation_date, COUNT(h.homework_id)  AS hw_count\nFROM lecture l\nLEFT JOIN homework h ON l.lecture_id = h.lecture_id\nWHERE l.creation_date = (SELECT MAX(creation_date) FROM lecture)\nGROUP BY l.lecture_id\nORDER BY hw_count DESC\nLIMIT 1".formatted();
//            CallableStatement statement = connection.prepareCall(lectureSQL);
//            ResultSet result = statement.executeQuery();
//            while (result.next()) {
//                int IdSQL = result.getInt("lecture_id");
//                String name = result.getString("name");
//                String description = result.getString("description");
//                LocalDateTime creationDate = result.getTimestamp("creation_date").toLocalDateTime();
//                LocalDateTime lectureDate = result.getTimestamp("lecture_date").toLocalDateTime();
//                lecture = new Lecture(IdSQL, name, description, creationDate, lectureDate);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            LogFactory.warning(this.getClass().getName(), "JSP", e.getStackTrace());
//        }
        return lecture;
    }

    public List<PersonEntity> studentByLastname() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from PersonEntity where role = 'student' order by lastname");
        List<PersonEntity> studentList = query.list();
        HibernateUtil.shutdown();

        return studentList;
    }

    //??? Не  відображає на вебсторінці
    public List<AdditionalMaterialsEntity> amType() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select  resourceType, count (additionalMaterialsId) as typeTotal from AdditionalMaterialsEntity group by resourceType");
        List<AdditionalMaterialsEntity> materialsEntityList = query.list();
        System.out.println(materialsEntityList);
        transaction.commit();
        HibernateUtil.shutdown();

        return materialsEntityList;
    }

    //??? Не  відображає на вебсторінці, тільки заголовок таблиці, проблема в regex
    public List<PersonEntity> teacherByLetter() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from PersonEntity where lastname like '^[A-N]|^[А-Н]'"); // role = 'teacher' and
        List<PersonEntity> personEntityList = query.list();
//        HibernateUtil.shutdown();


        return personEntityList;
    }
// Не  переробляв

    public List<Person> studentOnCourse(int countCourse) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        HibernateUtil.shutdown();
        List<Person> personList = new ArrayList<>();
        String studentSQL;
        try (Connection connection = ctx.getBean(AmySQLForServlet.class).getConnection()) {
            if (countCourse == 1) {
                studentSQL = """
                        SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
                        FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
                        WHERE p.role = 'student'
                            GROUP BY p.person_id
                            HAVING course_total_count =1
                        ORDER BY lastname;
                        """;
            } else if (countCourse == 2) {
                studentSQL = """
                        SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
                        FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
                        WHERE p.role = 'student'
                            GROUP BY p.person_id
                            HAVING course_total_count =2
                        ORDER BY lastname""";
            } else {
                studentSQL = """
                        SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
                        FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
                        WHERE p.role = 'student'
                            GROUP BY p.person_id
                            HAVING course_total_count >=3
                        ORDER BY lastname""";
            }


            CallableStatement statement = connection.prepareCall(studentSQL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String lastname = result.getString("lastname");
                String firstname = result.getString("firstname");
                Person person = new Person(firstname, lastname);
                personList.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LogFactory.warning(this.getClass().getName(), "JSP", e.getStackTrace());
        }

        return personList;
    }


}


