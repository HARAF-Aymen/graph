package hmaidi.graphqlharaf;

import hmaidi.graphqlharaf.Entity.Compte;
import hmaidi.graphqlharaf.Entity.Transaction;
import hmaidi.graphqlharaf.Entity.TypeCompte;
import hmaidi.graphqlharaf.Entity.TypeTransaction;
import hmaidi.graphqlharaf.Repository.CompteRepository;
import hmaidi.graphqlharaf.Repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphqlharafApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlharafApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
        return args -> {
            Compte compte1 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, null));
            Compte compte2 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT, null));
            Compte compte3 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE, null));

            transactionRepository.save(new Transaction(null, 2000, null, TypeTransaction.Retrait, compte1));
            transactionRepository.save(new Transaction(null, 1000, null, TypeTransaction.Depot, compte1));
            transactionRepository.save(new Transaction(null, 500, null, TypeTransaction.Retrait, compte3));
        };
    }
}
