package nhn.rookieHAMATF.ryungjinkim_movie.repository;

import nhn.rookieHAMATF.ryungjinkim_movie.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
