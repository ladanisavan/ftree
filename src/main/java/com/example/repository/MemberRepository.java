package com.example.repository;

import com.example.model.Member;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberRepository")
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByFirstName(String firstName);

    @Query("SELECT m FROM Member m WHERE m.firstName LIKE :name% or m.lastName LIKE :name%")
    List<Member> findMemberByFirstNameOrLastName(@Param("name") String name);

    List<Member> findByGroups_id(Long id);

}
