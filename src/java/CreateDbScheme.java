
import Dao.SettingDao;
import Model.Setting;
import Util.AppSetting;
import Util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nguye
 */
public class CreateDbScheme {
    public static void main(String[] args) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            try {
                for(String name : AppSetting.systemSettingName ){
                    if(new SettingDao().getSettingById(1) != null )
                    {
                        return;
                    }
                    Setting setting = Setting.builder()
                            .name(name)
                            .build();
                    session.save(setting);
                }
            } catch (Exception e) {
            }

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Setting> criteria = builder.createQuery(Setting.class);
            criteria.from(Setting.class);
            List<Setting> settings = session.createQuery(criteria).getResultList();
            settings.forEach((t) -> {
                System.out.println(t);
            });

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
