/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "\"class\"")
@Setter @Getter 
@NoArgsConstructor
@AllArgsConstructor
public class Class implements Serializable {
    @Id
    private int classId;
    
    @Column(nullable = false)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;
    
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Setting department;
    
    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Setting semester;
    
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private User teacher;
    
    @Column(nullable = false)
    @ColumnDefault("true")
    private boolean status;
    
    private String description;
}
