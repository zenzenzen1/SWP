/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Builder
@Setter @Getter 
@NoArgsConstructor
@AllArgsConstructor
public class Milestone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int milestoneId;
    
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "classId")
    private Class _class;
    
    private double weight;
    
    @ManyToOne
    @JoinColumn(name = "parentId")
    private Milestone milestoneParent;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    
    private Integer priority;
    
    @Builder.Default
    @ColumnDefault("true")
    private boolean status = true;
    
    private String description;
}
