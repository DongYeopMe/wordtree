package com.wordtree.member.dto;

import com.wordtree.member.Member;
import com.wordtree.word.Word;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class MemberResponse {
    private String userid;
    private String username;

    public MemberResponse(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public static MemberResponse memberConvert(Member member){
        return new MemberResponse(member.getUsername(),member.getUserid());
    }
}
