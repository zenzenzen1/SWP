/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Setting;
import Util.HibernateUtil;
import static Util.HibernateUtil.shutdown;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;

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
            //            CriteriaBuilder builder = session.getCriteriaBuilder();
            //            CriteriaQuery<Setting> criteria = builder.createQuery(Setting.class);
            //            criteria.from(Setting.class);
            //            List<Setting> products = session.createQuery(criteria).getResultList();
            //            products.forEach((t) -> {
            //                System.out.println(t);
            //            });
            List<Setting> v = (List<Setting>) session.createSQLQuery("SELECT * FROM setting").addEntity(Setting.class).list();
            return v;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }

    public static void main(String[] args) {
        SettingDao settingDao = new SettingDao();
        settingDao.getAllSetting().forEach((t) -> {
            System.out.println(t);
        });
    }
}
