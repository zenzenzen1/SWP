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

/**
 *
 * @author zenzen1
 */
@Entity(name = "user")
@Table(name = "\"user\"")
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {

    @Id
    private String userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Setting department;
    
    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Setting role;
    
    private boolean status;
    
    private String note;
    
}
