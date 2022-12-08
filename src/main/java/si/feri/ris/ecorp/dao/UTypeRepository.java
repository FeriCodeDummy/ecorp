package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.UType;

import java.util.List;

public interface UTypeRepository extends CrudRepository<UType, Long> {
//    @Query("select * from users where fk_utype = (SELECT utype.id from utype where utype.name  = 'CEO')")
    @Query("select t from UType t where t.name = 'CEO'")
    List<UType> getThree();
}
