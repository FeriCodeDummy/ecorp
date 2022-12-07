package si.feri.ris.ecorp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.feri.ris.ecorp.models.CEO;

import java.util.List;

public interface CEORepository extends CrudRepository<CEO, Long> {

    @Query("SELECT * FROM Users where fk_utype = (SELECT utype.id from utype where utype.name  = 'CEO')")
    List<CEO> returnCEO(/*String typeName*/);
}
