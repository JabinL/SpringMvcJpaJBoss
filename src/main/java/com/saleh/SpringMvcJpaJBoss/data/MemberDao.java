package com.saleh.SpringMvcJpaJBoss.data;

import java.util.List;

import com.saleh.SpringMvcJpaJBoss.model.Member;

public interface MemberDao {
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
}
