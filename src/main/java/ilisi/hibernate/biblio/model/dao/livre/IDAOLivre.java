/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ilisi.hibernate.biblio.model.dao.livre;

import java.util.Collection;
import ilisi.hibernate.biblio.model.bo.Livre;

/**
 *
 * @author ilisi
 */
public interface IDAOLivre {
    boolean create(Livre L);
    Collection<Livre> retreive();
    boolean update (Livre L);
    boolean delete(Livre L);
}
