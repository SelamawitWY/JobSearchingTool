package miu.cs.cs544.selam.jobsearchingtool.company.repository;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
