package com.example.SpringStudy.repository.MemberRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.QMember;
import com.example.SpringStudy.web.dto.MemberInfoDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public MemberInfoDto findMemberInfoById(Long memberId) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MemberInfoDto.class,
                        member.name,
                        member.email,
                        member.phoneNumber,
                        member.point
                ))
                .from(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
