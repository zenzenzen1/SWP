/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Setting;
import Util.AppSetting;
import Util.HibernateUtil;
import static Util.HibernateUtil.shutdown;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nguye
 */
public class SettingDao extends DBContext {

    public SettingDao() {
        super();
    }

    public List<Setting> getAllSetting() {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Setting> criteria = builder.createQuery(Setting.class);
            criteria.from(Setting.class);
            List<Setting> products = session.createQuery(criteria).getResultList();
            return products;
//            List<Setting> v = (List<Setting>) session.createSQLQuery("SELECT * FROM setting").addEntity(Setting.class).list();
//            return v;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return new ArrayList<>();
    }

    public List<Setting> getSystemSettings() {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Setting> v = session.createQuery("FROM Setting s where s.settingId in (:ids)"
            )
                    .setParameter("ids", AppSetting.systemSettingIds)
                    .list();
            return v;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return new ArrayList<>();
    }

    public Setting getSettingById(int settingId) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Setting.class, settingId);
        }
    }

    public boolean addNewSetting(Setting setting) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(setting);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SettingDao settingDao = new SettingDao();
        settingDao.getAllSetting().forEach((t) -> {
            System.out.println(t);
        });
       
    }
}
