/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mv.gov.customs.webapi.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "person",
    indexes = {
            @Index(columnList = "first name", unique = false),
            @Index(columnList = "last name", unique = false)
               }
       )

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable =false)
    private int Id;
    @Column(name = "firstname", nullable =false)
    private int FirstName;
    @Column(name = "lastname", nullable =false)
    private String LastName;

    
    @ManyToOne
    private Family Family;
    
    @OneToMany
    private final List<Job> Job = new ArrayList<Job>();
    
    @Transient
    private String FullName = LastName + FirstName;
            
            
    
}
