/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilisi.hibernate.biblio.model.dao.adherant;

import java.util.Collection;
import ilisi.hibernate.biblio.model.bo.Adherant;

/**
 *
 * @author S USER
 */
public interface IDAOAdherant {
     boolean create(Adherant L);
    Collection<Adherant> retreive();
    boolean update (Adherant L);
    boolean delete(Adherant L);
}
