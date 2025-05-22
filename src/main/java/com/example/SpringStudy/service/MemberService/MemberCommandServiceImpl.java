package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.SpringStudy.converter.MemberConverter;
import com.example.SpringStudy.converter.MemberPreferConverter;
import com.example.SpringStudy.domain.FoodCategory;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.mapping.MemberPrefer;
import com.example.SpringStudy.repository.FoodCategoryRepository.FoodCategoryRepository;
import com.example.SpringStudy.repository.MemberAgreeRepository.MemberAgreeRepository;
import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.repository.MemberPreferRepository.MemberPreferRepository;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.SpringStudy.apiPayload.code.status.ErrorStatus.FOOD_CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final MemberPreferRepository memberPreferRepository;
    private final MemberAgreeRepository memberAgreeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberConverter memberConverter;
    private final MemberPreferConverter memberPreferConverter;


    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        memberPreferRepository.deleteByMemberId(memberId);
        memberAgreeRepository.deleteByMemberId(memberId);
        memberMissionRepository.deleteByMemberId(memberId);

        memberRepository.deleteById(memberId);
    }

    @Override
    public MemberInfoResponseDto getMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoById(memberId);
    }

    @Transactional
    @Override
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member member = memberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category ->{
                    return foodCategoryRepository.findById(category).orElseThrow(()->new FoodCategoryHandler(FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = memberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(member);});
        return memberRepository.save(member);
    }
}
