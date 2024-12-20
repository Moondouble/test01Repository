package jspMVCMisoShopping.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspMVCMisoShopping.model.dto.InquireDTO;

public class InquireDAO extends DataBaseInfo{
	public List<InquireDTO> inquireSelectAll(String goodsNum){
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = " select inquire_num,member_num,goods_num,inquire_subject, "
				+ " inquire_contents,inquire_kind,inquire_date,inquire_answer, "
				+ " inquire_answer_date,emp_num "
				+ " from inquire "
				+ "	where goods_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				InquireDTO dto = new InquireDTO();
				dto.setEmpNum(rs.getString("emp_num"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireAnswer(rs.getString("inquire_answer"));
				dto.setInquireContent(rs.getString("INQUIRE_CONTENT"));
				dto.setInquireDate(rs.getDate("inquire_date"));
				dto.setInquireKind(rs.getString("inquire_kind"));
				dto.setInquireNum(rs.getLong("INQUIRE_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setInquireAnswerDate(rs.getDate("inquire_answer_date"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		return list;
	}
	
public void inquireInsert(InquireDTO dto) {
	con = getConnection();
	sql = " insert into inquire(inquire_num, member_num, goods_num, inquire_subject, "
			+ " inquire_contents, inquire_kind, inquire_date) "
			+ " values(review_seq.nextval,?,?,?,?,?,sysdate)";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getMemberNum());
		pstmt.setString(2, dto.getGoodsNum());
		pstmt.setString(3, dto.getInquireSubject());
		pstmt.setString(4, dto.getInquireContent());
		pstmt.setString(5, dto.getInquireKind());
		int i = pstmt.executeUpdate();
		System.out.println(i+"개가 삽입되었습니다.");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}
}
}
