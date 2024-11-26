/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

/**
 *
 * @author nguye
 */
@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Setting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int settingId;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToOne
    @JoinColumn(name = "typeId")
    private Setting type;
    
    @Column(name = "\"value\"")
    private String value;
    
    @Column(nullable = true)
    @ColumnDefault("null")
    private Integer priority;
    
    @Column(nullable = false)
    @ColumnDefault("true")
    @Builder.Default
    private boolean status = true;
    
    private String description;

    @Override
    public String toString() {
        return "Setting{" + "settingId=" + settingId + ", name=" + name + ", type=" + type + ", value=" + value + ", priority=" + priority + ", status=" + status + ", description=" + description + '}';
    }
    
    
    
    
}
