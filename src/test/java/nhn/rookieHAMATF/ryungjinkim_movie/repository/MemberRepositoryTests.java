package nhn.rookieHAMATF.ryungjinkim_movie.repository;

import nhn.rookieHAMATF.ryungjinkim_movie.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired MemberRepository memberRepository;

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1, 100).forEach(i->{
            Member member = Member.builder()
                    .email("r"+i+"@zerock.org")
                    .pw("1111")
                    .nickname("reviewer"+i)
                    .build();
            memberRepository.save(member);
        });
    }
}
