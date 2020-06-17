package ro.iteahome.nhs.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.iteahome.nhs.backend.model.entity.institution.Institution;

import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

    Institution getById(int id);

    Optional<Institution> findByCui(String cui);

    Institution getByCui(String cui);

    boolean existsByCui(String cui);
}
