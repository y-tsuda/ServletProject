package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.StringUtils;

import vo.EmpValueObject;
import model.Emp;

public class EmpDao extends CommonMySQLDAO {

	public List<Emp> searchEmp(Emp w_emp) {
		List<Emp> retList = new ArrayList<Emp>();
		String id = w_emp.getId();
		String name = w_emp.getName();
		String sql = "SELECT * FROM emp LEFT OUTER JOIN code ON emp.grade = code.value " 
				+ " AND code.kbn = 1 WHERE del_flg = '0'";
		
		if (!StringUtils.isEmpty(id)) {
			sql = sql + " AND emp.id ='" + id + "'"; 
		}
		if (!StringUtils.isEmpty(name)){
			sql = sql + " AND emp.name LIKE '%" + name + "%'";
		}
		sql = sql + " ORDER BY emp.id";
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement;
		try {
			statement = getPreparedStatement(sql);

			// SQLを実行してその結果を取得する。
			ResultSet rs = statement.executeQuery();

			// 検索結果の行数分フェッチを行い、取得結果をValueObjectへ格納する
			while (rs.next()) {
				Emp emp = new Emp();

				// クエリー結果をVOへ格納(あらかじめクエリー結果とVOの変数名は一致させている)
				emp.setId(rs.getString("id"));
				emp.setName(rs.getString("emp.name"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setGrade(rs.getString("code.name"));
				emp.setSalary(rs.getInt("salary"));

				retList.add(emp);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return retList;
	}
	
	/**
	 * select処理
	 * @param id
	 * @return
	 */
	public EmpValueObject searchEmpById(String id) {
		//Emp emp = new Emp();
		EmpValueObject vo = new EmpValueObject();
		String sql = "SELECT * FROM emp WHERE id = ?";
		// プリペアステートメントを取得し、実行SQLを渡す
		PreparedStatement statement;
		try {
			statement = getPreparedStatement(sql);
			statement.setString(1, id);

			// SQLを実行してその結果を取得する。
			ResultSet rs = statement.executeQuery();
			rs.next();
			// クエリー結果をVOへ格納(あらかじめクエリー結果とVOの変数名は一致させている)
			//emp.setName(rs.getString("name"));
			vo.setName(rs.getString("name"));
			SimpleDateFormat format = new SimpleDateFormat(("yyyy/MM/dd"));
			String sDate = format.format(rs.getDate("hire_date"));
			vo.setHire_date(sDate);
			//Date dDate = format.parse(sDate);
			//emp.setHireDate(dDate);
			vo.setGrade(rs.getString("grade"));
			vo.setSalary(rs.getInt("salary"));
			vo.setUpdate_date(rs.getTimestamp("update_date"));
			vo.setId(Integer.valueOf(id));
			vo.setDel_flg(rs.getString("del_flg"));

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return vo;
	}
	
	/**
	 * 登録処理
	 * @param vo
	 */
	public void entryEmp(EmpValueObject vo) {
		String sql = "INSERT INTO emp(name, hire_date, grade, salary, create_date, update_date, del_flg) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, vo.getName());
			statement.setString(2, vo.getHire_date());
			statement.setString(3, vo.getGrade());
			statement.setInt(4, vo.getSalary());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			statement.setTimestamp(5, timestamp);
			statement.setTimestamp(6, timestamp);
			statement.setString(7, "0");
			statement.executeUpdate();
			super.commit();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
			
	}

	public void updateEmp(EmpValueObject vo) {
		String sql = "update emp set name= ?, hire_date=?, grade=?, salary=? ,update_date= ?, del_flg = ? where id= ?";

		try {
			PreparedStatement statement = getPreparedStatement(sql);
			statement.setString(1, vo.getName());
			statement.setString(2, vo.getHire_date());
			statement.setString(3, vo.getGrade());
			statement.setInt(4, vo.getSalary());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			statement.setTimestamp(5, timestamp);
			statement.setString(6, vo.getDel_flg());
			statement.setInt(7, vo.getId());
			statement.executeUpdate();
			super.commit();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

	}

}
