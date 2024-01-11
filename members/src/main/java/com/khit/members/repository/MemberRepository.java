package com.khit.members.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.khit.members.dto.MemberDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class MemberRepository {
	
	private SqlSessionTemplate sql;

	public void insert(MemberDTO memberDTO) {
		sql.insert("Member.insert", memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}

	public MemberDTO findByEmail(String sessionEmail) {
		return sql.selectOne("Member.findByEmail", sessionEmail);
	}

	public void update(MemberDTO memberDTO) {
		sql.update("Member.update", memberDTO);
	}

	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	}

	public MemberDTO findById(Long id) {
		return sql.selectOne("Member.findById",id);
	}

	public void delete(Long id) {
		sql.delete("Member.delete", id);
	}
	
}
