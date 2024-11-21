package hmaidi.graphqlharaf.Repository;

import hmaidi.graphqlharaf.Entity.Transaction;
import hmaidi.graphqlharaf.Entity.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = :type")
    double sumByType(@Param("type") TypeTransaction type);

    @Query("SELECT t FROM Transaction t WHERE t.compte.id = :compteId")
    List<Transaction> findByCompteId(@Param("compteId") Long compteId);


}
