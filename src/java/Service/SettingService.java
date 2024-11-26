/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.SettingDao;
import Model.Setting;
import java.util.List;

/**
 *
 * @author nguye
 */
public class SettingService {
    public static final SettingDao settingDao = new SettingDao();
    
    public List<Setting> getAllSetting(){
        return settingDao.getAllSetting();
    }
    
    public List<Setting> getSystemSettings(){
        return settingDao.getSystemSettings();
    }
    
    
    public static void main(String[] args) {
        SettingService settingService = new SettingService();
        System.out.println(settingService.getAllSetting());
    }
}
