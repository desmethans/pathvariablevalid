package org.example.pathvariablevalid;

import org.springframework.data.jpa.repository.JpaRepository;

interface PersonRepository extends JpaRepository<Person, Long> {
}
