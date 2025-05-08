package com.example.SpringStudy.repository.MemberRepository;

import com.example.SpringStudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
