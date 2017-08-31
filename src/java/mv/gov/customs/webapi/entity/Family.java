
package mv.gov.customs.webapi.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "family",
    indexes = {
            @Index(columnList = "description", unique = false)
               }
)         
public class Family implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable =false)
    private int Id;
    @Column(name = "description", nullable =false)
    private String Description;
    
    @OneToMany(mappedBy = "Family")
    private final List<Person> Persons = new ArrayList<Person>();
    
}
